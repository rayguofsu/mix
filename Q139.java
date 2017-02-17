139. Word Break
Total Accepted: 75819 Total Submissions: 312369 Difficulty: Medium

Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code". 

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {














    if (s == null || s.length() == 0) return true;
    if (wordDict == null || wordDict.size() == 0) return false;
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++){
       //the idea is to use dp to see whether able to genearte the word from (0, i) exclusive i; so need to look back to dp[i] where i =[0, i); if any dp[i] is true in range of [0, i); then will check whether word[j,i) is in wordDict
       for (int j = 0; j < i; j++){
          if (dp[j] && wordDict.contains(s.substring(j, i))){
             dp[i] = true;
             break; //to save time
          }
       }
    }
    return dp[s.length()];
    }
}

/*public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        //this causing timing long error
       //if (s == "") return true; wrong
       if (s.equals("")) return true;
       for (int i = 0; i < s.length(); i++){
          String sub = s.substring(0, i + 1); //(0, 0) gives ""??
          if (wordDict.contains(sub)){
             boolean rest = wordBreak(s.substring(i+1), wordDict);
             if (rest == true) return true;
          }
       } 
       return false;
    }
}
*/
