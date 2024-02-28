import java.util.*;
class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int temp=0;
        int org=x;
        int res=0;
        if(x<0){
            return false;
        }
        while(x!=0){
            temp=x%10;
            res=(res*10)+temp;
            x/=10;
        }
        return org==res;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        PalindromeNumber s=new PalindromeNumber();
        if(s.isPalindrome(n)){
            System.out.print("true");
        }
        else{
            System.out.print("false");
        }
        in.close();
    }
}