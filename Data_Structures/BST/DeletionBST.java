import java.util.*;
public class DeletionBST {
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
    public void deleteRec(int val){
        root=deleteNode(root,val);
    }
    public Node deleteNode(Node node,int val){
        if(node==null){
            return node;
        }
        if(val<node.data){
            node.left=deleteNode(node.left,val);
        }
        else if(val>node.data){
            node.right=deleteNode(node.right,val);
        }
        else{
            if(node.left==null){
                return node.right;
            }
            else if(node.right==null){
                return node.left;
            }
            node.data=minValue(node.right);
            node.right=deleteNode(node.right,node.data);
        }
        return node;
    }
    public static int minValue(Node node){
        int min=node.data;
        while(node.left!=null){
            min=node.left.data;
            node=node.left;
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        DeletionBST obj=new DeletionBST();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            root=obj.insert(root,in.nextInt());
        }
        obj.inorder(root);
        int val=in.nextInt();
        obj.deleteRec(val);
        obj.inorder(root);
        in.close();
    }
}

//40 30 75 45 60 10 15 7 12 62 47 38


//level order traversal ....

//spiral traversal

//left view  .....
 
//right view  ....

//common ancestors  ....

//lowest common ancestors

//distance between two nodes ....