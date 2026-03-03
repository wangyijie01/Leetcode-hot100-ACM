package Hash;
import java.util.*;
import java.io.*;

/**
 * @Author: wangyijie
 * @Description: 两数之和
 */
public class TwoSum {
    public static void main(String[] args) {
        // ACM模式要点1：使用 Scanner 读取输入
        Scanner sc = new Scanner(System.in);

        // ACM模式要点2：处理第一行输入 - 数组元素
        // 注意：这里使用 nextLine() 读取整行，因为数组长度未知
        String line = sc.nextLine();

        // ACM模式要点3：处理第二行输入 - 目标值
        int target = sc.nextInt();

        // ACM模式要点4：解析输入数据
        // 将字符串按空格分割成字符串数组
        String[] split = line.split(" ");
        int[] nums = new int[split.length];

        // 将字符串数组转换为整数数组
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        // ACM模式要点5：调用解题方法并输出结果
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));

        // ACM模式要点6：关闭 Scanner 释放资源
        sc.close();
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
