package com.demo.neetcode.slidingWindow;

/*  https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and
    choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

    Example 1:
        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    Example 2:
        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transactions are done and the max profit = 0.


    Constraints:
        1 <= prices.length <= 105
        0 <= prices[i] <= 104

    space : O(1)
    time : O(n)

*/

public class BestTimeToBuySellStock {
    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1, 100};

        System.out.println("MAX PROFIT IS: " + calculateMaxProfitForOneStock(new int[]{}));
        System.out.println("MAX PROFIT IS: " + calculateMaxProfitForOneStock(prices));
        System.out.println("MAX PROFIT IS: " + calculateMaxProfitForOneStock(prices2));
    }

    private static int calculateMaxProfitForOneStock(int[] prices) {
        // left - buy and right - sell, maxProfit
        int left = 0, right = 1, maxProfit = 0;

        while (right < prices.length) {
            // profitable ??
            if (prices[left] < prices[right]) {
                // calculate profit
                final int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}
