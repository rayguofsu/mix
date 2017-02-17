54. Spiral Matrix
Total Accepted: 48764 Total Submissions: 225113 Difficulty: Medium

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5]. 
//Gradually shrinking upper and lower boundaries, enclosing in towards the centre

public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<>();

    if (matrix.length == 0) {
        return list;
    }

    int ilow = 0, ihigh = matrix.length - 1;
    int jlow = 0, jhigh = matrix[0].length - 1;

    while (ilow <= ihigh && jlow <= jhigh) {
        // across
//        for (int j = jlow; j <= jhigh && ilow <= ihigh; j++) {
        for (int j = jlow; j <= jhigh; j++) {
            list.add(matrix[ilow][j]);
        }
        ilow++;

        // down
//        for (int i = ilow; i <= ihigh && jlow <= jhigh; i++) {
        for (int i = ilow; i <= ihigh; i++) {
            list.add(matrix[i][jhigh]);
        }
        jhigh--;

        // bottom   //below has ilow<= ihigh is to tell whether last for loop is executed, as 
                     //if not, then no need to do this for loop for bottom, as if cannot go down, no need to go from right to left on bottom, as you are on the same level and it will duplicate  
        for (int j = jhigh; j >= jlow && ilow <= ihigh; j--) {
            list.add(matrix[ihigh][j]);
        }
        ihigh--;

        // up
        for (int i = ihigh; i >= ilow && jlow <= jhigh; i--) {
            list.add(matrix[i][jlow]);
        }
        jlow++;
    }
    return list;
}



public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer>result = new ArrayList<Integer>();
        if(matrix==null||matrix.length==0||matrix[0]==null){return result;}
        int m = matrix.length;
        int n = matrix[0].length;
        int tm = (int)((double)m/2+ 0.5); 
        int tn = (int)((double)n/2+ 0.5); 
        int starti,endi,startj,endj;
        for(starti = 0,startj=0;starti<tm&&startj<tn;starti++,startj++){
            endi = m-1-starti;
            endj = n-1-startj;
            int i ,j;
            for(i = starti,j=startj;j<=endj;j++){
                result.add(matrix[i][j]);
            }
            for(i = starti+1,j=endj;i<=endi;i++){
                result.add(matrix[i][j]);
            }
            if(endi!=starti) //when last row or one row case; following will not be executed
             for(i = endi,j=endj-1;j>=startj;j--){
                result.add(matrix[i][j]);
            }
            if(endj!=startj)  //with this line, when last column or one column case; following will not be executed
             for(i = endi-1,j=startj;i>=starti+1;i--){
                result.add(matrix[i][j]);
            }
        }
        return result;
    }
}



