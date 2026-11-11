import java.util.*;
public class task2_hashing{
    static class Entry{
        String key;
        String value;
        Entry(String key,String value){
            this.key=key;
            this.value=value;
        }
    }
    static class CustomHashTable{
        ArrayList<Entry>[] buckets;
        @SuppressWarnings("unchecked")
        CustomHashTable(int capacity){
            buckets=new ArrayList[capacity];
            for(int i=0;i<capacity;i++){
                buckets[i]=new ArrayList<>();
            }
        }
        int bucketIndex(String key){
            return Math.floorMod(key.hashCode(),buckets.length);
        }
        void put(String key,String value){
            int index=bucketIndex(key);
            for(Entry entry:buckets[index]){
                if(entry.key.equals(key)){
                    entry.value=value;
                    return;
                }
            }
            buckets[index].add(new Entry(key,value));
        }
        String get(String key){
            int index=bucketIndex(key);
            for(Entry entry:buckets[index]){
                if(entry.key.equals(key)){
                    return entry.value;
                }
            }
            return null;
        }
        int chainLength(String key){
            return buckets[bucketIndex(key)].size();
        }
    }
    public static void main(String[] args){
        CustomHashTable collisionDemo=new CustomHashTable(10);
        String firstKey="SKU1";
        String secondKey=null;
        for(int i=2;i<10000;i++){
            String candidate="SKU"+i;
            if(collisionDemo.bucketIndex(candidate)==collisionDemo.bucketIndex(firstKey)){
                secondKey=candidate;
                break;
            }
        }
        collisionDemo.put(firstKey,"Wireless Mouse");
        collisionDemo.put(secondKey,"USB Keyboard");
        System.out.println("Collision demonstration:");
        System.out.println(firstKey+" and "+secondKey+" use bucket "+collisionDemo.bucketIndex(firstKey));
        System.out.println("Items in that chain: "+collisionDemo.chainLength(firstKey));
        int count=100000;
        CustomHashTable customTable=new CustomHashTable(200003);
        HashMap<String,String> builtInMap=new HashMap<>(150000);
        String[] keys=new String[count];
        for(int i=0;i<count;i++){
            keys[i]=String.format("SKU%06d",i);
            String product="Product"+i;
            customTable.put(keys[i],product);
            builtInMap.put(keys[i],product);
        }
        long startCustom=System.nanoTime();
        for(String key:keys){
            customTable.get(key);
        }
        long customTime=System.nanoTime()-startCustom;
        long startBuiltIn=System.nanoTime();
        for(String key:keys){
            builtInMap.get(key);
        }
        long builtInTime=System.nanoTime()-startBuiltIn;
        System.out.println();
        System.out.println("Lookup comparison for "+count+" SKUs:");
        System.out.printf("Custom hash table: %.3f ms%n",customTime/1000000.0);
        System.out.printf("Java HashMap: %.3f ms%n",builtInTime/1000000.0);
        System.out.println("Custom table lookup example: "+customTable.get("SKU000123"));
        System.out.println("HashMap lookup example: "+builtInMap.get("SKU000123"));
    }
}
