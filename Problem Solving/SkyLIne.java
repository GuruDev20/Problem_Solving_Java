import java.util.*;
public class Skyline{
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result=new ArrayList<>();
        List<int[]> heights=new ArrayList<>();
        for(int[] b:buildings){
            heights.add(new int[]{b[0],-b[2]});
            heights.add(new int[]{b[1],b[2]});
        }
        Collections.sort(heights,(a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            else return a[1]-b[1];
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        pq.offer(0);
        int prev=0;
        for(int[] h:heights){
            if(h[1]<0){
                pq.offer(-h[1]);
            }
            else{
                pq.remove(h[1]);
            }
            int curr=pq.peek();
            if(prev!=curr){
                List<Integer> temp=new ArrayList<>();
                temp.add(h[0]);
                temp.add(curr);;
                result.add(new ArrayList<>(temp));
                prev=curr;
            }
        }
        return result;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        str=str.substring(2,str.length()-2);
        String[] s=str.split("\\],\\[");
        int n=s.length;
        int[][] a=new int[n][3];
        for(int i=0;i<n;i++){
            String[] st=s[i].split(",");
            a[i][0]=Integer.parseInt(st[0]);
            a[i][1]=Integer.parseInt(st[1]);
            a[i][2]=Integer.parseInt(st[2]);
        }
        List<List<Integer>> result=getSkyline(a);
        System.out.print("[");
        for(int i=0;i<result.size();i++){
            List<Integer> point=result.get(i);
            System.out.print("["+point.get(0)+","+point.get(1)+"]");
            if(i<result.size()-1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}