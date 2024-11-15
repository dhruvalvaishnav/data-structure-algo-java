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
        // Edge case: If the array is empty or contains only one price, no profit can be made
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int buyIndex = 0; // Pointer for the "buy" day
        int sellIndex = 1; // Pointer for the "sell" day
        int maxProfit = 0; // Variable to keep track of the maximum profit

        while (sellIndex < prices.length) {
            // If a profitable situation is found (sell price is greater than buy price)
            if (prices[buyIndex] < prices[sellIndex]) {
                // Calculate potential profit
                int profit = prices[sellIndex] - prices[buyIndex];
                // Update maxProfit if the current profit is higher than the previous maxProfit
                maxProfit = Math.max(maxProfit, profit);
            } else {
                // If the price at sellIndex is lower, update buyIndex to the current sellIndex
                // This means we are considering a new "buy" day as the previous one was not profitable
                buyIndex = sellIndex;
            }
            // Move the sellIndex forward to consider the next day for selling
            sellIndex++;
        }
        return maxProfit;
    }
}
