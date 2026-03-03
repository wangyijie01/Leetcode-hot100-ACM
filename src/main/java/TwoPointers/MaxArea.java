package TwoPointers;

import java.util.*;

/**
 * @Author: wenhao
 * @Description:盛最多水的容器
 * 1,8,6,2,5,4,8,3,7
 * 49
 */
public class MaxArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] lines = line.split(",");
        int[] nums = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            nums[i] = Integer.parseInt(lines[i]);
        }
        System.out.println(maxArea(nums));
        sc.close();
    }

    public static int maxArea(int[] height) {
        if(height == null || height.length == 0 || height.length == 1){
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                res = Math.max(res, height[left] * (right - left));
                left++;
            } else {
                res = Math.max(res, height[right] * (right - left));
                right--;
            }
        }
        return res;
    }
}
