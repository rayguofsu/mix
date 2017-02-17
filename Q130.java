Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

/*Analysis

This problem is similar to Number of Islands. In this problem, only the cells on the boarders can not be surrounded. So we can first merge those O's on the boarders like in Number of Islands and replace O's with '#', and then scan the board and replace all O's left (if any).
*/
public class Solution{
    private Queue<Integer> q = new LinkedList<Integer>();
    public void solve(char[][] board) {













       if (board == null || board.length == 0) return;
       //using BFS instead of DFS, as DFS recurse by 4 times, causing space memory issue, as stack of comuter will record all register settings for each recursion for all consecutive recursion
       int row = board.length;
       int col = board[0].length;
       //to merge Os on left boarder and on right boarder
       for (int i = 0; i < row; i++){
          if (board[i][0] == 'O'){
             bfs(board, i, 0);
          }
          if (board[i][col - 1] == 'O'){
             bfs(board, i, col - 1);
          }
       }
       //to merge 0s on top row and bottom row
       for (int i = 0; i < col; i++){
          if (board[0][i] == 'O'){
             bfs(board, 0, i);
          }
          if (board[row - 1][i] == 'O'){
             bfs(board, row - 1, i);
          }
       }
       //for the left over of Os, repalce them by Xs;
       //also revert back # to Os
       for (int i = 0; i < row; i++){
          for (int j = 0; j < col; j++){
              if (board[i][j] == 'O'){
                  board[i][j] = 'X';
              }
              else if (board[i][j] == '#'){
                  board[i][j] = 'O';
              }
          }
       }
    }

    private void bfs(char[][] board, int row, int col){
       replaceO(board, row, col);
       while (!q.isEmpty()){
         int index = q.poll();
         row = index / board[0].length;
         col = index % board[0].length;
         replaceO(board, row + 1, col);
         replaceO(board, row - 1, col);
         replaceO(board, row, col + 1);
         replaceO(board, row, col - 1);
       }
    }

    private void replaceO(char[][] board, int row, int col){
      int m = board.length - 1;
      int n = board[0].length - 1;
      if (row > m || row < 0 || col > n || col < 0 || board[row][col] != 'O')  return;
      board[row][col] = '#';
      q.offer(row * (n + 1) + col);
    }
}


public class Solution{//acutall do not need any que here, just as the other similar Que. //but somehow, this solution cause space limit should not be such case
    public void solve(char[][] board) { //this is DFS
       if (board == null || board.length == 0) return;
       //using BFS instead of DFS, as DFS recurse by 4 times, causing space memory issue, as stack of comuter will record all register settings for each recursion for all consecutive recursion
       int row = board.length;
       int col = board[0].length;
       //to merge Os on left boarder and on right boarder
       for (int i = 0; i < row; i++){
          if (board[i][0] == 'O'){
             bfs(board, i, 0);
          }
          if (board[i][col - 1] == 'O'){
             bfs(board, i, col - 1);
          }
       }
       //to merge 0s on top row and bottom row
       for (int i = 0; i < col; i++){
          if (board[0][i] == 'O'){
             bfs(board, 0, i);
          }
          if (board[row - 1][i] == 'O'){
             bfs(board, row - 1, i);
          }
       }
       //for the left over of Os, repalce them by Xs;
       //also revert back # to Os
       for (int i = 0; i < row; i++){
          for (int j = 0; j < col; j++){
              if (board[i][j] == 'O'){
                  board[i][j] = 'X';
              }
              else if (board[i][j] == '#'){
                  board[i][j] = 'O';
              }
          }
       }
    }

    private void bfs(char[][] board, int row, int col){
        int m = board.length - 1;
        int n = board[0].length - 1;
        if (row > m || row < 0 || col > n || col < 0 || board[row][col] != 'O')  return;
         board[row][col] = '#';
         bfs(board, row + 1, col);
         bfs(board, row - 1, col);
         bfs(board, row, col + 1);
         bfs(board, row, col - 1);
    }


}



public class Solution {
    private Queue<Integer> q = new LinkedList<Integer>();
    public void solve(char[][] board) {
       if (board == null || board.length == 0) return;
       //using BFS instead of DFS, as DFS recurse by 4 times, causing space memory issue, as stack of comuter will record all register settings for each recursion for all consecutive recursion
       int row = board.length;
       int col = board[0].length;
       //to merge Os on left boarder and on right boarder
       for (int i = 0; i < row; i++){
          if (board[i][0] == 'O'){
             bfs(board, i, 0);
          }
          if (board[i][col - 1] == 'O'){
             bfs(board, i, col - 1);
          }
       }
       //to merge 0s on top row and bottom row
       for (int i = 0; i < col; i++){
          if (board[0][i] == 'O'){
             bfs(board, 0, i);
          }
          if (board[row - 1][i] == 'O'){
             bfs(board, row - 1, i);
          }
       }
       //for the left over of Os, repalce them by Xs;
       //also revert back # to Os
       for (int i = 0; i < row; i++){
          for (int j = 0; j < col; j++){
              if (board[i][j] == 'O'){
                  board[i][j] = 'X';
              }
              else if (board[i][j] == '#'){
                  board[i][j] = 'O';
              }
          }
       }
    }

    private void bfs(char[][] board, int row, int col){
       replaceO(board, row, col);
       while (!q.isEmpty()){
         int index = q.poll();
         row = index / board[0].length;
         col = index % board[0].length;
         replaceO(board, row + 1, col);
         replaceO(board, row - 1, col);
         replaceO(board, row, col + 1);
         replaceO(board, row, col - 1);
       }
    }

    private void replaceO(char[][] board, int row, int col){
      int m = board.length - 1;
      int n = board[0].length - 1;
      if (row > m || row < 0 || col > n || col < 0 || board[row][col] != 'O')  return;
      board[row][col] = '#';
      q.offer(row * (n + 1) + col);
    }
}
