package Data_Structures.Graph;
import java.util.*;
public class EscapeMatrix {
    private static final int boundary=1000000;
    public static boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> hs=new HashSet<>();
        for(int[] blocks:blocked){
            hs.add(blocks[0]+","+blocks[1]);
        }
        return bfs(source,target,hs) && bfs(target,source,hs);
    }
    public static boolean bfs(int[] start,int[] end,Set<String> hs){
        Set<String> visited=new HashSet<>();
        Queue<int[]> q=new LinkedList<>();
        q.offer(start);
        visited.add(start[0]+","+start[1]);
        int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
        int steps=0;
        while(!q.isEmpty()){
            steps+=1;
            int[] val=q.poll();
            int x=val[0];
            int y=val[1];
            for(int[] dir:directions){
                int newX=x+dir[0];
                int newY=y+dir[1];
                String pos=newX+","+newY;
                if(newX==end[0] && newY==end[1]){
                    return true;
                }
                if(newX<0 || newX>=boundary || newY<0 || newY>=boundary || hs.contains(pos) || visited.contains(pos)){
                    continue;
                }
                q.add(new int[]{newX,newY});
                visited.add(pos);
                if(steps>19900){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter blocked coordinates as a string (e.g., [[0,1],[1,0]]):");
        String blockedStr=in.nextLine();
        System.out.println("Enter source as a string (e.g., [0,0]): ");
        String sourceStr=in.nextLine();
        System.out.println("Enter target as a string (e.g., [0,2]): ");
        String targetStr=in.nextLine();
        int[][] blocked=parseBlocked(blockedStr);
        int[] source=parseCoordinate(sourceStr);
        int[] target=parseCoordinate(targetStr);
        boolean result=isEscapePossible(blocked,source,target);
        System.out.println("Is escape possible? "+result);
        in.close();
    }
    private static int[][] parseBlocked(String str){
        str=str.replace("[[", "").replace("]]", "");
        String[] pairs=str.split("\\],\\[");
        int[][] blocked=new int[pairs.length][2];
        for(int i=0;i<pairs.length;i++){
            String[] nums=pairs[i].split(",");
            blocked[i][0]=Integer.parseInt(nums[0]);
            blocked[i][1]=Integer.parseInt(nums[1]);
        }
        return blocked;
    }

    private static int[] parseCoordinate(String str){
        str=str.replace("[", "").replace("]", "");
        String[] nums=str.split(",");
        int[] coordinate=new int[2];
        coordinate[0]=Integer.parseInt(nums[0]);
        coordinate[1]=Integer.parseInt(nums[1]);
        return coordinate;
    }
}
