You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

//this is the exact same question in chap 1 in cc150

public class Solution {
    //idea is to process layer by layer
    public void rotate(int[][] matrix) {
         int n = matrix.length - 1;
         for (int layer = 0; layer < matrix.length / 2; layer++){
            for (int i = layer; i < n - layer; i++){
               int tmp = matrix[layer][i]; //rotate by element to save space
               //from left to up
               matrix[layer][i] = matrix[n - i][layer];
               //from bottom to left;
               matrix[n - i][layer] = matrix[n - layer][n - i];
              //from right to bottom;
               matrix[n - layer][n - i] = matrix[i][n - layer];
             //from up to right
               matrix[i][n - layer] = tmp;
            }
         }
    }
}
