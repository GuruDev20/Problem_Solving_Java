import java.util.*;
public class RightViewBST {
    class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            left=right=null;
        }
    }
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

    public void rightView() {
        rightView(root, 1);
    }

    public void rightView(Node root, int level) {
        if (root == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        rightView(root.right, level + 1);
        rightView(root.left, level + 1);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        RightViewBST obj=new RightViewBST();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            obj.insert(in.nextInt());
        }
        obj.rightView();
        in.close();
    }
}
