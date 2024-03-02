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

    public LinkedHashSet<Node> findPathToNode(Node root, int data) {
        if (root == null){
            return null;
        }
        LinkedHashSet<Node> path = new LinkedHashSet<>();
        while (root != null) {
            path.add(root);
            if (root.data == data){
                break;
            }
            else if (data < root.data){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return path;
    }

    public LinkedHashSet<Node> findCommonAncestorPath(Node root, int a, int b) {
        if (root == null){
            return null;
        }
        LinkedHashSet<Node> pathToA = findPathToNode(root, a);
        LinkedHashSet<Node> pathToB = findPathToNode(root, b);
        if (pathToA == null || pathToB == null){
            return null;
        }
        pathToA.retainAll(pathToB);
        return pathToA;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CommonAncestor obj = new CommonAncestor();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            obj.insert(in.nextInt());
        }
        int a = in.nextInt();
        int b = in.nextInt();
        LinkedHashSet<Node> commonPath = obj.findCommonAncestorPath(root, a, b);
        if (commonPath != null) {
            System.out.println("Common Ancestor Path:");
            for (Node node : commonPath) {
                System.out.print(node.data + " ");
            }
        } else {
            System.out.println("Nodes not found.");
        }
        in.close();
    }
}
