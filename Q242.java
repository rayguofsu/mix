242. Valid Anagram
Total Accepted: 74323 Total Submissions: 178801 Difficulty: Easy

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?





public class Solution {
    public boolean isAnagram(String s, String t) {










        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
        //way2:
        //String sortedS = new String (sChar);
        //String sortedT = new String (tChar);
        //return sortedS.equals(sortedT);
       /* ASCII defines 128 characters, which map to the numbers 0–127((256 in the extended set).).. Unicode defines (less than) 2^21 characters, which, similarly, map to numbers 0–2^21 (though not all numbers are currently assigned, and some are reserved).

Unicode is a superset of ASCII, and the numbers 0–128 have the same meaning in ASCII as they have in Unicode. For example, the number 65 means "Latin capital 'A'".

Because Unicode characters don't generally fit into one 8-bit byte, there are numerous ways of storing Unicode characters in byte sequences, such as UTF-32 and UTF-8.*/
    }
}
