
import java.util.*;

public class DuplicateDetection {

    public static void findDuplicates(ArrayList<Order> orders) {

        HashMap<String,Integer> map=new HashMap<>();

        int count=0;

        for(int i=0;i<orders.size();i++) {

            Order o=orders.get(i);

            String key=o.customerId+"|"+o.amount+"|"+o.createdAt;

            if(map.containsKey(key)) {

                System.out.println("Duplicate Order ID: "+o.orderId);
                System.out.println("Original Order ID: "+map.get(key));

                count++;
            }
            else {
                map.put(key,o.orderId);
            }
        }

        System.out.println("Total Duplicates: "+count);
    }
}
