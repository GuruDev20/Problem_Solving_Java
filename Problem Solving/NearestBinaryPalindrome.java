import java.util.*;
public class NearestBinaryPalindrome{
    public static boolean isPalindrome(String str){
        StringBuilder sb=new StringBuilder(str);
        return str.equals(sb.reverse().toString());
    }
    public static int nearestPalindrome(int n){
        if(isPalindrome(Integer.toBinaryString(n))){
            return n;
        }
        int prev=n-1;
        int next=n+1;
        while(true){
            if(isPalindrome(Integer.toBinaryString(prev)) && Integer.toBinaryString(n).length()==Integer.toBinaryString(prev).length()){
                return prev;
            }
            if(isPalindrome(Integer.toBinaryString(next)) && Integer.toBinaryString(n).length()==Integer.toBinaryString(next).length()){
                return next;
            }
            prev--;
            next++;
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(nearestPalindrome(n));
        in.close();
    }
}