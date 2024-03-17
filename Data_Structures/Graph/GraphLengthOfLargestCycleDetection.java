import java.util.*;
public class GraphLengthOfLargestCycleDetection {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    public GraphLengthOfLargestCycleDetection(int v){
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }
    }
    public void addEdges(int src,int des){
        adj.get(src).add(des);
        adj.get(des).add(src);
    }
    public int findLongestCycle(){
        int result=-1;
        for(int i=0;i<adj.size();i++){
            int[] parent=new int[adj.size()];
            Arrays.fill(parent,-1);
            boolean[] visited=new boolean[adj.size()];
            result=Math.max(result,dfs(i,i,parent,visited));
        }
        return result;
    }
    public int dfs(int start,int current,int[] parent,boolean[] visited){
        visited[current]=true;
        int maxLength=-1;
        for(int visit:adj.get(current)){
            if(!visited[visit]){
                parent[visit]=current;
                maxLength=Math.max(maxLength,dfs(start,visit,parent,visited));
            }
            else if(visit!=parent[current] && visit==start){
                maxLength=Math.max(maxLength,getPathLength(start,current,parent));
            }
        }
        visited[current]=false;
        return maxLength;
    }
    public int getPathLength(int start,int end,int[] parent){
        int length=1;
        while(end!=start){
            length++;
            end=parent[end];
        }
        return length;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter number of vertices: ");
        int vertices=in.nextInt();
        System.out.println("Enter number of edges: ");
        int edges=in.nextInt();
        GraphLengthOfLargestCycleDetection graph=new GraphLengthOfLargestCycleDetection(vertices);
        for(int i=0;i<edges;i++){
            int src=in.nextInt();
            int dest=in.nextInt();
            graph.addEdges(src-1,dest-1);
        }
        int longestCycle=graph.findLongestCycle();
        if(longestCycle==-1){
            System.out.println("No longest cycle found");
        }
        else{
            System.out.println(longestCycle);
        }
        in.close();
    }
}
