import java.util.*;
class Solution {
    public String reverseWords(String s) {
        String[] str=s.split("\\s+");
        StringBuilder result=new StringBuilder();
        for(int i=str.length-1;i>=0;i--){
            result.append(str[i]).append(" ");
        }
        return result.toString().trim();
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.nextLine().trim();
        Solution st=new Solution();
        String res=st.reverseWords(s);
        System.out.print(res);
        in.close();
    }
}