import java.util.*;
class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        int k=in.nextInt();
        Solution s=new Solution();
        int kt=s.search(a,k);
        System.out.print(kt);
        in.close();
    }
}