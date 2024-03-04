import java.util.*;
public class MinimumOperationToBecameOneNumberToAnotherNumber{
    public static int minOperations(int p,int q){
        Map<Integer,Integer> hm=new HashMap<>();
        Set<Integer> visited=new HashSet<>();
        hm.put(p,0);
        visited.add(p);
        while(!hm.containsKey(q)){
            Map<Integer,Integer> map=new HashMap<>();
            for(int num:hm.keySet()){
                int steps=hm.get(num);
                if(num<q && !visited.contains(num*2)){
                    map.put(num*2,steps+1);
                }
                if(num+1<=q && !visited.contains(num+1)){
                    map.put(num+1,steps+1);
                    visited.add(num+1);
                }
                if(num-1>=0 && !visited.contains(num-1)){
                    map.put(num-1,steps+1);
                    visited.add(num-1);
                }
                if(num%2==0 && !visited.contains(num/2)){
                    map.put(num/2,steps+1);
                    visited.add(num/2);
                }
            }
            hm=map;
        }
        return hm.get(q);
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int p=in.nextInt();
        int q=in.nextInt();
        System.out.println(minOperations(p,q));
        in.close();
    }
}