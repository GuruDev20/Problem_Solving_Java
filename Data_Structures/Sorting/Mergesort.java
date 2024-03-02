import java.util.*;
public class Mergesort {
    public static void mergeSort(int[] a,int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,mid+1,high);
        }
    }
    public static void merge(int[] a,int low,int mid,int p,int high){
        int[] temp=new int[50];
        int i=low,j=p,k=0;
        while(i<=mid && j<=high){
            if(a[i]<=a[j]){
                temp[k++]=a[i++];
            }
            else{
                temp[k++]=a[j++];
            }
        }
        while(i<=mid){
            temp[k++]=a[i++];
        }
        while(j<=high){
            temp[k++]=a[j++];
        }
        for(i=low,j=0;i<=high;i++,j++){
            a[i]=temp[j];
        }
        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        mergeSort(a,0,n-1);
        in.close();
    }
}
