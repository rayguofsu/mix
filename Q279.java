// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
//
//For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9. 
//


public class Solution {
  public int numSquares(int n) {
   //just realized that DP means storing previous result and used for later
   //like below
   //the idea is to realize that if n = sqrt * sqrt, return 1; otherwise
   //                                      dp[n] = 1 + Min( //1+ is for the 1,4,9
   //                                                     dp[n - 1], //1 = 1^2
   //                                                     dp[n - 4], //4 = 2^2
   //                                                     dp[n - 9], //9 = 3^2
   //                                                        ...
   //                                                   );
    
    public class Solution {
    public int numSquares(int n) {
        if (n < 1) return 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
    
    
   int[] dp = new int[n + 1];
   for (int i = 1; i <= n; i++){
      dp[i] = Integer.MAX_VALUE;
   }
   for (int i = 1; i <= n; i++){
      int sqrt = (int) Math.sqrt(i);
      if (sqrt * sqrt == i){
         dp[i] = 1;
         continue;
      }
      int j = 1;

      while (j*j < i){
         dp[i] = Math.min(dp[i], dp[i - j*j]);
         j++;
      }
      dp[i]++; //dp[i] + 1 (1 is for the j*j)
   }
   return dp[n]; 
 }
}
