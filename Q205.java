Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (!map.containsKey(sChar)){
                if (!map.containsValue(tChar)){
                    map.put(sChar, tChar);
                }
                else{
                    return false;
                }
            }
            else if (map.get(sChar) != tChar) {
                return false;
            }
        }
        return true;
    }
}



public class Solution {








    Map<Character, Character> map = new HashMap<Character, Character>();
    public boolean isIsomorphic(String s, String t) {
       Set<Character> unique = new HashSet<Character>(); //this should be internal or external? Chris?
       if (s == null || s.isEmpty()) return true;
       int len = s.length();
       int i = 0;
       while (i < len){
          char sChar = s.charAt(i);
          char tChar = t.charAt(i);
          if (map.get(sChar) == null){
             if (unique.contains(tChar)){ //if others already match to tChar
                 return false;       //then this sChar wants to match again
             }                       //then we should return false here; because it says no two chs map to same
             unique.add(tChar);
             map.put(sChar, tChar);
          }
          else if (map.get(sChar) != tChar){ //if same sChar matches to other
                 return false;               //return false
          }
          i++;
       }
       return true;
    }
}
