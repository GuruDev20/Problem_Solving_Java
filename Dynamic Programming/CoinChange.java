import java.util.*;
public class CoinChange {
    public static int countCoins(int[] coins,int amount){
        int max=amount+1;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,max);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(coin<=i){
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount]>max?-1:dp[amount];
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] str=in.nextLine().replaceAll("\\[","").replaceAll("\\]","").split(",");
        int[] coins=new int[str.length];
        for(int i=0;i<str.length;i++){
            coins[i]=Integer.parseInt(str[i]);
        }
        int amount=in.nextInt();
        System.out.println(countCoins(coins,amount));
        in.close();
    }
}
