import java.util.*;
public class GraphCycleContainsOrNot {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    public GraphCycleContainsOrNot(int v){
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }
    }
    public void addEdges(int src,int des){
        adj.get(src).add(des);
    }
    public boolean isCyclic(){
        boolean[] visited=new boolean[adj.size()];
        boolean[] rec=new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(isCyclicUtil(i,visited,rec)){
                return true;
            }
        }
        return false;
    }
    public boolean isCyclicUtil(int v,boolean[] visited,boolean[] rec){
        if(!visited[v]){
            visited[v]=true;
            rec[v]=true;
            for(int visit:adj.get(v)){
                if(!visited[visit] && isCyclicUtil(visit,visited,rec)){
                    return true;
                }
                else if(rec[visit]){
                    return true;
                }
            }
        }
        rec[v]=false;
        return false;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter number of vertices: ");
        int vertices=in.nextInt();
        System.out.println("Enter number of edges: ");
        int edges=in.nextInt();
        GraphCycleContainsOrNot graph=new GraphCycleContainsOrNot(vertices);
        for(int i=0;i<edges;i++){
            graph.addEdges(in.nextInt(),in.nextInt());
        }
        if(graph.isCyclic()){
            System.out.print("true");
        }
        else{
            System.out.print("false");
        }
        in.close();
    }
}
