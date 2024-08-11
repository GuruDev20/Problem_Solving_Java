import java.util.*;
public class LongestPalindromicSubstring{
    public static String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        int max=1,start=0,end=0;
        boolean[][] dp=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
            for(int j=0;j<i;j++){
                if(s.charAt(j)==s.charAt(i) && (i-j<=2 || dp[j+1][i-1])){
                    dp[j][i]=true;
                    if(i-j+1>max){
                        max=i-j+1;
                        start=j;
                        end=i;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        System.out.println(longestPalindrome(s));
        in.close();
    }
}