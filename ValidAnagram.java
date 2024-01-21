import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        if(Arrays.equals(a,b)){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        String t=in.next();
        Solution se=new Solution();
        boolean found=se.isAnagram(s,t);
        if(found){
            System.out.print("true");
        }
        else{
            System.out.print("false");
        }
        in.close();
    }
}