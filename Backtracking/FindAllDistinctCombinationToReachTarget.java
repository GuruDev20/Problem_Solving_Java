package Backtracking;
import java.util.*;
public class FindAllDistinctCombinationToReachTarget {
    public static void findCombinations(int[] a,int n,int target){
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(a);
        backtrack(a,target,0,new ArrayList<>(),res);
        if(res.isEmpty()){
            System.out.print("Empty");
        }
        else{
            for(List<Integer> combination:res){
                System.out.print("( ");
                for(int i:combination){
                    System.out.print(i+" ");
                }
                System.out.print(")");
            }
        }
    }
    public static void backtrack(int[] a,int remaining,int start,List<Integer> combinations,List<List<Integer>> res){
        if(remaining==0){
            res.add(new ArrayList<>(combinations));
        }
        for(int i=start;i<a.length;i++){
            if(i>start && a[i]==a[i-1]){
                continue;
            }
            if(a[i]<=remaining){
                combinations.add(a[i]);
                backtrack(a,remaining-a[i],i+1,combinations,res);
                combinations.remove(combinations.size()-1);
            }
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        for(int t=0;t<T;t++){
            int n=in.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=in.nextInt();
            }
            int target=in.nextInt();
            findCombinations(a,n,target);
            System.out.println();
        }
        in.close();
    }
}