import java.util.*;
public class QuickSort {
    public static void quickSort(int[] a,int low,int high){
        if(low<high){
            int pivotIndex=partition(a,low,high);
            quickSort(a,low,pivotIndex-1);
            quickSort(a,pivotIndex+1,high);
        }
    }
    public static int partition(int[] a,int low,int high){
        int pivot=a[low];
        int i=low+1;
        int j=high;
        while(i<=j){
            while(i<=j && a[i]<=pivot){
                i++;
            }
            while(i<=j && a[j]>pivot){
                j--;
            }
            if(i<j){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int temp=a[low];
        a[low]=a[j];
        a[j]=temp;
        System.out.println(Arrays.toString(a));
        return j;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        quickSort(a,0,n-1);
        in.close();
    }
}
