import java.util.*;
public class LongestCommonPrefix{
    public static String longestCommonPrefix(String[] strs) {
        String str=strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(str)!=0){
                str=str.substring(0,str.length()-1);
                if(str.isEmpty())return "";
            }
        }
        return str;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] str=in.nextLine().split(" ");
        System.out.println(longestCommonPrefix(str));
        in.close();
    }
}