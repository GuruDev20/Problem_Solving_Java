package Data_Structures.Graph;
import java.util.*;
public class GraphBFS {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    public GraphBFS(int v){
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
    public void bfs(int start){
        int V=adj.size();
        boolean[] visited=new boolean[V];
        visited[start]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        while(q.size()!=0){
            int vertex=q.remove();
            System.out.print(vertex+" ");
            for(int i=0;i<adj.get(vertex).size();i++){
                int visit=adj.get(vertex).get(i);
                if(!visited[visit]){
                    q.add(visit);
                    visited[visit]=true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter number of vertices: ");
        int vertices=in.nextInt();
        System.out.println("Enter number of edges: ");
        int edges=in.nextInt();
        GraphBFS graph=new GraphBFS(vertices);
        for(int i=0;i<edges;i++){
            graph.addEdges(in.nextInt(),in.nextInt());
        }
        System.out.println("Enter starting vertex: ");
        int start=in.nextInt();
        System.out.println("BFS Traversal");
        graph.bfs(start);
        System.out.println();
        graph.display();
        in.close();
    }
}
