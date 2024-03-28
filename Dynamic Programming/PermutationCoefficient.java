import java.util.*;
public class PermutationCoefficient {
    public static int permutation(int n,int k){
        int[][] dp=new int[n+1][k+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=Math.min(i,k);j++){
                if(j==0){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]=j*dp[i-1][j-1]+dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        System.out.println(permutation(n,k));
        in.close();
    }
}
