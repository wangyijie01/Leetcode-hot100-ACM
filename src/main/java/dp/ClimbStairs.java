package dp;
import java.util.*;

/**
 * 爬楼梯
 *
 * n = 6
 * 13
 */
public class ClimbStairs {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(climbStairs(n));
        sc.close();
    }
    public static int climbStairs(int n) {
        if(n < 0){
            System.out.println("不合理");
            return -1;
        }
        if(n <= 2){
            return n;
        }
        int a = 1;
        int b = 2;
        int c;
        for(int i = 3; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
