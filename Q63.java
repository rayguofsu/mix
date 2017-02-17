Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,

There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]

The total number of unique paths is 2.

Note: m and n will be at most 100.
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] dpWays = new int[m];
        dpWays[0] = 1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (obstacleGrid[i][j] == 1){
                    dpWays[j] = 0; continue;
                }
                if (j!=0) dpWays[j] = dpWays[j] + dpWays[j-1];
            }
        }
        return dpWays[m-1];
    }
}
public class Solution {
   public int uniquePathsWithObstacles(int[][] grid) {//O(m) space DP, explained
        int n = grid.length, m = grid[0].length;
        int[] dp = new int[m + 1]; //only need to save the result of previous row, instead of entire matrix
        dp[m - 1] = 1;
        for (int i = n - 1; i >= 0; i--){
           for (int j = m - 1; j >= 0; j--){
               if (grid[i][j] == 1) dp[j] = 0;
               else dp[j] = dp[j + 1] + dp[j]; //when updating: dp[j + 1] is ways from right, dp[j] on the right is ways from down neighbor
           }
        }
        return dp[0];
   }

The idea is same to other bottom up dp solutions.

    dp[i][j](total paths) = dp[i+1][j](paths via down neighbor) + dp[i][j+1](paths via right neighbor)
    Compared to UniquePaths, the only adaption need to make is make dp[i][j]=0 if it's an obstacle.

Observations:

    only need to save the result of previous row, instead of entire matrix
    initialize dp array with one more element will eliminate the necessity to check if i+1,j+1 is in boundary.

}
