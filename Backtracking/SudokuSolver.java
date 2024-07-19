package Backtracking;
import java.util.*;
public class SudokuSolver{
    private static int iterationCount=1200;
    private static int current=0;
    public static boolean isSafe(int[][] board,int row,int col,int num){
        for(int i=0;i<9;i++){
            if(board[row][i]==num){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==num){
                return false;
            }
        }
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean helper(int[][] board,int row,int col){
        if(current>=iterationCount){
            return false;
        }
        current++;
        if(row==9){
            return true;
        }
        int nr=0,nc=0;
        if(col!=8){
            nr=row;
            nc=col+1;
        }
        else{
            nr=row+1;
            nc=0;
        }
        if(board[row][col]!=0){
            if(helper(board,nr,nc)){
                return true;
            }
        }
        else{
            for(int i=1;i<=9;i++){
                if(isSafe(board,row,col,i)){
                    board[row][col]=i;
                    if(helper(board,nr,nc)){
                        return true;
                    }
                    else{
                        board[row][col]=0;
                    }
                }
            }
        }
        return false;
    }
    public static boolean solveSudoku(int[][] board){
        return helper(board,0,0);
    }
    public static void printBoard(int[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int[][] board=new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j]=in.nextInt();
            }
        }
        if(solveSudoku(board)){
            printBoard(board);
        }
        else{
            System.out.println("No solution");
        }
        in.close();
    }
}