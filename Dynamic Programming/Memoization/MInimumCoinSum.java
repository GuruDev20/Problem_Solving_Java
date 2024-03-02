package Memoization;
import java.util.*;
public class MInimumCoinSum {
    public static int minCoinSum(int amount,List<Integer> coins){
        return minCoinSum(amount,coins,new HashMap<>());
    }
    public static int minCoinSum(int amount,List<Integer> coins,HashMap<Integer,Integer> memo){
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return -1;
        }
        if(memo.containsKey(amount)){
            return memo.get(amount);
        }
        int minCoins=-1;
        for(int coin:coins){
            int subAmount=amount-coin;
            int subCoins=minCoinSum(subAmount,coins);
            if(subCoins!=-1){
                int num=subCoins+1;
                if(num<minCoins || minCoins==-1){
                    minCoins=num;
                }
            }
        }
        memo.put(amount,minCoins);
        return minCoins;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int amount=in.nextInt();
        int size=in.nextInt();
        List<Integer>num=new ArrayList<>();
        for(int i=0;i<size;i++){
            num.add(in.nextInt());
        }
        System.out.println(minCoinSum(amount,num));;
        in.close();
    }
}
