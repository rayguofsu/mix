79. Word Search
Total Accepted: 61144 Total Submissions: 280577 Difficulty: Medium

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

public class Solution {
    public boolean exist(char[][] board, String word) {

















       if (word == null || word.length() == 0) return true;
       if (board == null || board.length == 0 || board[0].length == 0) return false;
       int row = board.length;
       int col = board[0].length;
       boolean[][] visited = new boolean[row][col];
       char[] wordChar = word.toCharArray();
       for (int i = 0; i < row; i++){
         for (int j = 0; j < col; j++){
            //visited[i][j] = true; //this is not DP; this is just saying current path already has this one, as each spot can be used only once; otherwise, it may go endless circle 
            if (exploreBoard(board, wordChar, 0, visited, i, j)) 
 	            return true;
         }
       }
       return false;
    }

    private boolean exploreBoard(char[][] board, char[] word, int index, boolean[][] visited, int i, int j){
       if (index >= word.length) return true; //last char matched
       int row = board.length;
       int col = board[0].length;
       if (i < 0 || i >= row || j < 0 || j >= col){
          return false;
       } //above 2 ifs, order matters
       //why I have to initialize below line?
       //boolean dn = false;
       if (!visited[i][j] && board[i][j] == word[index]){ //has to has ! contition, as each spot can be used only once, if no mark, it may go endless circle
          visited[i][j] = true;
          boolean up = exploreBoard(board, word, index + 1, visited, i-1, j);
          boolean dn = exploreBoard(board, word, index + 1, visited, i+1, j);
          boolean left = exploreBoard(board, word, index + 1, visited, i, j-1);
          boolean right = exploreBoard(board, word, index + 1, visited, i, j+1);
          if (left || right || up || dn) return true;
          else visited[i][j] = false; //has to mark it as false, so it can be used by other path
       } 
       return false;
    }
}
