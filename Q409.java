409. Longest Palindrome

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

public class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++){
            count[sChar[i]]++;
        }
        int res = 0, total = 0;
        for (int i = 0; i < 128; i++){
            res += count[i]/2*2; //if has 5 c; then can use 4 of them
            total += count[i];
        }
        if (total != res) return res+1;
        return res;
    }
}

