import java.util.*;
public class RotenOranges {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0){
            return -1;
        }
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
        int mins=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] val=q.poll();
                int x=val[0];
                int y=val[1];
                for(int[] dir:directions){
                    int newX=x+dir[0];
                    int newY=y+dir[1];
                    // if(newX<0 || newX>=m || newY<0 || newY>=n || grid[newX][newY]!=1){
                    //     continue;
                    // }
                    if(newX>=0 && newX<m && newY>=0 && newY<n && grid[newX][newY]==1){
                        grid[newX][newY]=2;
                        q.add(new int[]{newX,newY});
                        fresh--;
                    }
                }
            }
            if(!q.isEmpty()){
                mins++;
            }
        }
        return fresh==0?mins:-1;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[][] grid=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=in.nextInt();
            }
        }
        System.out.println(new RotenOranges().orangesRotting(grid));
        in.close();
    }
}
