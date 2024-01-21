import java.util.*;
class Solution {
    public void sortColors(int[] nums) {
       int low = 0;
        int high = nums.length - 1;
        int i = 0;

        while (i <= high) {
            if (nums[i] == 0) {
                swap(nums, i, low);
                low++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, high);
                high--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        Solution s=new Solution();
        s.sortColors(a);
        for(int i=0;i<n;i++){
            System.out.print(a[i]+",");
        }
        in.close();
    }
}