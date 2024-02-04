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
public class PostOrderToBST {
    public static Node root=null;
    public Node constructBST(int[] a,int start,int end){
        if(start>end){
            return null;
        }
        Node node=new Node(a[end]);
        int i;
        for(i=end;i>=start;i--){
            if(a[i]<node.data){
                break;
            }
        }
        node.right=constructBST(a,i+1,end-1);
        node.left=constructBST(a,start,i);
        return node;
    }
    public void insert(int[] a){
        root=constructBST(a,0,a.length-1);
    }
    public void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] str=in.nextLine().split(", ");
        int[] a=new int[str.length];
        PostOrderToBST obj=new PostOrderToBST();
        for(int i=0;i<str.length;i++){
            a[i]=Integer.parseInt(str[i]);
        }
        obj.insert(a);
        obj.inorder(root);
        in.close();
    }
}
