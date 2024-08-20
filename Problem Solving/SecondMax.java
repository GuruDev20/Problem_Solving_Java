import java.util.*;
public class SecondMax {
    public static int secondMax(int[] a,int n){
        int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]>first){
                second=first;
                first=a[i];
            }
            else if(a[i]>second && a[i]!=first){
                second=a[i];
            }
        }
        return second;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        System.out.println(secondMax(a,n));
        in.close();
    }
}
