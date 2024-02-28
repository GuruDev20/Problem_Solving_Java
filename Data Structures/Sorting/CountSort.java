import java.util.*;
public class CountSort{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
            max=Math.max(max,a[i]);
        }
        int[] count=new int[max+1];
        Arrays.fill(count,0);
        for(int i=0;i<n;i++){
            count[a[i]]++;
        }
        int[] result=new int[n];
        for(int i=1;i<=max;i++) {
            count[i]+=count[i-1];
        }
        for(int i=n-1;i>=0;i--){
            result[count[a[i]]-1]=a[i];
            count[a[i]]--;
        }
        System.out.println(Arrays.toString(result));
        in.close();
    }
}