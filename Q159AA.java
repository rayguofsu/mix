159. Longest Substring with At Most Two Distinct Characters 
 Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3. 

Simple O(n) java solution - easily extend to k characters
The main idea is to maintain a sliding window with 2 unique characters. The key is to store the last occurrence of each character as the value in the hashmap. This way, whenever the size of the hashmap exceeds 2, we can traverse through the map to find the character with the left most index, and remove 1 character from our map. Since the range of characters is constrained, we should be able to find the left most index in constant time.
public int lengthOfLongestSubstringTwoDistinct(String s) {
    Map<Character, Integer> lastSeen = new HashMap<>();
    int low = 0, max = 0;
    for (int i = 0; i < s.length(); i++) {
        lastSeen.put(s.charAt(i), i);
        if (lastSeen.size() > 2) {
            int toRemoveLastSeen = i;
            for (Integer val : lastSeen.values()) toRemoveLastSeen = Math.min(val, toRemoveLastSeen);
            lastSeen.remove(s.charAt(toRemoveLastSeen));
            low = toRemoveLastSeen + 1;
        }
        max = Math.max(max, i - low + 1);
    }
    return max;
}
