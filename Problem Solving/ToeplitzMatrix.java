import java.util.*;
public class ToeplitzMatrix {
    public static boolean isToeplitzMatrix(int[][] a){
        int m=a.length;
        int n=a[0].length;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(a[i][j]!=a[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        int[][] a=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=in.nextInt();
            }
        }
        in.close();
        System.out.println(isToeplitzMatrix(a));
    }
}
