318. Maximum Product of Word Lengths
Total Accepted: 2836 Total Submissions: 7831 Difficulty: Medium

Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:

Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:

Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:

Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words. 
public class Solution {//on line bit manipulation: Java O(N*N) solution
public int maxProduct(String[] words) {
   int res = 0;
   if (words == null || words.length == 0) return res;
   int[] bits = new int[words.length];
   //bits[i] = 2'b1011 means word[i] (string) has a, b, d letters
   for (int i = 0; i < words.length; i++){
       for (int j = 0; j < words[i].length(); j++){
            char c = words[i].charAt(j);
            bits[i] = bits[i] | (1 << (c - 'a'));
       }
   }
   for (int i = 0; i < words.length; i++){
       for (int j = i + 1; j < words.length; j++){
          if ((bits[i] & bits[j]) == 0){//priority () needed
             res = Math.max(res, words[i].length() * words[j].length());
     	  }
       }
   }
   return res;
}
}
/*
public class Solution {
    public int maxProduct(String[] words) {//O(N^2) my solution time out
        int len = words.length;
        int maxP = 0;
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                int tmp = productCal(words, i, j);
                maxP = Math.max(maxP, tmp);
            }
        }
        return maxP;
    }
    private int productCal(String[] words, int i, int j){
        String a = words[i];
        String b = words[j];
        int[] mem = new int[128];
        for (i = 0; i < a.length(); i++){
            mem[a.charAt(i)] = 1;
        }
        for (i = 0; i < b.length(); i++){
            if (mem[b.charAt(i)] == 1) return 0;
        }
        return a.length() * b.length();
    }
}
*/

