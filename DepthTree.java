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
public class DepthTree{
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
    public void display(Node node){
        if(node==null){
            return;
        }
        display(node.left);
        display(node.right);
        System.out.print(node.data+" ");
        System.out.println();
    }
    public int getDepth(int val){
        return findDepth(root,val,0);
    }
    public int findDepth(Node node,int val,int depth){
        if(node==null){
            return -1;
        }
        if(val==node.data){
            return depth;
        }
        else if(val<node.data){
            return findDepth(node.left, val, depth+1);
        }
        else{
            return findDepth(node.right, val, depth+1);
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        DepthTree obj=new DepthTree();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            root=obj.insert(root,in.nextInt());
        }
        obj.display(root);
        int val=obj.getDepth(in.nextInt());
        System.out.println(val);
        in.close();
    }
}