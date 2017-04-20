 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"

Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S. 


public class Solution {
/*  
题解：

这道题也是用滑动窗口的思想，思想跟 Substring with Concatenation of All Words是一样的，同样是利用HashMap来存Dict，然后来遍历整个母串。因为这里是要求最短的包含子串的字符串，所以中间是可以允许有非子串字符的，当遇见非子串字符而count又没到子串长度时，可以继续走。

当count达到子串长度，说明之前遍历的这些有符合条件的串，用一个pre指针帮忙找，pre指针帮忙找第一个在HashMap中存过的，并且找到后给计数加1后的总计数是大于0的，判断是否为全局最小长度，如果是，更新返回字符串res，更新最小长度，如果不是，继续找。

这道题的代码也参考了code ganker的。
代码如下：
*/
 public class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return res;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int j = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            if (map.containsKey(sChar)){
                map.put(sChar, map.get(sChar) - 1);
                if (map.get(sChar) >= 0) count++;
                while(count == t.length()){
                    if (min > i - j + 1){
                        min = i - j + 1;
                        res = s.substring(j, i + 1);
                    }
                    char tChar = s.charAt(j);
                    if (map.containsKey(tChar)){
                        map.put(tChar, map.get(tChar) + 1);
                        if (map.get(tChar) > 0) count--;
                    }
                    j++;
                }
            }
        }
        return res;
    }
}
 
 
 
 
public String minWindow(String s, String t) {
    String res = "";
    if(s == null || t == null || s.length()==0 || t.length()==0) return res;
    Map<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray()){
        map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int j = 0;
    int count = 0;
    int min = s.length()  + 1;
    for (int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if (map.containsKey(c)){
            map.put(c, map.get(c) - 1);
            if (map.get(c) >= 0) count++;
            while (count == t.length()){
                char tChar = s.charAt(j);
                if (map.containsKey(tChar)){
                    if (map.get(tChar) == 0){
                        if (min > i - j + 1){
                            res = s.substring(j, i + 1);
                            min = i - j + 1;
                        }
                        count--;
                    }
                    map.put(tChar, map.get(tChar) + 1);
                }
                j++;
            }
        }
    }
    return res;
}
}
