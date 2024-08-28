package Data_Structures.Graph;
import java.util.*;
public class CountOfCompleteConnectedComponents {
    public static void dfs(List<List<Integer>> graph,int node,boolean[] visited,List<Integer> comp){
        visited[node]=true;
        comp.add(node);
        for(int visit:graph.get(node)){
            if(!visited[visit]){
                dfs(graph,visit,visited,comp);
            }
        }
    }
    public static boolean isComplete(List<Integer> k,List<List<Integer>> graph){
        int size=k.size();
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(!graph.get(k.get(i)).contains(k.get(j))){
                    return false;
                }
            }
        }
        return true;
    }
    public static int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited=new boolean[n];
        List<List<Integer>> components=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                List<Integer> comp=new ArrayList<>();
                dfs(graph,i,visited,comp);
                components.add(comp);
            }
        }
        int count=0;
        for(List<Integer> k:components){
            if(isComplete(k,graph)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[][] edges=new int[m][2];
        for(int i=0;i<m;i++){
            edges[i][0]=in.nextInt();
            edges[i][1]=in.nextInt();
        }
        System.out.println(countCompleteComponents(n,edges));
        in.close();
    }
}
