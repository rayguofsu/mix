245. Shortest Word Distance III

This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list. 
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Map<String, Integer> map  = new HashMap<>();
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++){
            if (words[i].equals(word1)){
                if (map.containsKey(word2)) dist = Math.min(dist, i-map.get(word2));
                map.put(word1, i);
            }
            else if (words[i].equals(word2)){//with this else can get the duplicate case solved.
                if (map.containsKey(word1)) dist = Math.min(dist, i-map.get(word1));
                map.put(word2, i);
            }
        }
        return dist;
    }
}
