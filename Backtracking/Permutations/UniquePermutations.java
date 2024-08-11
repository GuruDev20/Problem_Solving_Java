package Backtracking.Permutations;
import java.util.*;
public class UniquePermutations {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res,new ArrayList<>(),nums,new boolean[nums.length]);
        return res;
    }
    public static void backtrack(List<List<Integer>> res,List<Integer> temp,int[] nums,boolean[] used){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1])){
                    continue;
                }
                used[i]=true;
                temp.add(nums[i]);
                backtrack(res,temp,nums,used);
                used[i]=false;
                temp.remove(temp.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        List<List<Integer>> res=permuteUnique(nums);
        System.out.println(res);
        in.close();
    }
}
