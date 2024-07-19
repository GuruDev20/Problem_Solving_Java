package Backtracking;
import java.util.*;
public class CanReachEnd {
    public static boolean canReach(int[] a,int n){
        if(n==0){
            return false;
        }
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[n];
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int current=q.poll();
            int currentValue=a[current];
            for(int i=0;i<=currentValue;i++){
                int next=current+i;
                if(next==n-1){
                    return true;
                }
                if(next<n && !visited[next]){
                    q.add(next);
                    visited[next]=true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        System.out.print(canReach(a,n)?"True":"False");
        in.close();
    }
}