263. Ugly Number
Total Accepted: 41574 Total Submissions: 116513 Difficulty: Easy

Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number. 

public class Solution {
    public boolean isUgly(int num) {
        //for ungly number n, it has to be 2^a * 3^b * 5^c//














        if (num == 0) return false;
        while (num != 1){
            if (num % 2 == 0) num /= 2; //if % == 0; then it is multiple, then remove one factor by /2
            else if (num % 3 == 0) num /= 3;
            else if (num % 5 == 0) num /= 5;
            else {
                return false;
            }
        }
        //for divide result == 1; return true
        return true;
    }
}
