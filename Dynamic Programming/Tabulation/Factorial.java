package Tabulation;
import java.util.*;
public class Factorial{
    public static long factorial(int k){
        long[] dp=new long[k+1];
        dp[0]=1;
        for(int i=1;i<=k;i++){
            dp[i]=i*dp[i-1];
        }
        return dp[k];

    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int k=in.nextInt();
        long fact=factorial(k);
        System.out.println(fact);
        in.close();
    }
}