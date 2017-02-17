91. Decode Ways
Total Accepted: 57438 Total Submissions: 340209 Difficulty: Medium

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2. 


//int foo = Integer.parseInt("1234");
//
//See the Java Documentation for more information.
//
//(If you have it in a StringBuffer, you'll need to do Integer.parseInt(myBuffer.toString()); instead).

public class Solution {
    public int numDecodings(String s) {
        //idea is simple; using base case and build, if one char, then two char; then 3 chars
        //so scanning it only once, for current index i, the total ways = oneEnd(ending with s[i] as signle one symbol) + twoEnd(ending with s[i] and s[i-1] as one sympbol)
       if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
       int oneEnd = 1;
       int twoEnd = 0;
       for (int i = 1; i < s.length(); i++){
          int val = Integer.parseInt(s.substring(i - 1, i + 1)); //exclusive ending
          int twoEndCopy = twoEnd;
          twoEnd = (val <= 26) ? oneEnd : 0; //twoEnd_next will be the same as oneEnd_pre, as just imaging counting last 2 chars as one way/oneEnd
          if (s.charAt(i) == '0'){ //as 0 cannot be single one symbol, so reseting oneEnd
             oneEnd = 0;
          }
          else{//otherwise, it is previous twoEnd + previous oneEnd
             oneEnd = twoEndCopy + oneEnd;
          }
       }
       return twoEnd + oneEnd;
    }
}
