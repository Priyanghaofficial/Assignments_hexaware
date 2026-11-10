
import java.util.*;

public class Sorting {

    public static void sort(ArrayList<Order> orders) {

        int n=10000;

        if(orders.size()<n)
            n=orders.size();

        ArrayList<Order> data=new ArrayList<>(orders.subList(0,n));

        Order arr[]=data.toArray(new Order[0]);

        // Bubble Sort
        long start=System.nanoTime();

        for(int i=0;i<n-1;i++) {

            for(int j=0;j<n-i-1;j++) {

                if(arr[j].amount<arr[j+1].amount) {

                    Order temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }

            if(i<3) {
                System.out.println("Bubble Sort Pass "+(i+1));
                for(int k=0;k<Math.min(5,n);k++)
                    System.out.print(arr[k].amount+" ");
                System.out.println();
            }
        }

        long end=System.nanoTime();
        System.out.println("Bubble Sort Time: "+(end-start)+" ns");


        // Merge Sort
        Order arr2[]=data.toArray(new Order[0]);

        start=System.nanoTime();

        mergeSort(arr2,0,n-1);

        end=System.nanoTime();
        System.out.println("Merge Sort Time: "+(end-start)+" ns");


        // Built-in Sort
        Order arr3[]=data.toArray(new Order[0]);

        start=System.nanoTime();

        Arrays.sort(arr3,(a,b)->Double.compare(b.amount,a.amount));

        end=System.nanoTime();
        System.out.println("Built-in Sort Time: "+(end-start)+" ns");

        System.out.println("Top 3 Orders:");

        for(int i=0;i<Math.min(3,n);i++)
            System.out.println(arr3[i].orderId+" "+arr3[i].amount);
    }


    static void mergeSort(Order arr[],int left,int right) {

        if(left<right) {

            int mid=(left+right)/2;

            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);

            merge(arr,left,mid,right);
        }
    }


    static void merge(Order arr[],int left,int mid,int right) {

        Order temp[]=new Order[right-left+1];

        int i=left;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=right) {

            if(arr[i].amount>=arr[j].amount)
                temp[k++]=arr[i++];
            else
                temp[k++]=arr[j++];
        }

        while(i<=mid)
            temp[k++]=arr[i++];

        while(j<=right)
            temp[k++]=arr[j++];

        for(i=0;i<temp.length;i++)
            arr[left+i]=temp[i];
    }
}
