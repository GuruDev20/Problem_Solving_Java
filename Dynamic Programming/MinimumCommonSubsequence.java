import java.util.*;
public class MinimumCommonSubsequence {
    public static int minCommonSubsequence(String s,String t){
        int m=s.length(),n=t.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                else if(j==0){
                    dp[j][j]=i;
                }
                else if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=1+Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String t=in.nextLine();
        System.out.println(minCommonSubsequence(s,t));
        in.close();
    }
}
