Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0], max = 0;
        for (int i = 1;  i< prices.length; i++){
            min = prices[i] < min ? prices[i] : min;
            max = Math.max(max, prices[i]-min);
        }
        return max;
    }
}


public class Solution {
    public int maxProfit(int[] prices) {




















        //this is to find Max(prices[j] - prices[i]) given that j > i;
        //just use two pointer similar: use min to store miminum so far and max
        // to store the max benefits so far
        if (prices == null || prices.length == 0) return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++){
            if (prices[i] < min){
               min = prices[i];
            }
            else{ //here you can make money by selling it
               int tmp = prices[i] - min;
               if (tmp > max){
                  max = tmp;
               }
            }
        }
        return max;
    }
}
