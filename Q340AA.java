340. Longest Substring with At Most K Distinct Characters

 Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3. 

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {//using Q159
            Map<Character, Integer> lastSeen = new HashMap<>();
    int low = 0, max = 0;
    for (int i = 0; i < s.length(); i++) {
        lastSeen.put(s.charAt(i), i);
        if (lastSeen.size() > k) {
            int toRemoveLastSeen = i;
            for (Integer val : lastSeen.values()) toRemoveLastSeen = Math.min(val, toRemoveLastSeen);
            lastSeen.remove(s.charAt(toRemoveLastSeen));
            low = toRemoveLastSeen + 1;
        }
        max = Math.max(max, i - low + 1);
    }
    return max;
        
    }
}
