package dp;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: wangyijie
 * @Description: 杨辉三角
 */
public class Generate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numRows = sc.nextInt();
        System.out.println(generate(numRows));
    }
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>(List.of(1)));
        for(int i = 1; i < numRows; i++){
            List<Integer> row = new LinkedList<>();
            row.add(1);
            for(int j = 1; j < i; j++){
                row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
