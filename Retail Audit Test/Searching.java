
import java.util.*;

public class Searching {

    public static void search(ArrayList<Order> orders,int id) {

        int found=0;

        // Linear Search
        long start=System.nanoTime();

        for(int i=0;i<orders.size();i++) {

            if(orders.get(i).orderId==id) {
                found=1;
                break;
            }
        }

        long end=System.nanoTime();
        long linearTime=end-start;

        System.out.println("Linear Search:");

        if(found==1)
            System.out.println("Order Found");
        else
            System.out.println("Order Not Found");


        // Sorting for Binary Search
        ArrayList<Order> sorted=new ArrayList<>(orders);

        Collections.sort(sorted,(a,b)->Integer.compare(a.orderId,b.orderId));

        // Binary Search
        int low=0;
        int high=sorted.size()-1;
        found=0;

        start=System.nanoTime();

        while(low<=high) {

            int mid=(low+high)/2;

            if(sorted.get(mid).orderId==id) {
                found=1;
                break;
            }
            else if(sorted.get(mid).orderId<id) {
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }

        end=System.nanoTime();
        long binaryTime=end-start;

        System.out.println("\nBinary Search:");

        if(found==1)
            System.out.println("Order Found");
        else
            System.out.println("Order Not Found");


        // Time Comparison
        System.out.println("\nTime Comparison:");
        System.out.println("Linear Search: "+linearTime+" ns");
        System.out.println("Binary Search: "+binaryTime+" ns");

        if(linearTime<binaryTime)
            System.out.println("Linear Search is faster");
        else
            System.out.println("Binary Search is faster");
    }
}
