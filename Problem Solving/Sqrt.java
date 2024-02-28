import java.util.*;
class Solution {
    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Solution s=new Solution();
        double d=s.mySqrt(n);
        System.out.printf("%d",d);
        in.close();
    }
}