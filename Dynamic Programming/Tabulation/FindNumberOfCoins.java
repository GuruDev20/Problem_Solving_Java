package Tabulation;
import java.util.*;
public class FindNumberOfCoins {
    public static void findMinCoins(long amount){
        long[] coinList={1000,500,200,100,50,20,10,5,2,1};
        ArrayList<Long> al=new ArrayList<>();
        for(long coin:coinList){
            while(amount>=coin){
                al.add(coin);
                amount-=coin;
            }
        }
        System.out.println(al);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++){
            long k=in.nextLong();
            findMinCoins(k);
        }
        in.close();
    }
}
