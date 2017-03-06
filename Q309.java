309. Best Time to Buy and Sell Stock with Cooldown
Total Accepted: 8648 Total Submissions: 24313 Difficulty: Medium

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]


Best Time to Buy and Sell Stock with Cooldown
描述

Almost the ame as Best Time to Buy and Sell Stock II but with one restriction: after you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day).

Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]

分析

这题比Best Time to Buy and Sell Stock II多了一个cooldown的条件，就变得麻烦多了。这题是一个多阶段优化问题，首先范围缩小到广搜，贪心或者动规。因为每步之间互相牵连，贪心显然不行。广搜固然可以，不过是O(2^n)复杂度，所以我们先考虑用动规。

对于每一天，有三种动作，buy, sell, cooldown, sell 和 cooldown 可以合并成一种状态，因为手里最终没有股票。最终需要的结果是 sell，即手里股票卖了获得最大利润。我们可以用两个数组来记录当前持股和未持股的状态，令sell[i] 表示第i天未持股时，获得的最大利润，buy[i]表示第i天持有股票时，获得的最大利润。

对于sell[i]，最大利润有两种可能，一是今天没动作跟昨天未持股状态一样，二是今天卖了股票，所以状态转移方程如下：

sell[i] = max{sell[i - 1], buy[i-1] + prices[i-1]}

对于buy[i]，最大利润有两种可能，一是今天没动作跟昨天持股状态一样，二是前天卖了股票，今天买了股票，因为 cooldown 只能隔天交易，所以今天买股票要追溯到前天的状态。状态转移方程如下：

buy[i] = max{buy[i-1], sell[i-2] - prices[i]}

最终我们要求的结果是sell[n - 1]，表示最后一天结束时，手里没有股票时的最大利润。

这个算法的空间复杂度是O(n)，不过由于sell[i]仅仅依赖前一项，buy[i]仅仅依赖前两项，所以可以优化到O(1)，具体见第二种代码实现。
代码1 O(n)空间

// Best Time to Buy and Sell Stock with Cooldown
// Time Complexity: O(n), Space Complexity: O(n)
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        sell[0] = 0;
        buy[0] = -prices[0];

        for (int i = 1; i < prices.length; ++i) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);
        }
        return sell[prices.length - 1];
    }
}

代码2 O(1)空间

// Best Time to Buy and Sell Stock with Cooldown
// Time Complexity: O(n), Space Complexity: O(1)
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int curSell = 0;   // sell[i]
        int prevSell = 0;  // sell[i-2]
        int buy = -prices[0]; // buy[i]

        for (int i = 1; i < prices.length; ++i) {
            final int tmp = curSell;
            curSell = Math.max(curSell, buy + prices[i]);
            buy = Math.max(buy, (i > 1 ? prevSell : 0) - prices[i]);
            prevSell = tmp;
        }
        return curSell;
    }
}




/*Define:

profit1[i] = max profit on day i if I sell

profit2[i] = max profit on day i if I do nothing

How will those profits on day i+1 relate to profits on day i ?

1. profit1[i+1] means I must sell on day i+1, and there are 2 cases:

a. If I just sold on day i, then I have to buy again on day i and sell on day i+1

b. If I did nothing on day i, then I have to buy today and sell today
 

Taking both cases into account, profit1[i+1] = max(profit1[i]+prices[i+1]-prices[i], profit2[i])

2. profit2[i+1] means I do nothing on day i+1, so it will be max(profit1[i], profit2[i])
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int profit1 = 0;
        int profit2 = 0;
        for (int i = 1; i < prices.length; i++){
            int copy = profit1;
            profit1 = Math.max(profit1 + prices[i] - prices[i - 1], profit2);
            profit2 = Math.max(copy, profit2);
        }
        return Math.max(profit1, profit2);
    }
}
