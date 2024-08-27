import java.util.*;
public class LongestPalindrome{
    public static int longestPalindrome(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(char ch:s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int count=0;
        boolean isOdd=false;
        for(int freq:hm.values()){
            if(freq%2==0){
                count+=freq;
            }
            else{
                count+=freq-1;
                isOdd=true;
            }
        }
        if(isOdd){
            count+=1;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        System.out.println(longestPalindrome(s));
        in.close();
    }
}
