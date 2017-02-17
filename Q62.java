//
//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//How many possible unique paths are there?

//On line solution here
public class Solution {
    public int uniquePaths(int m, int n) {
        int[] path = new int[n];
        path[0] = 1;
        for (int i = 0; i < m; i++){
            for (int j = 1; j < n; j++){
                path[j] += path[j-1];
            }
        }
        return path[n-1];
    }
}


public class Solution {
    public int uniquePaths(int m, int n) {







    //idea is also simple:
    //there are same number of ways to go from origin to (m-1, n-1)
    // as ways to go from (m-1, n-1) to origin
    //so just start from origin
    int[][] ways = new int[m][n];  //ways store the number of ways from origin to (x,y)
    //there is only one way to go from origin to (0, x) or to (y,0)
    //so below two for loop, put one way into row 0 and column 0
    for (int i = 0; i < m; i++){
       ways[i][0] = 1;
    }
    for (int i = 0; i < n; i++){
       ways[0][i] = 1;
    }
//now start filling number of ways from origin to (row, column) into ways[row][column]
    for (int row = 1; row < m; row++){
        for (int column = 1; column < n; column++){
                           //number of ways from up +  number of ways from left
           ways[row][column] = ways[row - 1][column] + ways[row][column -1];
        }
    }

    return ways[m-1][n-1];
    }
}
//DP solution here //time cost too long

/*public class Solution {
    public int uniquePaths(int m, int n) {
           int[][] ways = new int[m][n];
           return uniquePathsDP(m - 1, n -1, ways);
           
      //  this method just calculate the factorial, but it has overflow issue for large input
      // int totalSteps = m + n - 2;
      // int min = m > n ? (n - 1) : (m - 1);
      // int numeritor = 1;
      // int denomiritor = 1;
      // for (int i = 0; i < min; i++){
      //     numeritor *= (totalSteps - i);
      //     System.out.println("num is " + numeritor);
      //     denomiritor *= (min - i);
      //     //even after doing below, integer numeritor may still overflow for large input
      //     if (numeritor % denomiritor == 0){
      //         numeritor = numeritor / denomiritor;
      //         denomiritor = 1;
      //     }
      // }
      // return numeritor / denomiritor;
      // 
        
    }
    public int uniquePathsDP(int m, int n, int[][] ways) {//time complex O(n * m); space complex O(max(n, m))
        System.out.println("m is " + m + " n is " + n);
        if (m < 0 || n < 0) return 0;
        if (m == 0 && n == 0){
            return 1;
        }
        if (ways[m][n] != 0) {
           //System.out.println("iam here m is " + m + " n is " + n);
           return ways[m][n];
        }
        int count = uniquePathsDP(m - 1, n, ways) + uniquePathsDP(m, n - 1, ways);
        //System.out.println("iam here2 m is " + m + " n is " + n);
        ways[m][n] = count;
        return count;
    }
}
*/




/*import java.util.*;
public class Q62{ //another DP solution this works, has an class called Po where both hashcode and equals method are overrride
    public static HashMap<Po, Integer> map = new HashMap<Po, Integer>();
    public static int uniquePaths(int m, int n) {
        Po p = new Po(m, n);
        if (map.containsKey((Po) p)) {
            System.out.println("contains Key return at m =  " + m + " n = " + n);
            return map.get(p);
        }
       
        if (m < 1 || n < 1){
            return 0;
        }
        if (m == 1 && n == 1){
            return 1;
        }
        int result = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        map.put(p, result);
        return result;
    }
    //
    public static void main(String[] args){
       int n = 3;
       int m = 3;
       System.out.println("there are totally: " + uniquePaths(m, n));

    }
}
*/
