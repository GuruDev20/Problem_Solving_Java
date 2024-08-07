import java.util.*;
class Pair{
    int chain1;
    int chain2;
    Pair(int chain1,int chain2){
        this.chain1=chain1;
        this.chain2=chain2;
    }
}
public class LongestChainOfPairs {
    public static int longestChain(Pair[] pair,int n){
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(pair[i].chain1<pair[i].chain2 && pair[j].chain1<pair[j].chain2){
                    if(pair[i].chain1>pair[j].chain2 && dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                    }
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Pair[] pair=new Pair[n];
        for(int i=0;i<n;i++){
            pair[i]=new Pair(in.nextInt(),in.nextInt());
        }
        Arrays.sort(pair,Comparator.comparingInt(p->p.chain1));
        System.out.println(longestChain(pair,n));
        in.close();
    }
}
