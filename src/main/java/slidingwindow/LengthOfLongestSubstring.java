package slidingwindow;
import java.util.*;

/**
 * @Author: wangyijie
 * @Description: 无重复字符的最长子串
 * 输入: s = "abcabcbb"
 * 输出: 3
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
        sc.close();
    }
    public static int lengthOfLongestSubstring(String s){
        int res = 0;
        if(s == null || s.length() == 0)
            return res;
        int slow = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int fast = 0; fast < s.length(); fast++){
            if(map.containsKey(s.charAt(fast))){
                slow = Math.max(slow, map.get(s.charAt(fast)) + 1);
            }
            map.put(s.charAt(fast), fast);
            res = Math.max(res, fast - slow + 1);

        }
        return res;
    }
}
