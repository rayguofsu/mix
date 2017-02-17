471. Encode String with Shortest Length

Given a non-empty string, encode the string such that its encoded length is the shortest.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.

Note:

    k will be a positive integer and encoded string will not be empty or have extra space.
    You may assume that the input string contains only lowercase English letters. The string's length is at most 160.
    If an encoding process does not make the string shorter, then do not encode it. If there are several solutions, return any of them is fine.

Example 1:

Input: "aaa"
Output: "aaa"
Explanation: There is no way to encode it such that it is shorter than the input string, so we do not encode it.

Example 2:

Input: "aaaaa"
Output: "5[a]"
Explanation: "5[a]" is shorter than "aaaaa" by 1 character.

Example 3:

Input: "aaaaaaaaaa"
Output: "10[a]"
Explanation: "a9[a]" or "9[a]a" are also valid solutions, both of them have the same length = 5, which is the same as "10[a]".

Example 4:

Input: "aabcaabcd"
Output: "2[aabc]d"
Explanation: "aabc" occurs twice, so one answer can be "2[aabc]d".

Example 5:

Input: "abbbabbbcabbbabbbc"
Output: "2[2[abbb]c]"
Explanation: "abbbabbbc" occurs twice, but "abbbabbbc" can also be encoded to "2[abbb]c", so one answer can be "2[2[abbb]c]".


public class Solution {

    
    /*Your solution is great! It's really helpful. I kinda stuck at how to split the string to get the pattern. After I saw how you do the DP part, I fixed my problem. Thx!
    public class Solution {
    public String encode(String s) {
        if(s == null || s.length() <= 4) return s;
        
        int len = s.length();
        
        String[][] dp = new String[len][len];
        
        // iterate all the length, stay on the disgnose of the dp matrix
        for(int l = 0; l < len; l ++) {
            for(int i = 0; i < len - l; i ++) {
                int j = i + l;
                String substr = s.substring(i, j + 1);
                dp[i][j] = substr;
                if(l < 4) continue;
                
                for(int k = i; k < j; k ++) {
                    if(dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k + 1][j];
                    }
                }
                
                String pattern = kmp (substr);
                if(pattern.length() == substr.length()) continue; // no repeat pattern found
                String patternEncode = substr.length() / pattern.length() + "[" + dp[i][i + pattern.length() - 1] + "]";
                if(patternEncode.length() < dp[i][j].length()) {
                    dp[i][j] = patternEncode;
                }
            }
        }
        
        return dp[0][len - 1];
    }
    
    private String kmp (String s) {
        int len = s.length();
        int[] LPS = new int[len];
        
        int i = 1, j = 0;
        LPS[0] = 0;
        while(i < len) {
            if(s.charAt(i) == s.charAt(j)) {
                LPS[i ++] = ++ j;
            } else if(j == 0) {
                LPS[i ++] = 0;
            } else {
                j = LPS[j - 1];
            }
        }
        
        int patternLen = len - LPS[len - 1];
        if(patternLen != len && len % patternLen == 0) {
            return s.substring(0, patternLen);
        } else {
            return s;
        }
    }
}

Here is the version of my code, really similar to yours. I changed the find pattern part use the KMP algorithm. Hope it's a little helpful :)*/

/*This is the first question I have answered in Leetcode. I hope you guys will like my solution. The approach here is simple. We will form 2-D array of Strings.
dp[i][j] = string from index i to index j in encoded form.

We can write the following formula as:-
dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j]) or if we can find some pattern in string from i to j which will result in more less length.

Time Complexity = O(n^3)

public class Solution {
*/
public String encode(String s) {
    String[][] dp = new String[s.length()][s.length()];
    
    for(int l=0;l<s.length();l++) {
        for(int i=0;i<s.length()-l;i++) {
            int j = i+l;
            String substr = s.substring(i, j+1);
            // Checking if string length < 5. In that case, we know that encoding will not help.
            if(j - i < 4) {
                dp[i][j] = substr;
            } else {
                dp[i][j] = substr;
                // Loop for trying all results that we get after dividing the strings into 2 and combine the   results of 2 substrings
                for(int k = i; k<j;k++) {
                    if((dp[i][k] + dp[k+1][j]).length() < dp[i][j].length()){
                        dp[i][j] = dp[i][k] + dp[k+1][j];
                    }
                }
                
                // Loop for checking if string can itself found some pattern in it which could be repeated.
                for(int k=0;k<substr.length();k++) {
                    String repeatStr = substr.substring(0, k+1);
                    if(repeatStr != null 
                       && substr.length()%repeatStr.length() == 0 
                       && substr.replaceAll(repeatStr, "").length() == 0) {
                          String ss = substr.length()/repeatStr.length() + "[" + dp[i][i+k] + "]";
                          if(ss.length() < dp[i][j].length()) {
                            dp[i][j] = ss;
                          }
                     }
                }
            }
        }
    }
    
    return dp[0][s.length()-1];
}
}
