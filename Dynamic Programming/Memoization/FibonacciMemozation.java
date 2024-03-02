package Memoization;
import java.util.*;
public class FibonacciMemozation{
    private static HashMap<Integer, Integer> memo=new HashMap<>();
    public static int fibonacci(int n){
        if(n==0||n==1){
            return n;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int res=fibonacci(n-1)+fibonacci(n-2);
        memo.put(n,res);
        return res;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(fibonacci(n));
        in.close();
    }
}