package Data_Structures.Graph;
import java.util.*;
public class AllPathsFromSource {
    public static void dfs(int[][] graph,int v,List<Integer> temp,List<List<Integer>> res){
        if(v==graph.length-1){
            res.add(new ArrayList<>(temp));
        }
        for(int i:graph[v]){
            temp.add(i);
            dfs(graph,i,temp,res);
            temp.remove(temp.size()-1);
        }
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        temp.add(0);
        dfs(graph,0,temp,res);
        return res;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[][] graph=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                graph[i][j]=in.nextInt();
            }
        }
        in.close();
        List<List<Integer>> res=allPathsSourceTarget(graph);
        System.out.println(res);
    }
}