import java.util.*;
public class SmallestLexigraphicallyString{
    public static String findString(int n,int k){
        char[] a=new char[n];
        Arrays.fill(a,'a');
        int rem=k-n;
        for(int i=n-1;i>=0 && rem>0;i--){
            int add=Math.min(25,rem);
            a[i]+=add;
            rem-=add;
        }
        return new String(a);

    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int n=in.nextInt();
            int k=in.nextInt();
            System.out.println(findString(n,k));
        }
        in.close();
    }
}