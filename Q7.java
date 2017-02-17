Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.
Have you thought about this?

Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
                
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Update (2014-11-10):
Test cases had been added to test the overflow behavior.

public class Solution {
    public int reverse(int x) {
       if (x < 0 && -x < 0) return 0; //here may have overflow on -x: so -x < 0 will check overflow; this line is for smallest neg number only
//example 2'bit case, if x = -2 = 2'b10; then -x will be 01 + 1 = 10; so -x will overflow when x is the largest negative number
       if (x < 0) return -1 * reverse(-x);  //here no overflow for -x
       int result = 0;
       while (x > 0){
         int digit = x % 10;
         if (result * 10 / 10 != result) return 0;   //this is to detect overflow, plz remeber
         result = result * 10 + digit;
         x /= 10;
        // if (result < 0) return 0; somehow this not work as for 1534236469; the result is not 0 somehow
       }
       return result;
    }

}
