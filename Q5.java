5. Longest Palindromic Substring
Total Accepted: 87223 Total Submissions: 397131 Difficulty: Medium

Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

public class Solution {
    public String longestPalindrome(String s) {
        //idea is to see whether charAt(i) == charAt(i+1) or charAt(i) == charAt(i + 2) then use subrutine to expand and generate palindrome string; runtime is O(kn)






















        String res = new String();
        if (s == null || s.length() <= 1) return s;//if length == 1; then it is palindrom, should return it
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (i + 1 < s.length() && s.charAt(i + 1) == c){
                String newPalin1 = panLinGen(s, i, i+1);
                if (newPalin1.length() > res.length()){
                    res = newPalin1;
                }
            }
            if (i + 2 < s.length() && s.charAt(i + 2) == c){
                String newPalin2 = panLinGen(s, i, i+2);
                if (newPalin2.length() > res.length()){
                    res = newPalin2;
                }
            }
        }
        return res;
    }
    private String panLinGen(String s, int start, int end){
        while(start >= 0 && end < s.length()){
            if (s.charAt(start) != s.charAt(end)) break;
            else{
                start--;
                end++;
            }
        }
        return s.substring(start+1, end);
    }
}
