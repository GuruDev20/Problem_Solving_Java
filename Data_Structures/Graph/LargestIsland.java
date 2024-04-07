import java.util.*;
public class LargestIsland {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    public LargestIsland(int v){
        for(int i=0;i<=v;i++){
            adj.add(new ArrayList<Integer>());
        }
    }
    public void addEdges(int src,int des){
        adj.get(src).add(des);
    }
    public int dfsUtil(boolean[] visited,int v){
        visited[v]=true;
        int size=1;
        for(int i:adj.get(v)){
            if(!visited[i]){
                size+=dfsUtil(visited,i);
            }
        }
        return size;
    }
    public int largestIsland(){
        boolean[] visited=new boolean[adj.size()];
        int max=0;
        for(int i=1;i<adj.size();i++){
            if(!visited[i]){
                int size=dfsUtil(visited,i);
                if(size>max){
                    max=size;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int vertices=in.nextInt();
        int edges=in.nextInt();
        LargestIsland graph=new LargestIsland(vertices);
        for(int i=0;i<edges;i++){
            graph.addEdges(in.nextInt(),in.nextInt());
        }
        System.out.println(graph.largestIsland());
        in.close();
    }
}
