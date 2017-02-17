233. Number of Digit One
Total Accepted: 14106 Total Submissions: 61059 Difficulty: Medium

Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13. 
public class Solution {
    //CC150 Q18.4
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        String str = String.valueOf(n);
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            count += countOnes(n, i, str.charAt(str.length() - 1 - i)); //here is a little special as str.charAt(0) is the leftmost char; so need to revert it somehow
        }
        return count;
    }
    private int countOnes(int n, int i, char digit){
       int scaler = (int) Math.pow(10, i+1);
       int roundUp = (n / scaler + 1) * scaler;
       int roundDn = n / scaler * scaler;
       int residue = n % (int) Math.pow(10, i);
       if (digit - '1' > 0){
         return roundUp / 10;
       }
       else if (digit - '1' < 0){
         return roundDn / 10;
       }
       else {//if (digit == 1){
         return roundDn / 10 + residue + 1;
       }
    }
}
}
