package Backtracking.Combinations;
import java.util.*;
public class WordBreak {
    static String[] dict={"mobile","it","vac","itvac","man","mango","icecream","and","go","i","love","ice","cream"};
    static List<String> dictionary=List.of(dict);
    public static void wordBreak(String str){
        List<String> result=new ArrayList<>();
        wordBreakMain(result,str);
    }
    public static void wordBreakMain(List<String> result,String str){
        int len=str.length();
        for(int i=1;i<=len;i++){
            String s=str.substring(0,i);
            if(dictionary.contains(s)){
                if(i==len){
                    result.add(s);
                    System.out.println(String.join(" ",result));
                    result.remove(result.size()-1);
                    return;
                }
                result.add(s);
                wordBreakMain(result,str.substring(i));
                result.remove(result.size()-1);
            }
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        in.nextLine();
        for(int t=0;t<T;t++){
            String str=in.nextLine();
            wordBreak(str);
        }
        in.close();
    }
}