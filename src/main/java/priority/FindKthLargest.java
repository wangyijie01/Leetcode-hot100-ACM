package priority;

import java.util.PriorityQueue;
import java.util.Scanner;

public class FindKthLargest {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] arrs = line.split(",");
        int[] nums = new int[arrs.length];
        for(int i = 0; i < arrs.length; i++){
            nums[i] = Integer.parseInt(arrs[i]);
        }
        int k = sc.nextInt();
        System.out.println(findKthLargest(nums, k));
        sc.close();
    }

    public static int findKthLargest(int[] nums, int k){
        if(nums == null || nums.length == 0){
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.offer(num);
            while(!pq.isEmpty() && pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
