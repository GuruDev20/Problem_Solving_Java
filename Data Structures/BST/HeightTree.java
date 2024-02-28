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
public class HeightTree {
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
    }
    public int getHeight(){
        return findHeight(root);
    }
    public int findHeight(Node node){
        if(node==null){
            return 0;
        }
        else{
            int leftHeight=findHeight(node.left);
            int rightHeight=findHeight(node.right);
            return Math.max(leftHeight,rightHeight)+1;
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        HeightTree obj=new HeightTree();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            root=obj.insert(root,in.nextInt());
        }
        obj.display(root);
        System.out.println();
        int val=obj.getHeight();
        System.out.println(val);
        in.close();
    }
}