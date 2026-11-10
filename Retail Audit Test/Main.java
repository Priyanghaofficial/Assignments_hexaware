
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<Order> orders=new ArrayList<>();

        Scanner file=new Scanner(new File("orders.csv"));

        file.nextLine();

        while(file.hasNextLine()) {

            String line=file.nextLine();

            if(line.trim().isEmpty())
                continue;

            String data[]=line.split(",");

            int id=Integer.parseInt(data[0]);
            String customer=data[1];
            double amount=Double.parseDouble(data[2]);
            String date=data[3];

            orders.add(new Order(id,customer,amount,date));
        }

        file.close();

        System.out.println("Total Orders Loaded: "+orders.size());

        Scanner sc=new Scanner(System.in);

        while(true) {

            System.out.println("\n--- RETAIL ORDER DESK ---");
            System.out.println("1. Searching");
            System.out.println("2. Sorting");
            System.out.println("3. Duplicate Detection");
            System.out.println("4. Stack and Queue");
            System.out.println("5. Refund");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice=sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter Order ID: ");
                    int id=sc.nextInt();

                    ArrayList<Order> searchOrders=new ArrayList<>();

                    for(int i=0;i<Math.min(50000,orders.size());i++)
                        searchOrders.add(orders.get(i));

                    Searching.search(searchOrders,id);
                    break;

                case 2:
                    Sorting.sort(orders);
                    break;

                case 3:
                    DuplicateDetection.findDuplicates(orders);
                    break;

                case 4:
                    StackQueue.run();
                    break;

                case 5:
                    System.out.print("Enter Refund Amount: ");
                    int amount=sc.nextInt();

                    Refund.calculate(amount);
                    break;

                case 0:
                    System.out.println("Program Ended");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
