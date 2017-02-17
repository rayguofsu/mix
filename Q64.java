Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
//this solution is very similiar to leetcode unique paths solution
//the idea is to first set the first row and the first column
//then re-fill the rest entries, to walk to each entry, there are only two ways:
//i.e. from up or from left; so the min of up and left entries is to the previous step result
//as walk along, in the end the bottom right is the minimum;
public class Solution {
    public int minPathSum(int[][] grid) {
       for (int column = 1; column < grid[0].length; column++){
          grid[0][column] += grid[0][column - 1];
       }
       for (int row = 1; row < grid.length; row++){
          grid[row][0] += grid[row - 1][0];
       }
       for (int row = 1; row < grid.length; row++){
           for (int column = 1; column < grid[0].length; column++){
               grid[row][column] += Math.min(grid[row][column - 1], grid[row - 1][column]);
           }
       }
       return grid[grid.length -1][grid[0].length - 1];
    }
}
