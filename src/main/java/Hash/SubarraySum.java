package Hash;
import java.util.*;
import java.io.*;

/**
 * @Author: wangyijie
 * @Description: 和为k的子数组
 */
public class SubarraySum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int k = sc.nextInt();
        String[] lines = line.split(" ");
        int[] nums = new int[lines.length];
        for(int i = 0; i < lines.length; i++){
            nums[i] = Integer.parseInt(lines[i]);
        }
        System.out.println(subarraySum(nums, k));
        sc.close();
    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int[] s = new int[nums.length + 1];
        s[0] = 0;
        map.put(s[0], 1);
        for(int i = 1; i < nums.length + 1; i++){
            s[i] = s[i - 1] + nums[i - 1];
            res += map.getOrDefault(s[i] - k, 0);
            map.put(s[i], map.getOrDefault(s[i], 0) + 1);
        }
        return res;
    }
}
