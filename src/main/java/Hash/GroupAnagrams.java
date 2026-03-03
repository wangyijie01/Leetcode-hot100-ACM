package Hash;
import java.util.*;

/**
 * @Description: 49. 字母异位词分组
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strs = line.split(",");
        System.out.println(groupAnagrams(strs));
        sc.close();
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String storedStr = new String(chars);
            if(!map.containsKey(storedStr)){
                List<String> l = new LinkedList<>();
                map.put(storedStr, l);
            }
            map.get(storedStr).add(str);
        }
        return new LinkedList<>(map.values());
    }
}
