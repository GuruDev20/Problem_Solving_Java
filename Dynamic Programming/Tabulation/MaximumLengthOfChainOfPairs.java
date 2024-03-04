package Tabulation;
import java.util.*;
class Pair{
    int chain1,chain2;
    public Pair(int chain1,int chain2){
        this.chain1=chain1;
        this.chain2=chain2;
    }
}
public class MaximumLengthOfChainOfPairs {
    public static int maxLength(Pair[] pair,int n){
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(pair[i].chain1>pair[i].chain2 && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        str=str.substring(2,str.length()-2);
        String[] pairs=str.split("\\[,\\]");
        Pair[] pair=new Pair[pairs.length];
        for(int i=0;i<pairs.length;i++){
            String[] num=pairs[i].split(",");
            int chain1=Integer.parseInt(num[0]);
            int chain2=Integer.parseInt(num[1]);
            pair[i]=new Pair(chain1,chain2);
        }
        int longest=maxLength(pair,pair.length);
        System.out.println(longest);
        in.close();
    }
}
