import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
        left=right=null;
    }
}
public class LeftViewBST {
    public static Node root=null;
    public void insert(int data){
        root=insertRec(root,data);
    }
    public Node insertRec(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else if(data<root.data){
            root.left=insertRec(root.left, data);
        }
        else if(data>root.data){
            root.right=insertRec(root.right, data);
        }
        return root;
    }
    int maxLevel = 0;
    public void leftView() {
        leftView(root, 1);
    }
    public void leftView(Node root, int level) {
        if (root == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        leftView(root.left, level + 1);
        leftView(root.right, level + 1);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        LeftViewBST obj=new LeftViewBST();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            obj.insert(in.nextInt());
        }
        obj.leftView();
        in.close();
    }
}
