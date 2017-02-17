200. Number of Islands
Total Accepted: 29866 Total Submissions: 117492 Difficulty: Medium

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000

Answer: 1

Example 2:

11000
11000
00100
00011

Answer: 3
public class Solution { //do not need to have a queue
    public int numIslands(char[][] grid) {












        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    replaceBfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void replaceBfs(char[][] grid, int row, int col){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != '1'){
            return;
        }
        grid[row][col] = '#';
        replaceBfs(grid, row+1, col);
        replaceBfs(grid, row-1, col);
        replaceBfs(grid, row, col+1);
        replaceBfs(grid, row, col-1);
    }
}
public class Solution {
    private Queue<Integer> queue = new LinkedList<Integer>();
    public int numIslands(char[][] grid) {
       //Similar to Q130
       if (grid == null || grid.length == 0) return 0;
       int count = 0;
       for (int i = 0; i < grid.length; i++){
          for (int j = 0; j < grid[0].length; j++){
              if (grid[i][j] == '1'){//then this '1' will extend and merge with all adjacent ones and all changed to #
                 replaceOne(grid, i, j);
                 count++;
              }
          }
       }
       return count; 
    }

    private void replaceOne(char[][] grid, int row, int col){
       refillOne(grid, row, col); //has to mark 1 as #; otherwise, no way to distinguish whether new one belongs to which pile
       while(!queue.isEmpty()){
          int index = queue.poll();
          row = index / grid[0].length;
          col = index % grid[0].length;
          //merge and repalce all current adjacent ones with #
          refillOne(grid, row + 1, col);
          refillOne(grid, row - 1, col);
          refillOne(grid, row, col - 1);
          refillOne(grid, row, col + 1);
       }
    }
    private void refillOne(char[][] grid, int row, int col){
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] != '1') return;
        grid[row][col] = '#';
        queue.offer(row * grid[0].length + col);
    }
}
