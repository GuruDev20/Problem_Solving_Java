import java.util.*;
public class RadixSort{
    public static void count(int[] a,int n,int div){
        int[] res=new int[n];
        int[] count=new int[10];
        Arrays.fill(count,0);
        for(int i=0;i<n;i++){
            count[(a[i]/div)%10]++;
        }
        for(int i=1;i<10;i++){
            count[i]+=count[i-1];
        }
        for(int i=n-1;i>=0;i--){
            res[count[(a[i]/div)%10]-1]=a[i];
            count[(a[i]/div)%10]--;
        }
        for(int i=0;i<n;i++){
            a[i]=res[i];
        }
    }
    public static void radix(int[] a,int max,int n){
        for(int i=1;max/i>0;i*=10){
            count(a,n,i);
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
            max=Math.max(max,a[i]);
        }
        radix(a,max,n);
        System.out.println(Arrays.toString(a));
        in.close();
    }
}