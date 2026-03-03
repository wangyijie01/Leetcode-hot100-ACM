package TwoPointers;

import java.util.*;

/**
 * @Author: wangyijie
 * @Description: 三数之和
 *
 * [-1,0,1,2,-1,-4]
 * [[-1,-1,2],[-1,0,1]]
 *
 * [0,1,1]
 * []
 *
 * [0,0,0]
 * [[0,0,0]]
 */
public class ThreeSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] lines = line.split(",");
        int[] nums = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            nums[i] = Integer.parseInt(lines[i]);
        }
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3){
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();

        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1, r = nums.length - 1;
            while(l < r){
                if(nums[i] + nums[l] + nums[r] > 0){
                    r--;
                }else if(nums[i] + nums[l] + nums[r] < 0){
                    l++;
                }else{
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[r] == nums[r - 1]) r--;
                    while(l < r && nums[l] == nums[l + 1]) l++;
                    r--;
                    l++;
                }
            }
        }

        return res;
    }
}
