import java.util.*;
public class GraphDFS {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    public GraphDFS(int v){
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }
    }
    public void addEdges(int src,int des){
        adj.get(src).add(des);
        adj.get(des).add(src);
    }
    public void display(){
        for(int i=0;i<adj.size();i++){
            System.out.print("List of Vertex "+i+":");
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print(" "+adj.get(i).get(j));
            }
            System.out.println();
        }
    }
    public void dfs(int start){
        int V=adj.size();
        boolean[] visited=new boolean[V];
        dfsUtil(start,visited);
    }
    public void dfsUtil(int start,boolean[] visited){
        visited[start]=true;
        System.out.println(start+" ");
        for(int i=0;i<adj.get(start).size();i++){
            int visit=adj.get(start).get(i);
            if(!visited[visit]){
                dfsUtil(visit, visited);
            }
        }   
    }
     public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter number of vertices: ");
        int vertices=in.nextInt();
        System.out.println("Enter number of edges: ");
        int edges=in.nextInt();
        GraphDFS graph=new GraphDFS(vertices);
        for(int i=0;i<edges;i++){
            graph.addEdges(in.nextInt(),in.nextInt());
        }
        System.out.println("Enter starting vertex: ");
        int start=in.nextInt();
        System.out.println("DFS Traversal");
        graph.dfs(start);
        System.out.println();
        graph.display();
        in.close();
    }
}
