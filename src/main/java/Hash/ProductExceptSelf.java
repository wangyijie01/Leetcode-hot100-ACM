package Hash;
import java.util.*;

/**
 * 238.除自身以外数组的乘积
 *
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 *输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 */
public class ProductExceptSelf {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] lines = line.split(",");
        int[] nums = new int[lines.length];
        for(int i = 0; i < lines.length; i++){
            nums[i] = Integer.parseInt(lines[i]);
        }
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        sc.close();
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = 1;
        for(int i = 1; i < n; i++){
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        int[] cur = new int[n];
        cur[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--){
            cur[i] = cur[i + 1] * nums[i + 1];
        }

        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = pre[i] * cur[i];
        }
        return res;
    }
}
