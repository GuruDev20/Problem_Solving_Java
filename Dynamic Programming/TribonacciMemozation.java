import java.util.*;
public class TribonacciMemozation {
    private static HashMap<Integer,Integer> memo=new HashMap<>();
    private static int tribonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int result=tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
        memo.put(n,result);
        return result;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(tribonacci(n));
        in.close();
    }
}
