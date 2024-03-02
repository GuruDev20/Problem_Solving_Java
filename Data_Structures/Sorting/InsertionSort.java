import java.util.*;
public class InsertionSort {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        int j=0;
        for(int i=1;i<n;i++){
            int k=a[i];
            for(j=i-1;(j>=0)&&(k<a[j]);j--)
            {
                a[j+1]=a[j];
            }
            a[j+1]=k;
        }
        System.out.println(Arrays.toString(a));
        in.close();
    }    
}
