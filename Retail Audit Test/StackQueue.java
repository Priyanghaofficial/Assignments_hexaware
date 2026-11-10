
import java.util.*;

public class StackQueue {

    public static void run() {

        // Custom Stack
        int stack[]=new int[100];
        int top=-1;

        stack[++top]=101;
        stack[++top]=102;
        stack[++top]=103;

        System.out.println("Custom Stack Undo: "+stack[top--]);


        // Built-in Stack
        Stack<Integer> s=new Stack<>();

        s.push(101);
        s.push(102);
        s.push(103);

        System.out.println("Java Stack Undo: "+s.pop());


        // Custom Queue
        int queue[]=new int[100];
        int front=0;
        int rear=-1;

        queue[++rear]=201;
        queue[++rear]=202;
        queue[++rear]=203;

        System.out.println("Custom Queue Dispatch: "+queue[front++]);


        // Built-in Queue
        Queue<Integer> q=new LinkedList<>();

        q.add(201);
        q.add(202);
        q.add(203);

        System.out.println("Java Queue Dispatch: "+q.remove());
    }
}
