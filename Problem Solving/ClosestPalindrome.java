import java.util.*;
public class ClosestPalindrome {
    public String nearestPalindromic(String n) {
        int len=n.length();
        long num=Long.parseLong(n);
        Set<Long> hs=new HashSet<>();
        hs.add((long)Math.pow(10,len-1)-1);
        hs.add((long)Math.pow(10,len)+1);
        long prefix=Long.parseLong(n.substring(0,(len+1)/2));
        for(long i=-1;i<=1;i++){
            String s=createPalindrome(prefix+i,len%2==0);
            hs.add(Long.parseLong(s));
        }
        hs.remove(num);
        long min=Long.MAX_VALUE;
        long close=0;
        for(long str:hs){
            long diff=Math.abs(str-num);
            if(diff<min || (diff==min && str<close)){
                min=diff;
                close=str;
            }
        }
        return String.valueOf(close);
    }
    public String createPalindrome(long num,boolean even){
        StringBuilder sb=new StringBuilder();
        sb.append(num);
        String rev=new StringBuilder(sb).reverse().toString();
        return even?sb.append(rev).toString():sb.append(rev.substring(1)).toString();
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String n=in.nextLine();
        ClosestPalindrome cp=new ClosestPalindrome();
        System.out.println(cp.nearestPalindromic(n));
        in.close();
    }
}
