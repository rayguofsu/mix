304. Range Sum Query 2D - Immutable
Total Accepted: 10346 Total Submissions: 46951 Difficulty: Medium

Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D (pic missing)
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:

Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12

Note:

    You may assume that the matrix does not change.
    There are many calls to sumRegion function.
    You may assume that row1 ≤ row2 and col1 ≤ col2.
public class NumMatrix {

// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
private int[][] sumRegion;

public NumMatrix(int[][] matrix) {
    if (matrix.length != 0)  sumRegion = new int[matrix.length + 1][matrix[0].length + 1];
    //above define it by extra +1 is to make the code codable below; 
    for (int i = 0; i < matrix.length; i++) {
        int sum = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            sum += matrix[i][j]; //this sum accumulates the current row Sum
            sumRegion[i + 1][j + 1] = sum + sumRegion[i][j + 1]; //dp 
        }
    }
}

public int sumRegion(int row1, int col1, int row2, int col2) {
    return sumRegion[row2 + 1][col2 + 1] - sumRegion[row1][col2 + 1] - sumRegion[row2 + 1][col1] + sumRegion[row1][col1];
}
}
