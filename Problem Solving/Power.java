import java.util.*;
class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x,n);
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        double x=in.nextDouble();
        int n=in.nextInt();
        Solution s=new Solution();
        System.out.printf("%.5d",s.myPow(x,n));
        in.close();
    }
}