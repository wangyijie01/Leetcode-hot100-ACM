package dp;

import java.util.Scanner;

public class Rob2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] lines = line.split(",");
        int[] nums = new int[lines.length];
        for(int i = 0; i < lines.length; i++){
            nums[i] = Integer.parseInt(lines[i]);
        }
        System.out.println(rob2(nums));
        sc.close();
    }

    private static int rob2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums,1,nums.length));
    }
    private static int rob(int[] nums, int l, int r) {
        int a = 0;
        int b = nums[l];
        int c;
        for(int i = l + 1; i < r; i++){
            c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
}
