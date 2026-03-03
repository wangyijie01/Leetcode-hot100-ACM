package dp;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wangyijie
 * @Description: 完全平方数
 */
public class NumSquares {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numSquares(n));
        sc.close();
    }
    public static int numSquares(int n) {
        if(n < 1)
            return 0;
        if(n == 1){
            return 1;
        }

        int[] dp = new int[n + 1];
        for(int i = 1 ; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 1; i * i <= n; i++){
            for(int j = i * i; j <= n; j++){
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
            //System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }
}
