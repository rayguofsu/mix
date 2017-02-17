326. Power of Three
Total Accepted: 18321 Total Submissions: 51840 Difficulty: Easy

Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion? 

public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;  //1 is power of 3!
        int exponent =(int) (Math.log(Integer.MAX_VALUE) / Math.log(3));
        int multiple = (int) Math.pow(3, exponent);
        System.out.println("multiple is " + multiple);
        return multiple % n == 0;
    }
}


public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        //1162261467 is power of 3; has only 3 as its factor
        return 1162261467 % n == 0 ? true : false;
    }
}
