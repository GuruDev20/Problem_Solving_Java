package Data_Structures.Graph;
import java.util.*;
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            adj.get(pre[0]).add(pre[1]);
            // adj.get(pre[1]).add(pre[0]);
        }
        int[] visited=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(hasCycle(i,adj,visited)){
                return false;
            }
        }
        return true;
    }
    public boolean hasCycle(int i,List<List<Integer>> adj,int[] visited){
        if(visited[i]==1){
            return true;
        }
        if(visited[i]==2){
            return false;
        }
        visited[i]=1;
        for(int pre:adj.get(i)){    
            if(hasCycle(pre,adj,visited)){
                return true;
            }
        }
        visited[i]=2;
        return false;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int numCourses=in.nextInt();
        int[][] prerequisites=new int[numCourses][2];
        for(int i=0;i<numCourses;i++){
            prerequisites[i][0]=in.nextInt();
            prerequisites[i][1]=in.nextInt();
        }
        CourseSchedule c=new CourseSchedule();
        System.out.println(c.canFinish(numCourses,prerequisites));
        in.close();
    }
}
