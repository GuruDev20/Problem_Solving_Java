package Data_Structures.Graph;
import java.util.*;
public class GraphConnectedCities {
    public static void dfs(int[][] a,int i,boolean[] visited){
        visited[i]=true;
        for(int j=0;j<a[i].length;j++){
            if(!visited[j] && a[i][j]==1){
                dfs(a,j,visited);
            }
        }
    }
    public static int connectedCities(int[][] a,int n){
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(a,i,visited);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[][] a=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=in.nextInt();
            }
        }
        System.out.println(connectedCities(a,n));
        in.close();
    }
}
