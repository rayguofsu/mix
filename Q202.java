202. Happy Number
Total Accepted: 54106 Total Submissions: 152224 Difficulty: Easy

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1



public class Solution {
    public boolean isHappy(int n) {

















        Set<Integer> record = new HashSet<Integer>();
        int sum = 0;
        while (n != 1){
            if (record.contains(n)) return false; //if contains, it menas it loops
            record.add(n);
            while(n != 0){  //this while only goes through current number digit by digit
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;  //n is the new number
            sum = 0;  //clear sum for new number
        }
        return true;
    }
}
