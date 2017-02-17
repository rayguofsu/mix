291. Word Pattern II 

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Examples:

    pattern = "abab", str = "redblueredblue" should return true.
    pattern = "aaaa", str = "asdasdasdasd" should return true.
    pattern = "aabb", str = "xyzabcxzyabc" should return false.

Notes:
You may assume both pattern and str contains only lowercase letters. 

  public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        if (pattern == null || str == null) return false;
        return wordPatBacktrackR(pattern, 0, str, 0, map);
    }
    private boolean wordPatBacktrackR(String pattern, int i, String str, int j, Map<Character, String> map){
        //base case
        if (i == pattern.length() && j == str.length()) return true;
        if (i == pattern.length() || j == str.length()) return false;
        
        //recursion has two caes below
        char c = pattern.charAt(i);
        if (map.containsKey(c)){
            String cstring = map.get(c);
            if (cstring.length()>str.length()-j || !cstring.equals(str.substring(j, j+cstring.length()))) return false;
            return wordPatBacktrackR(pattern, i+1, str, j+cstring.length(), map);
        }
        
        for (int k = j; k < str.length(); k++){
            if (!map.containsValue(str.substring(j, k+1))){ //this line is for bijection; if no bijection requried, just remove it.
                map.put(c, str.substring(j, k+1));
                if (wordPatBacktrackR(pattern, i+1, str, k+1, map)) return true;
            }
        }
        map.remove(c);
        return false;
    }
}
