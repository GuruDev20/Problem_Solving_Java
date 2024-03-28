import java.util.*;
public class NthCatalanNumber {
    public static long catalanNumber(int n){
        if(n<=1){
            return 1;
        }
        long[] dp=new long[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=0;
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println(catalanNumber(in.nextInt()));
        in.close();
    }
}


// C(n)=2n!/(n+1)!n!