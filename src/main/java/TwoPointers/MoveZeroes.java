package TwoPointers;
import java.util.*;
/**
 * @Author: wangyijie
 * @Description: 移动零
 * 0 1 0 3 12
 * 1 3 12 0 0
 */
public class MoveZeroes {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] lines = line.split(" ");
        int[] nums = new int[lines.length];
        for(int i = 0; i < lines.length; i++){
            nums[i] = Integer.parseInt(lines[i]);
        }
        System.out.println(Arrays.toString(moveZeroes(nums)));
        sc.close();
    }

    public static int[] moveZeroes(int[] nums) {
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        while(slow < nums.length){
            nums[slow] = 0;
            slow++;
        }
        return nums;
    }
}
