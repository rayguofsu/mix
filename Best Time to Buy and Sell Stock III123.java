Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).



public class Solution {
    public int maxProfit(int[] prices) {
                if (prices == null || prices.length == 0) return 0;
        //try O(N) solution with twice DP, from left to right ([i] - min); from right to left (max - [i]);
        
        //from left to right;
        int len = prices.length;
        int[] left = new int[len];
        int[] right = new int[prices.length];
        
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++){
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        //from right to left
        right[len - 1] = 0;
        int max = prices[len - 1];
        for (int i = len - 2; i >= 0; i--){
           // System.out.println("i is " + i);
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(prices[i], max);
        }
        //has overlap, it is OK, as when overlapping, it becomes max - p + p - min = max - min; means one transaction which is allowed.
        int global = 0;
        for (int i = 0; i < len; i++){
            int profit = left[i] + right[i];
            global = Math.max(global, profit);
        }
        return global;
    }
        
        /*//O(n ^ 2) solution
        if (prices == null || prices.length == 0) return 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++){
            int p1 = helper(prices, 0, i);
            int p2 = helper(prices, i + 1, prices.length - 1);
            max = Math.max(max, p1 + p2);
        }
        return max;
    }
    private int helper(int[] prices, int start, int end){
        if (start >= end) return 0;
        int max = 0;
        int min = prices[start];
        for (int i = start + 1; i <= end; i++){
            max = Math.max(max, prices[i] - min);
            min = Math.min(prices[i], min);
      
        }
        return max;
    } */
}
