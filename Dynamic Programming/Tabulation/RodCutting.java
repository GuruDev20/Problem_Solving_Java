package Tabulation;
import java.util.*;
public class RodCutting {
    public static int cutRod(int[] price,int n){
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]=Math.max(dp[i],price[j]+dp[i-j-1]);
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        System.out.println(cutRod(a,n));
        in.close();
    }
}
