

import java.util.*;
public class task2_hashing{
    static LinkedList<String>[] table=new LinkedList[10007];

    static int hash(String sku){
        return Math.abs(sku.hashCode()%table.length);
    }

    static void insert(String sku){
        int index=hash(sku);
        if(table[index]==null){
            table[index]=new LinkedList<>();
        }
        table[index].add(sku);
    }

    static boolean search(String sku){
        int index=hash(sku);
        return table[index]!=null&&table[index].contains(sku);
    }

    public static void main(String[] args){
        insert("SKU1");
        insert("SKU10008");
        System.out.println("SKU1 found: "+search("SKU1"));

        long start=System.nanoTime();
        for(int i=0;i<10000;i++){
            insert("SKU"+i);
        }
        for(int i=0;i<10000;i++){
            search("SKU"+i);
        }
        long end=System.nanoTime();

        System.out.println("Lookups completed: 10000");
        System.out.println("Time taken: "+(end-start)/1000000.0+" ms");
    }
}
