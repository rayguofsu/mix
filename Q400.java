400. Nth Digit

Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3

Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.


public class Solution {
public int findNthDigit(int n) {
    if (n <= 9) return n;
    //n -= 1;
    int digits = 1, first = 1;

    while (n/9/first/digits >= 1) { //to conquer overflow
//= is due to rounding
        n -= 9 * first * digits;
        digits++;
        first *= 10;
        System.out.println("digit is " +digits + " first is " + first);
    }
    n--;//remember this trick; when charAt() start from 0;but n start from 1; can use n-- here for below
    return (first + n/digits + "").charAt(n%digits) - '0';
}
}
