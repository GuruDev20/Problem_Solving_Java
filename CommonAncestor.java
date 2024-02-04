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
public class CommonAncestor {
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
    public Node findCommonAncestor(Node root,int a,int b){ 
        if(root==null){
            return null;
        }
        if(root.data>a && root.data>b){
            return findCommonAncestor(root.left, a, b);
        }
        else if(root.data< a && root.data<b){
            return findCommonAncestor(root.right, a, b);
        }
        else{
            return root;
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        CommonAncestor obj=new CommonAncestor();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            obj.insert(in.nextInt());
        }
        int a=in.nextInt();
        int b=in.nextInt();
        Node common=obj.findCommonAncestor(root,a,b);
        System.out.println(common.data);
        in.close();
    }
}
