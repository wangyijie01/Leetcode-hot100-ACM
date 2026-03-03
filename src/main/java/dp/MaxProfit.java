package dp;
import java.util.Scanner;

/**
 *买卖股票的最佳时机
 */
public class MaxProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] arr = line.split(",");
        int[] prices = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            prices[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(maxProfit(prices));
        sc.close();
    }
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0 - prices[0];
        dp[0][1] = 0;

        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], 0 - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }

        return dp[prices.length - 1][1];
    }
}
