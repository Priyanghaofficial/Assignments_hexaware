import java.util.*;
public class task1_bst{
    static class Node{
        String value;
        Node left;
        Node right;
        Node(String value){
            this.value=value;
        }
    }
    static Node insert(Node root,String value){
        if(root==null){
            return new Node(value);
        }
        int result=value.compareToIgnoreCase(root.value);
        if(result<0){
            root.left=insert(root.left,value);
        }else if(result>0){
            root.right=insert(root.right,value);
        }
        return root;
    }
    static boolean search(Node root,String value){
        while(root!=null){
            int result=value.compareToIgnoreCase(root.value);
            if(result==0){
                return true;
            }
            root=result<0?root.left:root.right;
        }
        return false;
    }
    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.value+" ");
            inorder(root.right);
        }
    }
    static void preorder(Node root){
        if(root!=null){
            System.out.print(root.value+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    static void postorder(Node root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.value+" ");
        }
    }
    public static void main(String[] args){
        String[] categories={"Electronics","Clothing","Books","Home","Grocery","Sports","Beauty","Toys","Automotive","Furniture","Footwear","Kitchen","Mobile","Laptop","Accessories"};
        Node root=null;
        for(String category:categories){
            root=insert(root,category);
        }
        System.out.println("Inserted "+categories.length+" product categories.");
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();
        String target="Mobile";
        System.out.println("Search for "+target+": "+(search(root,target)?"Found":"Not found"));
    }
}
