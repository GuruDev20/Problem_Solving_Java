import java.util.*;
public class StronglyConnected {
     ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    public StronglyConnected(int v){
        for(int i=0;i<=v;i++){
            adj.add(new ArrayList<Integer>());
        }
    }
    public void addEdges(int src,int des){
        adj.get(src).add(des);
    }
    public void dfsUtil(int v,boolean[] visited,Stack<Integer> stack){
        visited[v]=true;
        for(int i:adj.get(v)){
            if(!visited[i]){
                dfsUtil(i,visited,stack);
            }
        }
        stack.push(v);
    }
    public ArrayList<ArrayList<Integer>> transposeGraph(){
        ArrayList<ArrayList<Integer>> transpose=new ArrayList<>();
        for(int i=0;i<adj.size();i++){
            transpose.add(new ArrayList<Integer>());
        }
        for(int i=1;i<adj.size();i++){
            for(int j:adj.get(i)){
                transpose.get(j).add(i);
            }
        }
        return transpose;
    }
    public boolean isStrong(){
        boolean[] visited=new boolean[adj.size()];
        int vertices=adj.size()-1;
        Stack<Integer> stack=new Stack<>();
        for(int i=1;i<=vertices;i++){
            if(!visited[i]){
                dfsUtil(i,visited,stack);
            }
        }
        @SuppressWarnings("unused")
        ArrayList<ArrayList<Integer>> transpose=transposeGraph();
        Arrays.fill(visited,false);
        dfsUtil(stack.pop(),visited,new Stack<>());
        for(int i=1;i<=vertices;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int vertices=in.nextInt();
        int edges=in.nextInt();
        StronglyConnected graph=new StronglyConnected(vertices);
        for(int i=0;i<edges;i++){
            graph.addEdges(in.nextInt(),in.nextInt());
        }
        System.out.println(graph.isStrong()?"YES":"NO");
        in.close();
    }
}
