import java.util.*;
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String[] str=in.nextLine().replaceAll("\\[","").replaceAll("\\]","").replaceAll(",","").split(" ");
        int[] a=new int[str.length];
        for(int i=0;i<str.length;i++){
            a[i]=Integer.parseInt(str[i]);
        }
        int target=in.nextInt();
        TwoSum s=new TwoSum();
        int[] ret=s.twoSum(a,target);
        for(int i=0;i<ret.length;i++){
            System.out.print(ret[i]+",");
        }
        in.close();
    }
}