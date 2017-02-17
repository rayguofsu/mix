// Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
// 
// For example,
// Given n = 3,
// You should return the following matrix:
// 
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]

//IMPORTANT: just realized that:
//two ways of recursion: top-down; bottom-up;
//for bottum-up, it is easy and popular;
//usually, it is like, has a return value; when n = 0 then return base case
//for n, n is built based on result = method(n-1)

//for top down; it is like this:(but for this, it can be repalced by iterative while easily)
//void method(n, int[] array){ //no return value
//  if (n == 0) return;
//   //do something for n;
//   //now do n-1 by below
//  method(n - 1, array)
//} //after top-down rearching n == 0 case, it is done

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) return matrix;
        int v = 0;
        int iL = 0, iH = n-1;
        while (v < n*n){
            for (int i = iL; i < iH; i++){
                matrix[iL][i] = ++v;
            }
            for (int i=iL; i < iH; i++){
                matrix[i][iH] = ++v;
            }
            for (int i = iH; i> iL; i--){
                matrix[iH][i] = ++v;
            }
            for (int i = iH; i>iL; i--){
                matrix[i][iL] = ++v;
            }
            iH--; iL++;
            if (v==n*n-1) break; //for odd n cases, for the last center element while cannot do it
        }
        if (n%2==1) matrix[n/2][n/2] = ++v;
        return matrix;
    }
}
public class Solution { //this is easier to understand
  public int[][] generateMatrix(int n) {//use the same solution as in Q54
    
    int[][] matrix = new int[n][n];
    int ilow = 0, ihigh = n - 1;
    int jlow = 0, jhigh = n - 1;
    int val = 1;
    while (ilow <= ihigh && jlow <= jhigh) {
        // across
        for (int j = jlow; j <= jhigh; j++) {
            //System.out.println("this is1 " + val + " " + ilow + " " + j);
            matrix[ilow][j] = val++;
        }
        ilow++;

        // down
        for (int i = ilow; i <= ihigh; i++) {
            //System.out.println("this is2 " + val + " " + jhigh + " " + i);
            matrix[i][jhigh] = val++;
        }
        jhigh--;

        // bottom   //below has ilow<= ihigh is to tell whether last for loop is executed, as 
                     //if not, then no need to do this for loop for bottom, as if cannot go down, no need to go from right to left on bottom, as you are on the same level and it will duplicate  
        for (int j = jhigh; j >= jlow && ilow <= ihigh; j--) {
            //System.out.println("this is3 " + val + " " + ihigh + " " + j);
            matrix[ihigh][j] = val++;
        }
        ihigh--;

        // up
        for (int i = ihigh; i >= ilow && jlow <= jhigh; i--) {
            //System.out.println("this is4 " + val + " " + i + " " + jlow);
            matrix[i][jlow] = val++;
        }
        jlow++;
    }
    return matrix;
  }
}
public class Solution {





    public int[][] generateMatrix(int n) {//can be done via top-down recursion
       //but when interview, do not always try to use recursion, recursion makes code clean, but may cost more space; try to use iteration codes; for top-down recursion, it is easy to repalce by using iterative codes
       //but for bottom-up/ base and build recursion, it may be hard to use iteration solution















       int[][] matrix = new int[n][n]; 
       int rowID = 0;
       int columnID = n - 1;
       int i = 1;
       int column = 0;
       int row = 0;
       while (rowID < n / 2){ //work from outter towards inner, divide each
          //level to left/right/bottom/up 4 parts
          for (column = rowID; column < columnID; column++){
             matrix[rowID][column] = i++;
          }
          //column = columnID here
          for (row = rowID; row < n - 1 - rowID; row++){
             matrix[row][column] = i++;
          }
          //rwo is fixed here now
          for(column = columnID; column > n - 1 - columnID; column--){
             matrix[row][column] = i++;
          }
          for (row = n - 1 - rowID; row > rowID; row--){
             matrix[row][column] = i++;
          }
          rowID++;
          columnID--;
       }
       //for odd n, the center is left, has to be handled by below
       if (n % 2 == 1){ //when n is odd
          matrix[n/2][n/2] = i;
       }
       return matrix;
    }
}


