package TwoPointers;
import java.util.*;

/**
 * @Author: wyj
 * @Description: 42. 接雨水
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 */
public class Trap {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] lines = line.split(",");
        int[] height = new int[lines.length];
        for(int i = 0; i < lines.length; i++){
            height[i] = Integer.parseInt(lines[i]);
        }
        System.out.println(trap(height));
        sc.close();
    }

    public static int trap(int[] height) {
        if(height == null || height.length <= 2){
            return 0;
        }
        int n = height.length;
        int[] maxLeft = new int[n];
        maxLeft[0] = height[0];
        for(int i = 1; i < n; i++){
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        int[] maxRight = new int[n];
        maxRight[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            int h = Math.min(maxLeft[i], maxRight[i]);
            res += h - height[i];
        }
        return res;
    }
}
