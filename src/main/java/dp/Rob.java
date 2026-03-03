package dp;

import java.util.Scanner;

/**
 * @Author: wangyijie
 * @Description: 打家劫舍
 */
public class Rob {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] lines = line.split(",");
        int[] nums = new int[lines.length];
        for(int i = 0; i < lines.length; i++){
            nums[i] = Integer.parseInt(lines[i]);
        }
        System.out.println(rob(nums));
        sc.close();
    }

    private static int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int a = 0;
        int b = nums[0];
        int c;
        for(int i = 1; i < nums.length; i++){
            c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
}
