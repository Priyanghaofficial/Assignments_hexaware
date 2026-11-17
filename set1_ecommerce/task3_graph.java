

import java.util.*;
public class task3_graph{
    static ArrayList<Integer>[] graph=new ArrayList[4];
    static String[] names={"Cart","Pricing","Inventory","Payment"};

    static void bfs(int start){
        boolean[] visited=new boolean[4];
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            System.out.print(names[node]+" ");
            for(int next:graph[node]){
                if(!visited[next]){
                    visited[next]=true;
                    q.add(next);
                }
            }
        }
    }

    static void dfs(int node,boolean[] visited){
        visited[node]=true;
        System.out.print(names[node]+" ");
        for(int next:graph[node]){
            if(!visited[next]){
                dfs(next,visited);
            }
        }
    }

    static boolean cycle(int node,int[] state){
        state[node]=1;
        for(int next:graph[node]){
            if(state[next]==1)return true;
            if(state[next]==0&&cycle(next,state))return true;
        }
        state[node]=2;
        return false;
    }

    public static void main(String[] args){
        for(int i=0;i<4;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(1);
        graph[1].add(2);
        graph[2].add(3);
        graph[3].add(1);

        System.out.print("BFS: ");
        bfs(0);
        System.out.print("\nDFS: ");
        dfs(0,new boolean[4]);

        boolean hasCycle=false;
        int[] state=new int[4];
        for(int i=0;i<4;i++){
            if(state[i]==0&&cycle(i,state)){
                hasCycle=true;
                break;
            }
        }
        System.out.println("\nCircular dependency: "+hasCycle);
    }
}
