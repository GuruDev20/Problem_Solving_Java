import java.util.*;
class Solution {
    public int lengthOfLastWord(String s) {
        String[] a=s.split(" ");
        String st=a[a.length-1];
        return st.length();
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str=in.nextLine().trim();
        Solution s=new Solution();
        int k=s.lengthOfLastWord(str);
        System.out.print(k);
        in.close();
    }
}