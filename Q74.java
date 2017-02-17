Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

Given target = 3, return true.

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
           return false;
        }
        //first use BS to find which row it possibly resides
        int row = binarySearchRow(matrix, target);
        if (row == -1) return false;
        int low = 0;
        int high = matrix[row].length;
        int mid;
        while(low <= high){ //remember there is = condition here
            mid = (low + high) / 2;
            if (matrix[row][mid] == target){
               return true;
            }
            else if (target < matrix[row][mid]){
               high = mid - 1;
            }
            else if (target > matrix[row][mid]){
               low = mid + 1;
            }
        }
        return false;
    }
    private int binarySearchRow(int[][] matrix, int target){
        
        int low = 0;
        int high = matrix.length - 1;
        int width = matrix[0].length - 1;
        //System.out.println("yesno " + high + " " + width);
        int mid;
        while(low <= high){
            mid = (low + high) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][width]){
                return mid;
            }
            else if (target > matrix[mid][width]){
                low = mid + 1;
            }
            else if (target < matrix[mid][0]){
                high = mid - 1;
            }
        }
        return -1;
    }
}
