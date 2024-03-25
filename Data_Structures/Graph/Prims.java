import java.util.*;
public class Prims{
    private static int V;
    public static int minKey(int[] key,boolean[] prim){
        int min=Integer.MAX_VALUE,min_ind=-1;
        for(int v=0;v<V;v++){
            if(prim[v]==false && key[v]<min){
                min=key[v];
                min_ind=v;
            }
        }
        return min_ind;
    }
    public static int[] prims(int[][] graph){
        int[] parent=new int[V];
        int[] key=new int[V];
        boolean[] prim=new boolean[V];
        for(int i=0;i<V;i++){
            key[i]=Integer.MAX_VALUE;
            prim[i]=false;
        }
        key[0]=0;
        parent[0]=-1;
        for(int i=0;i<V-1;i++){
            int u=minKey(key,prim);
            prim[u]=true;
            for(int v=0;v<V;v++){
                if(graph[u][v]!=0 && prim[v]==false && graph[u][v]<key[v]){
                    parent[v]=u;
                    key[v]=graph[u][v];
                }
            }
        }
        return key;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        V=in.nextInt();
        int[][] graph=new int[V][V];
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                graph[i][j]=in.nextInt();
            }
        }
        System.out.println("Distance Array:");
        int[] distance=prims(graph);
        for(int i=0;i<V;i++){
            System.out.print(distance[i]+" ");
        }
        in.close();
    }
}