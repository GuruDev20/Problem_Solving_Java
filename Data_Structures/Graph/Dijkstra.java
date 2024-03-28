import java.util.*;
public class Dijkstra {
    private static int V;
    class Edge{
        int src,dest,val;
        public Edge(int src,int dest,int val){
            this.src=src;
            this.dest=dest;
            this.val=val;
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter total number of vertices:");
        V=in.nextInt();
        System.out.println("Enter total number of edges:");
        int E=in.nextInt();
        for(int i=0;i<E;i++){
            int src=in.nextInt();
            int dest=in.nextInt();
            int val=in.nextInt();
        }
        
        in.close();
    }    
}
