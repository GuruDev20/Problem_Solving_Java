import java.util.*;
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int max=0,sum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max+=nums[i];
            sum=Math.max(sum,max);
            if(max<=0){
                max=0;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        MaximumSubArray obj=new MaximumSubArray();
        System.out.println(obj.maxSubArray(nums));
        in.close();
    }
}
