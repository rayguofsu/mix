322. Coin Change
Total Accepted: 6363 Total Submissions: 25053 Difficulty: Medium

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin. 

/*public class Solution {
    public int coinChange(int[] coins, int amount) { //Running time reached limit; as n * n * n ...*n
       //similar to child running steps chap9.Q1; top down recursion
       if (amount <= 0 || coins == null || coins.length == 0) return 0;
       int[] dp = new int[amount];
       return coinChangeDp(coins, amount, dp);
    }
    private int coinChangeDP(int[] coins, int n, int[] dp){
       if (n < 0) return -1;
       if (n == 0) return 0;
       if (dp[n] > 0) return dp[n]; //this is the DP part; i.e already know/find min ways to make up n
       dp[n] = -1; //assume it cannot make up
       for (int i = 0; i < coins.length; i++){ //the book call it top down
           if (n < coins[i]) continue;
           int ways = coinChangeDp(coins, n - coin[i], dp);
           if (ways >= 0){ //== 0 is necessary
              if (dp[n] == -1) dp[n] = ways + 1; //first time having valid ways; using "if" can avoid Integer.MAX_VALUE;
              else dp[n] = Math.min(ways + 1, dp[n]);
           }
           //if all ways <0, dp[n] remains at -1
       }
       return dp[n];
    }
}
*/

public class Solution {
    public int coinChange(int[] coins, int amount) { //Running time O(amout * cois.length)
        if (coins == null || coins.length == 0 || amount <= 0) return 0;
        int[] dp = new int[amount + 1];
       //start from small value; we can make use of dp[i] when i = small value for larger i
        for (int i = 1; i <= amount; i++){ //dp[0]=0; 
           dp[i] = Integer.MAX_VALUE;
           for (int j = 0; j < coins.length; j++){ 
              if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE){//if i -coins[j] !=; then it means dp(i - coins[j]) is alreay visited and known; so just use it directly by below line; if it still == MAX_VALUE, it means, no way to reach it, so ignore it
                  dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); //has to reach dp[0] to get new value//this is how to save time by using dp part; as starting from smaller i
              }
           }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}






