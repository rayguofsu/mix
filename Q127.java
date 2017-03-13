127. Word Ladder
Total Accepted: 65144 Total Submissions: 333116 Difficulty: Medium

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the word list

For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
public class Solution {//O(n*m( n IS THE LENGTH OF BEGINWORD, m is the size of wordList
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
       if (beginWord.equals(endWord)) return 1;
       Map<String, Integer> map = new HashMap<String, Integer>();
       map.put(beginWord, 1);
       //breath first search; each letter branch to all strings with that letter changed
       //similar to cc150 Q.18.10
       
       Queue<String> queue = new LinkedList<String>();
       queue.offer(beginWord);
       while(!queue.isEmpty()){
          String str = queue.poll();
          for (String word: oneEditWords(str)){
             if (word.equals(endWord)){
                return map.get(str) + 1;
             }
             if (wordList.contains(word)){//map act as DP mem; also keep the distance in key's value; act as visited also; if map containsKey of it; then no need to update the value; as this is breath first search, i.e. by level, the first time visiting it gives the smallest level counting from top
                if (!map.containsKey(word)){ 
                   map.put(word, map.get(str) + 1);
                   queue.offer(word);
                }
             }
          }
       }
       return 0;
    }
    private List<String> oneEditWords(String str){
       List<String> list = new ArrayList<String>();
       for (int i = 0; i < str.length(); i++){
          char[] charArray = str.toCharArray();
          for (char j = 'a'; j <= 'z'; j++){ //importment, remember
              //if (j != charArray[i]) charArray[i] = j; //not good, will also include origital str
              if (j != str.charAt(i)) charArray[i] = j;
              list.add(new String(charArray));
          }
       }
       return list;
    }
}





