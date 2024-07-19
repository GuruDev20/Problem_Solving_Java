import java.util.*;
public class MiniumLexicographicallyString{
    public static String minimumString(int n,int k){
        char[] arr=new char[n];
        Arrays.fill(arr,'a');
        int rem=k-n;
        for(int i=n-1;i>=0 && rem>0;i--){
            int val=Math.min(25,rem);
            arr[i]+=val;
            rem-=val;
        }
        return new String(arr);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        System.out.println(minimumString(n,k));
        in.close();
    }
}