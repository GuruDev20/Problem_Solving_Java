import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        left=right=null;
    }
}
public class InsertionBST {
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
    public void preorder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data+" ");
        inorder(node.left);
        inorder(node.right);
    }
    public void postorder(Node node){
        if(node==null){
            return;
        }
        inorder(node.left);
        inorder(node.right);
        System.out.print(node.data+" ");
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        InsertionBST obj=new InsertionBST();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            root=obj.insert(root,in.nextInt());
        }
        obj.inorder(root);
        obj.preorder(root);
        obj.postorder(root);
        in.close();
    }
}
