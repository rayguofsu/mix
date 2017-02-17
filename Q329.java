329. Longest Increasing Path in a Matrix
Total Accepted: 4298 Total Submissions: 14441 Difficulty: Medium

Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]

Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]

Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.


Java 14ms relative short & easy to code solution with explanation. O(mn) time O(mn) space. DFS + DP
The idea is simple and intuitive:
1. For each cell, try it's left, right, up and down for smaller number.
2. If it's smaller, means we are on the right track and we should keep going. If larger, stop and return.
3. Treat each cell as a start cell. Calculate and memorize the longest distance for this cell, so we don't need to calculate it again in the future.

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
       if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
       int max = 0;
       int[][] dp = new int[matrix.length][matrix[0].length];
       for (int i = 0; i < matrix.length; i++){
          for (int j = 0; j < matrix[0].length; j++){
             max = Math.max(max, findMax(i, j, matrix, Integer.MAX_VALUE, dp));
                                //returns how many steps can walk from i, j including itself as one step
          }
       }
       return max;
    }
    private int findMax(int i, int j, int[][] matrix, int pre, int[][] dp){
        // if out of bond OR current cell value larger than previous cell value.
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] >= pre){
           return 0;
        }  //dp[i][j] represent at current location i, j how many steps can go including itself as one step

        // if calculated before, no need to do it again
        if (dp[i][j] != 0) return dp[i][j];
        int tmp = 0;
        tmp = Math.max(tmp, findMax(i, j+1, matrix, matrix[i][j], dp));
        tmp = Math.max(tmp, findMax(i, j-1, matrix, matrix[i][j], dp));
        tmp = Math.max(tmp, findMax(i-1, j, matrix, matrix[i][j], dp));
        tmp = Math.max(tmp, findMax(i+1, j, matrix, matrix[i][j], dp));
        dp[i][j] = ++tmp;
        return tmp;
    }
}

