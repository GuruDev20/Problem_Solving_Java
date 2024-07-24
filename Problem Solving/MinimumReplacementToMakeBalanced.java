import java.util.*;
public class MinimumReplacementToMakeBalanced{
    public static List<Integer> balancedOrNot(List<String> expressions,List<Integer> maxReplacements){
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<expressions.size();i++){
            String expr=expressions.get(i);
            int maxReplace=maxReplacements.get(i);
            result.add(isBalanced(expr,maxReplace)?1:0);
        }
        return result;
    }
    private static boolean isBalanced(String expr, int maxReplace){
        int openCount=0;
        int replacements=0;
        for(char c:expr.toCharArray()){
            if(c=='<'){
                openCount++;
            }
            else if(c=='>'){
                if(openCount>0){
                    openCount--;
                }
                else{
                    replacements++;
                    if (replacements>maxReplace){
                        return false;
                    }
                }
            }
        }
        return openCount == 0;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        List<String> expressions=new ArrayList<>();
        for(int i=0;i<n;i++){
            expressions.add(in.nextLine());
        }
        int m=in.nextInt();
        in.nextLine();
        List<Integer> maxReplacements=new ArrayList<>();
        for(int i=0;i<m;i++){
            maxReplacements.add(in.nextInt());
        }
        List<Integer> result=balancedOrNot(expressions, maxReplacements);
        for(int r:result){
            System.out.println(r);
        }
        in.close();
    }
}