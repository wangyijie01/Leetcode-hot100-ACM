package Hash;

import java.util.*;

/**
 * 128. 最长连续序列
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 输入：nums = [1,0,1,2]
 * 输出：3
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] lines = line.split(",");
        int[] nums = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            nums[i] = Integer.parseInt(lines[i]);
        }
        System.out.println(longestConsecutive(nums));
        sc.close();
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int res = 0;
        for(int num : set){
            if(set.contains(num - 1))
                continue;
            int y = num + 1;
            while(set.contains(y)){
                y++;
            }
            res = Math.max(res, y - num);
        }

        return res;
    }
}
