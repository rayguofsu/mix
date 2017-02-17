463. Island Perimeter
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:
public class Solution {
    public int islandPerimeter(int[][] grid) {
        if ( (grid == null) || (grid.length==0) || (grid[0].length==0) ) {
            return 0;
        }
        
        int sides = 0;
        
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == 1) {//check the yellow fig carefully, you will find
          // every == 1 entry has the right of contribute side += 4 by following lines
                    sides += getSide(grid, i-1, j);
                    sides += getSide(grid, i+1, j);
                    sides += getSide(grid, i, j-1);
                    sides += getSide(grid, i, j+1);
                }
            }
        }
        
        return sides;
    }
    
    private int getSide(int[][] grid, int i, int j) {
        if ( (i<0) || (j<0) || (i>=grid.length) || (j>=grid[i].length) || (grid[i][j]==0) ) {
            return 1;
        }
        
        return 0;
    }
}
