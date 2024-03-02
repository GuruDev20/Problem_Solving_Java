package Tabulation;
import java.util.*;
public class LongestCommonSubSequence {
    public static int longestCommonSubSequence(char[] a,char[] b,int m,int n){
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else if(a[i-1]==b[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String t=in.nextLine();
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        System.out.println(longestCommonSubSequence(a,b,a.length,b.length));
        in.close();
    }
}
