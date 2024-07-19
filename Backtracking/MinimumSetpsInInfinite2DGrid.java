package Backtracking;
import java.util.*;
public class MinimumSetpsInInfinite2DGrid {
    public static int minSteps(int x1,int y1,int x2,int y2){
        return Math.max(Math.abs(x2-x1),Math.abs(y2-y1));
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[][] grid=new int[n][2];
        for(int i=0;i<n;i++){
            grid[i][0]=in.nextInt();
            grid[i][1]=in.nextInt();
        }
        int total=0;
        for(int i=0;i<n-1;i++){
            int x1=grid[i][0];
            int y1=grid[i][1];
            int x2=grid[i+1][0];
            int y2=grid[i+1][1];
            int steps=minSteps(x1,y1,x2,y2);
            total+=steps;
        }
        System.out.print(total>n?"-1":total);
        in.close();
    }
}