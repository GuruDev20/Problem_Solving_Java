import java.util.*;
public class RotateRingOfMatrix{
    public static void rotateMatrix(int[][] a,int m,int n,int k){
        int ringCount=Math.min(m,n)/2;
        for(int i=0;i<ringCount;i++){
            int top=i;
            int bottom=m-i-1;
            int left=i;
            int right=n-i-1;
            int ringLength=2*(right-left+bottom-top);
            k=k%ringLength;
            int[] ring=new int[ringLength];
            int index=0;
            for(int j=left;j<=right;j++){
                ring[index++]=a[top][j];
            }
            for(int j=top+1;j<=bottom;j++){
                ring[index++]=a[j][right];
            }
            for(int j=right-1;j>=left;j--){
                ring[index++]=a[bottom][j];
            }
            for(int j=bottom-1;j>top;j--){
                ring[index++] = a[j][left];
            }
            int[] rotatedRing=new int[ringLength];
            for(int j=0;j<ringLength;j++){
                rotatedRing[j]=ring[(j+k)%ringLength];
            }
            index=0;
            for(int j=left;j<=right;j++){
                a[top][j]=rotatedRing[index++];
            }
            for(int j=top+1;j<=bottom;j++){
                a[j][right]=rotatedRing[index++];
            }
            for(int j=right-1;j>=left;j--){
                a[bottom][j]=rotatedRing[index++];
            }
            for(int j=bottom-1;j>top;j--){
                a[j][left]=rotatedRing[index++];
            }
        }
    }
    public static void printMatrix(int[][] a,int m,int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        int k=in.nextInt();
        int[][] a=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=in.nextInt();
            }
        }
        rotateMatrix(a,m,n,k);
        printMatrix(a,m,n);
        in.close();
    }
}