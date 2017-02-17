240. Search a 2D Matrix II
Total Accepted: 26532 Total Submissions: 81163 Difficulty: Medium

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

For example,

Consider the following matrix:

[
  [1,   4,  6, 11, 15],
  [2,   5,  8, 12, 19],
  [6,   8,  9, 16, 22],
  [7,  13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.

Given target = 20, return false.

public class Solution {
    //idea is mine: just make use of the property to reduce the columns and rows via binary search
    //each time make a copy of the row and col; if for new iteration row and col not changed; then row and col is the index for the target
    public boolean searchMatrix(int[][] matrix, int target) {
       if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
       int col = matrix[0].length - 1;
       int row = 0;
       while (row >= 0 && col >= 0){
          int rowCp = row; 
          int colCp = col; 
          //reducing columns
          col = bsColumn(matrix, row, 0, col, target);
          if (col<0) return false; //make sure it is here
          //reducing rows
          row = bsRow(matrix, col, row, matrix.length - 1, target);
          if (rowCp == row && colCp == col) return true;//here is the target's index; since no more updates
       }
       return false;
    }
    private int bsColumn(int[][] matrix, int row, int left, int right, int target){
        int res = -1; //if not updated on res, then return -1
        while (left <= right){
           int mid = (left + right) / 2;
           if (matrix[row][mid] > target){
               right = mid - 1;
           }
           else if (matrix[row][mid] < target){
               left = mid + 1;
               res = mid; //record the most recent res here
           }
           else{
              return mid;
           }
        }
        return res;
    }

    private int bsRow(int[][] matrix, int col, int left, int right, int target){
        int res = -1;
        while (left <= right){
           int mid = (left + right) / 2;
           if (matrix[mid][col] > target){
               right = mid - 1;
               res = mid;
           }
           else if (matrix[mid][col] < target){
               left = mid + 1;
           }
           else{
              return mid;
           }
        }
        return res;
    }
}
