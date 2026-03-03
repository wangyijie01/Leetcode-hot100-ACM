package slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: wangyijie
 * @Description: 最小覆盖子串
 * a b ""
 *
 */
public class MinWindow {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(minWindow(s, t));
    }

    private static String minWindow(String s, String t) {
        Map<Character, Integer> maps = new HashMap<>();
        Map<Character, Integer> mapt = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            mapt.put(t.charAt(i), mapt.getOrDefault(t.charAt(i), 0) + 1);
        }

        String res = "";
        int slow = 0;
        int count = 0;
        int minlen = Integer.MAX_VALUE;
        for(int fast = 0; fast < s.length(); fast++){
            maps.put(s.charAt(fast), maps.getOrDefault(s.charAt(fast), 0) + 1);
            if(mapt.containsKey(s.charAt(fast)) && mapt.get(s.charAt(fast)) >= maps.get(s.charAt(fast)))
                count++;

            while(slow < fast && (!mapt.containsKey(s.charAt(slow)) || maps.get(s.charAt(slow)) > mapt.get(s.charAt(slow)))){
                maps.put(s.charAt(slow), maps.getOrDefault(s.charAt(slow), 0) - 1);
                slow++;
            }

            if(count == t.length() && fast - slow + 1 < minlen){
                res = s.substring(slow, fast + 1);
                minlen = fast - slow + 1;
            }
        }
        return res;
    }
}
