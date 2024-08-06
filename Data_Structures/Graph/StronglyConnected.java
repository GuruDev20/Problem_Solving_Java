import java.util.*;
public class StronglyConnected{
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    public StronglyConnected(int v){
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }
    }
    public void addEdges(int src,int des){
        adj.get(src).add(des);
    }
    public void dfs(int start,boolean[] visited){
        visited[start]=true;
        for(int i:adj.get(start)){
            if(!visited[i]){
                dfs(i,visited);
            }
        }
    }
    public boolean isStrong(boolean[] visited){
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int vertices=in.nextInt();
        StronglyConnected s=new StronglyConnected(vertices);
        int edges=in.nextInt();
        for(int i=0;i<edges;i++){
            s.addEdges(in.nextInt(),in.nextInt());
        }
        in.close();
        for(int i=0;i<vertices;i++){
            boolean[] visited=new boolean[vertices];
            s.dfs(i,visited);
            if(!s.isStrong(visited)){
                System.out.println("Not Strongly Connected");
                return;
            }
        }
        System.out.println("Strongly Connected");
    }
}