import java.util.*;
public class DistanceBetweenTwoNodes {
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
    public int findDistance(Node root,int a,int b){
        if(root==null){
            return -1;
        }
        Node lca=findAncestor(root,a,b);
        int distanceA=findDistanceFromNode(lca,a,0);
        int distanceB=findDistanceFromNode(lca,b,0);
        if(distanceA==-1 || distanceB==-1){
            return -1;
        }
        return distanceA+distanceB;
    }
    public Node findAncestor(Node root,int a,int b){
        if(root==null || root.data==a || root.data==b){
            return root;
        }
        Node leftLCA=findAncestor(root.left, a, b);
        Node rightLCA=findAncestor(root.right, a, b);
        if(leftLCA!=null && rightLCA!=null){
            return root;
        }
        return (leftLCA!=null)?leftLCA:rightLCA;
    }
    public int findDistanceFromNode(Node node,int target,int distance){
        if(node==null){
            return -1;
        }
        if(node.data==target){
            return distance;
        }
        int leftDistance=findDistanceFromNode(node.left, target, distance+1);
        int rightDistance=findDistanceFromNode(node.right, target, distance+1);
        return (leftDistance!=-1)?leftDistance:rightDistance;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        DistanceBetweenTwoNodes obj=new DistanceBetweenTwoNodes();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            obj.insert(in.nextInt());
        }
        int a=in.nextInt();
        int b=in.nextInt();
        int distance=obj.findDistance(root,a,b);
        System.out.println(distance);
        in.close();
    }
}
