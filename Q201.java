201. Bitwise AND of Numbers Range
Total Accepted: 27706 Total Submissions: 95794 Difficulty: Medium

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4. 
public class Solution {
    /*Time limit hit 
    public int rangeBitwiseAnd(int m, int n) {
        int tmp = m;
        int res = -1;
        while (tmp <= n){
           res &= tmp;
           tmp++;
        }
        return res;
    }*/
    public int rangeBitwiseAnd(int m, int n) {
     //say if m = 0b_xyz0abc ; n = 0b_xyz1def
     //the result will be 0b_xyz000; 
    //because from m to n, there has to be a number of 0b_xyz0111 and a number of 0b_xyz1000
    //therefore, the result will be 0b_xyz0000
     int i = 0;
     while (m != n){
        m >>= 1;
        n >>= 1;
        i++;
     }
     return (n << i);
    }
}

