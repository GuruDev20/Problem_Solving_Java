import java.util.*;
public class ValidBST{
    class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    private static Node root=null;
    public Node insert(Node node,int data){
        if(node==null){
            node=new Node(data);
        }
        else if(data<node.data){
            node.left=insert(node.left,data);
        }
        else if(data>node.data){
            node.right=insert(node.right,data);
        }
        return node;
    }
    public void inorder(Node node){
        if(node==null){
            return;
        }
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }
    public static boolean isValid(Node node){
        return checkvalid(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public static boolean checkvalid(Node node,int min,int max){
        if(node==null){
            return true;
        }
        if(node.data<=min || node.data>=max){
            return false;
        }
        return checkvalid(node.left,min,node.data) && checkvalid(node.right,node.data,max);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        ValidBST obj=new ValidBST();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            root=obj.insert(root,in.nextInt());
        }
        obj.inorder(root);
        if(isValid(root)){
            System.out.println("Calid BST");
        }
        else{
            System.out.println("Invalid BST");
        }
        in.close();
    }
}