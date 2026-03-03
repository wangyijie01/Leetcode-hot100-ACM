package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wangyijie
 * @Description: 分割等和子集
 */
public class CanPartition {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] arr = line.split(",");
        int[] prices = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            prices[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(canPartition(prices));
        sc.close();
    }
    public static boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int len = nums.length;
        int sums = 0;
        for(int num : nums)
            sums += num;
        if(sums % 2 == 1)
            return false;
        int target = sums / 2;

        int[] dp = new int[target + 1];
        Arrays.fill(dp, 0);
        for(int i = 0; i < len; i++){
            for(int j = target; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            //System.out.println(Arrays.toString(dp));
        }
        return dp[target] == target;
    }
}
