Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

public class Solution {
    public int maxProfit(int[] prices) {



















       //after reading discussion, this one is so tricky:
       //for consecutively increase portion, just buy at beggining and sell in the last entry of this portion, if next entry is smaller than last entry of this portion, consider to buy it if future has higher price than it; all these can be done with one sentence of code += i - (i - 1)
       int maxProfits = 0;
       for (int i = 1; i < prices.length; i++){
          if (prices[i] - prices[i - 1] > 0){
             maxProfits += prices[i] - prices[i - 1];
          }
       }
       return maxProfits;
    }
}
