import java.util.*;
class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;;
        int n=nums2.length;
        int[] c=new int[m+n];
        System.arraycopy(nums1,0,c,0,m);
        System.arraycopy(nums2,0,c,m,n);
        Arrays.sort(c);
        if((m+n)%2==0){
            int mid=(m+n)/2;
            return (c[mid-1]+c[mid])/2.0;
        } 
        else{
            int mid=(m+n)/2;
            return c[mid];
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int[] a=new int[m];
        for(int i=0;i<m;i++){
            a[i]=in.nextInt();
        }
        int n=in.nextInt();
        int[] b=new int[n];
        for(int i=0;i<n;i++){
            b[i]=in.nextInt();
        }
        MedianOfTwoSortedArrays s=new MedianOfTwoSortedArrays();
        double k=s.findMedianSortedArrays(a,b);
        System.out.print(k);
        in.close();
    }
}