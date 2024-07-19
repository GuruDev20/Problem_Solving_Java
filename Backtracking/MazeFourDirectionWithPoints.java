package Backtracking;
import java.util.*;
public class MazeFourDirectionWithPoints{
    public static boolean findSolution(int i,int j,int[][] a,int[][] sol,int n){
        if(i==n-1 && j==n-1 && a[i][j]==0){
            sol[i][j]=1;
            return true;
        }
        if(i>=0 && i<n && j>=0 && j<n && a[i][j]==0 && sol[i][j]==0){
            sol[i][j]=1;
            if(findSolution(i,j+1,a,sol,n)){
                return true;
            }
            else if(findSolution(i+1,j,a,sol,n)){
                return true;
            }
            else if(findSolution(i,j-1,a,sol,n)){
                return true;
            }
            else if(findSolution(i-1,j,a,sol,n)){
                return true;
            }
            sol[i][j]=0;
            return false;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[][] a=new int[n][n];
        int[][] sol=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=in.nextInt();
            }
        }
        int starti=in.nextInt();
        int startj=in.nextInt();
        if(findSolution(starti,startj,a,sol,n)){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(sol[i][j]+" ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("No Solution found");
        }
        in.close();
    }
}