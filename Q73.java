// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
//
//click to show follow up.
//Follow up:
//
//Did you use extra space?
//A straight forward solution using O(mn) space is probably a bad idea.
//A simple improvement uses O(m + n) space, but still not the best solution.
//Me: using an array of length of m+n to have a record of where zero happens
//Could you devise a constant space solution?
public class Solution {
    public void setZeroes(int[][] matrix) {









       //same question in char 1 in cc150
       int firstRow = 1;     //to process at last
       int firstColumn = 1;  //to process at last
       
       for (int column = 0; column < matrix[0].length; column++){
          if (matrix[0][column] == 0){
             firstRow = 0;
             break;
          }
       }

       for (int row = 0; row < matrix.length; row++){
          if (matrix[row][0] == 0){
             firstColumn = 0;
             break;
          }
       }

       //using the first row and fist column as marks//do not start from 0
       for (int row = 1; row < matrix.length; row++){
          for (int column = 1; column < matrix[0].length; column++){
             if (matrix[row][column] == 0){
                matrix[row][0] = 0;
                matrix[0][column] = 0;
             }
          }
       }

       //now 2nd pass to fill in zeros; starting from 1 intead of 0; as 0 has to process at last, if processing 0 earlier, all the marks in row 0 and column 0 will be lost and set to 0; doing this way is called never look back to the same spot
       
       for (int row = 1; row < matrix.length; row++){
          for (int column = 1; column < matrix[0].length; column++){
             if (matrix[0][column] == 0 || matrix[row][0] == 0){
                 matrix[row][column] = 0;
             }
          }
       }
       //continue on 2nd pass to fill in first row and first column; first has to be process last
      
       if (firstRow == 0){
           for (int column = 0; column < matrix[0].length; column++){
              matrix[0][column] = 0;
           }
       }
       if (firstColumn == 0){
           for (int row = 0; row < matrix.length; row++){
              matrix[row][0] = 0;
           }
       }
    }
}
