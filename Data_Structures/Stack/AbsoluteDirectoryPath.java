import java.util.*;
public class AbsoluteDirectoryPath {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] str=in.nextLine().replaceAll("cd","").replaceAll(" ","").split("/");
        Stack<String> st=new Stack<>();
        for(String ch:str){
            if(ch.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else if(!ch.isEmpty()){
                st.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(String val:st){
            sb.append(val).append("/");
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println(sb.toString());
        in.close();
    }
}
