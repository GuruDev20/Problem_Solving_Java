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
    public void leftView(){
        leftView(root);
    }
    public void leftView(Node root){
        if(root==null){
            return;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node current=queue.poll();
                if(i==0){
                    System.out.print(current.data+" ");
                }
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
            }
        }
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
