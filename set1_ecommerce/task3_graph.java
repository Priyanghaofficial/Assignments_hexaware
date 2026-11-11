import java.util.*;
public class task3_graph{
    static void addEdge(Map<String,List<String>> graph,String from,String to){
        graph.get(from).add(to);
    }
    static List<String> topologicalBFS(Map<String,List<String>> graph){
        Map<String,Integer> indegree=new LinkedHashMap<>();
        for(String node:graph.keySet()){
            indegree.put(node,0);
        }
        for(String node:graph.keySet()){
            for(String neighbor:graph.get(node)){
                indegree.put(neighbor,indegree.get(neighbor)+1);
            }
        }
        ArrayDeque<String> queue=new ArrayDeque<>();
        for(String node:indegree.keySet()){
            if(indegree.get(node)==0){
                queue.offer(node);
            }
        }
        List<String> order=new ArrayList<>();
        while(!queue.isEmpty()){
            String node=queue.poll();
            order.add(node);
            for(String neighbor:graph.get(node)){
                indegree.put(neighbor,indegree.get(neighbor)-1);
                if(indegree.get(neighbor)==0){
                    queue.offer(neighbor);
                }
            }
        }
        return order;
    }
    static boolean hasCycleDFS(Map<String,List<String>> graph){
        Map<String,Integer> state=new HashMap<>();
        for(String node:graph.keySet()){
            state.put(node,0);
        }
        for(String node:graph.keySet()){
            if(state.get(node)==0&&cycleFrom(node,graph,state)){
                return true;
            }
        }
        return false;
    }
    static boolean cycleFrom(String node,Map<String,List<String>> graph,Map<String,Integer> state){
        state.put(node,1);
        for(String neighbor:graph.get(node)){
            if(state.get(neighbor)==1){
                return true;
            }
            if(state.get(neighbor)==0&&cycleFrom(neighbor,graph,state)){
                return true;
            }
        }
        state.put(node,2);
        return false;
    }
    static Map<String,List<String>> copyGraph(Map<String,List<String>> graph){
        Map<String,List<String>> copy=new LinkedHashMap<>();
        for(String node:graph.keySet()){
            copy.put(node,new ArrayList<>(graph.get(node)));
        }
        return copy;
    }
    public static void main(String[] args){
        Map<String,List<String>> graph=new LinkedHashMap<>();
        graph.put("cart",new ArrayList<>());
        graph.put("pricing",new ArrayList<>());
        graph.put("inventory",new ArrayList<>());
        graph.put("payment",new ArrayList<>());
        graph.put("shipping",new ArrayList<>());
        graph.put("notification",new ArrayList<>());
        addEdge(graph,"cart","pricing");
        addEdge(graph,"pricing","inventory");
        addEdge(graph,"cart","payment");
        addEdge(graph,"payment","shipping");
        addEdge(graph,"inventory","shipping");
        addEdge(graph,"shipping","notification");
        List<String> order=topologicalBFS(graph);
        System.out.println("Valid deployment order: "+order);
        System.out.println("Cycle detected: "+hasCycleDFS(graph));
        Map<String,List<String>> cyclicGraph=copyGraph(graph);
        addEdge(cyclicGraph,"notification","cart");
        System.out.println("After adding notification -> cart:");
        System.out.println("Cycle detected: "+hasCycleDFS(cyclicGraph));
        System.out.println("Deployment order possible: "+(topologicalBFS(cyclicGraph).size()==cyclicGraph.size()));
    }
}
