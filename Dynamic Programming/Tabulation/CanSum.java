package Tabulation;
import java.util.*;
public class CanSum {
    public static boolean canSum(int[] a,int n){
        boolean[] b=new boolean[n+1];
        b[0]=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<a.length;j++){
                if((i+a[j])<=n && b[i]){
                    b[i+a[j]]=true;
                }
            }
        }
        return b[n];
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String[] str=in.nextLine().replaceAll("\\[",",").replaceAll("\\]","").split(",");
        int[] a=new int[str.length];
        for(int i=0;i<str.length;i++){
            a[i]=Integer.parseInt(str[i]);
        }
        System.out.println(canSum(a,n));
        in.close();
    }
}
