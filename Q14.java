14. Longest Common Prefix
Total Accepted: 86267 Total Submissions: 315530 Difficulty: Easy

Write a function to find the longest common prefix string amongst an array of strings. 

public class Solution {
  public String longestCommonPrefix(String[] strs) {
















      if (strs == null || strs.length == 0) return "";
      //find the shortest length of Strings
      int minLen = Integer.MAX_VALUE;
      for (String str: strs){
          if (minLen > str.length()){
              minLen = str.length();
          }
      }
      
      //two for loop: one goes by minLen; the other one goes by length of String array
      
      for (int i = 0; i < minLen; i++){
          char pre = '0'; //must be initialized
          for (int j = 0; j < strs.length; j++){
              if (j == 0){  //hold it in tmp register for compair later
                  pre = strs[0].charAt(i);
                  continue;
              }
              else{
                  if (pre != strs[j].charAt(i)){
                      return strs[j].substring(0, i);
                  }
              }
          }
      }
      System.out.println("min length is " + minLen);
      return strs[0].substring(0, minLen);
  }

}
