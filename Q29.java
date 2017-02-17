29. Divide Two Integers
Total Accepted: 54960 Total Submissions: 361222 Difficulty: Medium

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT. 


public class Solution {
    public int divide(int dividend, int divisor) {
       if (divisor == 0) return Integer.MAX_VALUE;
       if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
       int one = 1;
       if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
           one = -1;
       }
       int res = 0;
       long dvs = Math.abs((long) divisor); //has to use long as 2's complement //Math.abs(最小负数) 结果还是其本身. 在进行该运算前，要将其转化为long类型
       long dvd = Math.abs((long) dividend);
       while (dvd >= dvs){
          int z = one;
          long tmp = dvs << 1;
          while (dvd >= tmp){  //this while loop is for speed up only
             z <<= 1;
             tmp <<= 1;
          }
          dvd -= (tmp >> 1);
          res += z;
       }
       return res;
    }
}


/*public class Solution {//to slow version somehow
    public int divide(int dividend, int divisor) {
       if (divisor == 0) return Integer.MAX_VALUE;
       int one;
       if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
           one = -1;
       }
       else{
           one = 1;
       }
       int res = 0;
       divisor = divisor > 0 ? divisor : -divisor;
       dividend = dividend > 0 ? dividend : -dividend;
       int d = divisor;
       while(dividend >= d){
           d += divisor;
           res += one;
       }
       return res;
    }
    //public int abs(int num){
    //   return num > 0 ? num : -num;
    //}
}*/

