317. Shortest Distance from All Building
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

    Each 0 marks an empty land which you can pass by freely.
    Each 1 marks a building which you cannot pass through.
    Each 2 marks an obstacle which you cannot pass through.

For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.


public class Solution {

public int shortestDistance(int[][] grid) {
    int row = grid.length;
    if (row == 0) {
        return -1;
    }
    int col = grid[0].length;
    int[][] record1 = new int[row][col]; // visited num
    int[][] record2 = new int[row][col]; // distance
    int num1 = 0;
    for (int r = 0; r < row; r++) {
        for (int c = 0; c < col; c++) {
            if (grid[r][c] == 1) {
                num1 ++;
                boolean[][] visited = new boolean[row][col];
                Queue<int[]> queue = new LinkedList<int[]>();
                queue.offer(new int[]{r, c});
                int dist = 0;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        int[] node = queue.poll();
                        int x = node[0];
                        int y = node[1];
                        record2[x][y] += dist;
                        record1[x][y] ++;
                        if (x > 0 && grid[x - 1][y] == 0 && !visited[x - 1][y]) {
                            queue.offer(new int[]{x - 1, y});
                            visited[x - 1][y] = true;
                        }
                        if (x + 1 < row && grid[x + 1][y] == 0 && !visited[x + 1][y]) {
                            queue.offer(new int[]{x + 1, y});
                            visited[x + 1][y] = true;
                        }
                        if (y > 0 && grid[x][y - 1] == 0 && !visited[x][y - 1]) {
                            queue.offer(new int[]{x, y - 1});
                            visited[x][y - 1] = true;
                        }
                        if (y + 1 < col && grid[x][y + 1] == 0 && !visited[x][y + 1]) {
                            queue.offer(new int[]{x, y + 1});
                            visited[x][y + 1] = true;
                        }
                    }
                    dist ++;
                }
            }
        }
    }
    int result = Integer.MAX_VALUE;
    for (int r = 0; r < row; r++) {
        for (int c = 0; c < col; c++) {
            if (grid[r][c] == 0 && record1[r][c] == num1 && record2[r][c] < result) {
                result = record2[r][c];
            }
        }
    }
    return result == Integer.MAX_VALUE ? -1 : result;
}
//@harunrashidanver The time complexity for BFS/DFS is O(|V|+|E|), not O(|V||E|). In this problem, every vertex has up to 4 edges (left, right, up, down), so |E| ~ 4|V|. Thus, you have overall O(|V|) = O(mn) for a BFS. This has been proven for all sparse graphs like this problem. Now, we do a BFS for each building, so the overall complexity is O(#buildings*(mn)). In worst case, every vertex is a building. So the number of buildings is also upper bounded by O(mn), and thus you have O((mn)(mn)) = O(m^2n^2). This is a very loose bound since when every vertex is a building, we don't even need to do a BFS (nowhere to go).

}
