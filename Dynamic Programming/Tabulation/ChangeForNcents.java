package Tabulation;
import java.util.*;
public class ChangeForNcents {
    public static int countWays(int[] a,int n,int val){
        int[] dp=new int[val+1];
        dp[0]=1;
        for(int coin:a){
            for(int i=coin;i<=val;i++){
                dp[i]+=dp[i-coin];
            }
        }
        return dp[val];
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int k=in.nextInt();
        for(int i=0;i<k;i++){
            int n=in.nextInt();
            int[] a=new int[n];
            for(int j=0;j<n;j++){
                a[j]=in.nextInt();
            }
            int val=in.nextInt();
            System.out.println(countWays(a,n,val));
        }
        in.close();   
    }
}
