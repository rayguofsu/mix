266. Palindrome Permutation

Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True. 

public class Solution {//did it myselft; easy one
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++){
            map.put(sChar[i], map.getOrDefault(sChar[i], 0)+1);
        }
        int res = 0;
        for (Character key: map.keySet()){
            if (map.get(key) % 2 == 1) res++;
        }
        return  res < 2;
    }
}
