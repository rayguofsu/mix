66. Plus One
Total Accepted: 85699 Total Submissions: 263050 Difficulty: Easy

Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

public class Solution {
    public int[] plusOne(int[] digits) { // the head of the list is bit 0























        int i = digits.length - 1;
        //start from the end backward; if consecutive 9; then give 0 and i--
        while (i > 0 && digits[i] == 9){
            digits[i] = 0;
            i--;
        }
        
        //when exiting while loop, if i == 0 && digits[i] = 9; then for 999, return 1000
        // 9 9 9
        if (i == 0 && digits[i] == 9){
            int[] results = new int[digits.length + 1];
            results[0] = 1;
            return results;
        }
        //when exiting while loop, if i != 0; OR i== 0 but digits[i] != 9; then:
        digits[i] += 1;
        return digits;
    }
}
