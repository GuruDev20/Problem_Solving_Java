
import java.util.*;
public class CountOfConnectedComponents {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    public CountOfConnectedComponents(int v){
        for(int i=0;i<=v;i++){
            adj.add(new ArrayList<Integer>());
        }
    }
    public void addEdges(int src,int des){
        adj.get(src).add(des);
    }
    public void dfsUtil(boolean[] visited,int v){
        visited[v]=true;
        for(int i:adj.get(v)){
            if(!visited[i]){
                dfsUtil(visited,i);
            }
        }
    }
    public int countOfConnectedComponents(){
        boolean[] visited=new boolean[adj.size()];
        int count=0;
        for(int i=1;i<adj.size();i++){
            if(!visited[i]){
                dfsUtil(visited,i);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int vertices=in.nextInt();
        int edges=in.nextInt();
        CountOfConnectedComponents graph=new CountOfConnectedComponents(vertices);
        for(int i=0;i<edges;i++){
            graph.addEdges(in.nextInt(),in.nextInt());
        }
        System.out.println(graph.countOfConnectedComponents());
        in.close();
    }    
}
