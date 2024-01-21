import java.util.*;
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        int[][] a=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=in.nextInt();
            }
        }
        int k=in.nextInt();
        Solution s=new Solution();
        boolean result=s.searchMatrix(a,k);
        System.out.print(result);
        in.close();
    }
}