import java.util.*;

public class KthLargestElementStream {
    private PriorityQueue<Integer> minHeap;
    private int k; 

    public KthLargestElementStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        KthLargestElementStream obj = new KthLargestElementStream(k, nums);
        System.out.println(obj.add(3));
        in.close();
    }
}
