package slidingwindow;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 找到字符串中所有字母异位词
 */
public class FindAnagrams {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagrams(String s, String p){
        int[] records = new int[26];
        for(int i = 0; i < p.length(); i++){
            records[p.charAt(i) - 'a']++;
        }

        List<Integer> res = new LinkedList<>();
        int slow = 0;
        for(int fast = 0; fast < s.length(); fast++){
            records[s.charAt(fast) - 'a']--;
            while(records[s.charAt(fast) - 'a'] < 0){
                records[s.charAt(slow) - 'a']++;
                slow++;
            }
            if(fast - slow + 1 == p.length()){
                res.add(slow);
            }
        }
        return res;
    }
}
