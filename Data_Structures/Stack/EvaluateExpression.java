import java.util.*;
public class EvaluateExpression{
    public static int calculateExpression(String str){
        String postfix=infixToPostFix(str);
        System.out.println(postfix);
        return calculate(postfix);
    }
    public static String infixToPostFix(String str){
        StringBuilder post=new StringBuilder();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(Character.isDigit(c)){
                post.append(c);
            }
            else if(c=='('){
                st.push(c);
            }
            else if(c==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    post.append(st.pop());
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && precedence(c)<=precedence(st.peek())){
                    post.append(st.pop());
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            post.append(st.pop());
        }
        return post.toString();
    }
    public static int precedence(char op){
        switch(op){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
    public static int calculate(String str){
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                st.push(Character.getNumericValue(str.charAt(i)));
                System.out.println(st);
            }
            else if(str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='*'||str.charAt(i)=='/'){
                int a=st.pop();
                int b=st.pop();
                if(str.charAt(i)=='+'){
                    st.push(b+a);
                    System.out.println(st);
                }
                else if(str.charAt(i)=='-'){
                    st.push(b-a);
                    System.out.println(st);
                }
                else if(str.charAt(i)=='*'){
                    st.push(b*a);
                    System.out.println(st);
                }
                else if(str.charAt(i)=='/'){
                    st.push(b/a);
                    System.out.println(st);
                }
            }
        }
        return st.pop();
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        System.out.print(calculateExpression(str));
        in.close();
    }
}