import java.util.*;
public class Krushkal {
    private static int N;
    // public static int[] kruskal(int[][] graph){
    //     return arr[0];
    // }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        N=in.nextInt();
        int[][] graph=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                graph[i][j]=in.nextInt();
            }
        }
        // int[] distance=kruskal(graph);
        // System.out.println(Arrays.toString(distance));
        in.close();
    }
}
