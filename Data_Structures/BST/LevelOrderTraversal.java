import java.util.*;
public class LevelOrderTraversal {
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
    public void printLevelOrder(Node node,int level){
        if(node==null){
            return; 
        }
        if(level==1){
            System.out.print(node.data+" ");
        }
        else{
            printLevelOrder(node.left,level-1);
            printLevelOrder(node.right,level-1);
        }
    }
    public void levelOrder(Node node){
        int height=treeHeight(root);
        for(int i=0;i<=height;i++){
            printLevelOrder(root,i);
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        LevelOrderTraversal obj=new LevelOrderTraversal();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            root=obj.insert(root,in.nextInt());
        }
        System.out.println("Inorder Traversal");
        obj.inorder(root);
        System.out.println();
        System.out.println("Level Order Traversal");
        obj.levelOrder(root);
        in.close();
    }
}