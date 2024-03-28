import java.util.*;
public class Knapsack {
    public static int knapsack(int W,int[] wt,int[] val, int n){
        int[][] dp=new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else if(wt[i-1]<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][W];    
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] a=in.nextLine().replaceAll("\\{","").replaceAll("\\}", "").split(",");
        String[] b=in.nextLine().replaceAll("\\{","").replaceAll("\\}", "").split(",");
        int[] profit=new int[a.length];
        int[] weight=new int[b.length];
        for(int i=0;i<a.length;i++){
            profit[i]=Integer.parseInt(a[i]);
        }
        for(int i=0;i<b.length;i++){
            weight[i]=Integer.parseInt(b[i]);
        }
        int W=in.nextInt();
        int n=profit.length;
        System.out.println(knapsack(W,weight,profit,n));
        in.close();
    }
}
