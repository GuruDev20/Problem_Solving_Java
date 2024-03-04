import java.util.*;
public class SpiralOrderTraversal {
    class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            left=right=null;
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
    public int treeHeight(Node node){
        if(node==null){
            return 0;
        }
        else{
            int leftHeight=treeHeight(node.left);
            int rightHeight=treeHeight(node.right);
            return Math.max(leftHeight,rightHeight)+1;
        }
    }
    public void printSpiralOrder(Node node,int level,boolean reverse){
        if(node==null){
            return; 
        }
        if(level==1){
            System.out.print(node.data+" ");
        }
        else{
            if(!reverse){
                printSpiralOrder(node.left,level-1,reverse);
                printSpiralOrder(node.right,level-1,reverse);
            }
            else{
                printSpiralOrder(node.right,level-1,reverse);
                printSpiralOrder(node.left,level-1,reverse);
            }
        }

    }
    public void spiralOrder(Node node){
        int height=treeHeight(root);
        for(int i=1;i<=height;i++){
            printSpiralOrder(root,i,i%2!=0);
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        SpiralOrderTraversal obj=new SpiralOrderTraversal();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            root=obj.insert(root,in.nextInt());
        }
        System.out.println("Inorder Traversal");
        obj.inorder(root);
        System.out.println();
        System.out.println("Spiral Order Traversal");
        obj.spiralOrder(root);
        in.close();
    }
}