package Backtracking.Combinations;
import java.util.*;
public class LetterCombinationsOfPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits==null || digits.length()==0){
            return result;
        }
        Map<Character,String> hm=new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        find(digits,0,new StringBuilder(),result,hm);
        return result;
    }
    public static void find(String digits,int ind,StringBuilder sb,List<String> result,Map<Character,String> hm){
        if(ind==digits.length()){
            result.add(sb.toString());
            return;
        }
        String letters=hm.get(digits.charAt(ind));
        for(char letter:letters.toCharArray()){
            sb.append(letter);
            find(digits,ind+1,sb,result,hm);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        List<String> result=letterCombinations(str);
        for(String s:result){
            System.out.print(s+" ");
        }
        in.close();
    }
}
