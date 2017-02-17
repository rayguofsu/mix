438. Find All Anagrams in a String

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] win = new int[256];
        int [] slide = new int[256];
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) return list;
        //preload
        for (int i = 0; i < p.length(); i++){
            slide[s.charAt(i)-'a']++;
            win[p.charAt(i) -'a']++;
        }
        for (int i = 0; i < s.length() ; i++){
            if (match(win, slide)){
                list.add(i);
            }
            slide[s.charAt(i)-'a']--;
            if (i < s.length() - p.length()) slide[s.charAt(i+p.length())-'a']++;
            else break;
        }
        return list;
    }
    private boolean match(int[] win, int[] slide){
        for (int i = 0; i < 256; i++){
            if (win[i] != slide[i]) return false;
        }
        return true;
    }
}
