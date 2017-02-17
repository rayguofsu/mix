231. Power of Two

Given an integer, write a function to determine if it is a power of two. 

public class Solution {
    public boolean isPowerOfTwo(int n) {













        if (n <= 0) return false; //when n = -2147483648; 1111111111...100...0 somehow it return ture; so adding this for <  to pass leetcode only
        int m = n & (n - 1);
        return m == 0 ? true : false;
    }
}
