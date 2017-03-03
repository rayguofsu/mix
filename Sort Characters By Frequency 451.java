
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.


public class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return "";
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c: s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        //remember
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>(1, new Comparator<Map.Entry<Character, Integer>>(){
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2){
                return o2.getValue() - o1.getValue();
            }
        });
        pq.addAll(freqMap.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry e = pq.poll();
            int freq = (int) e.getValue();  //remember
            for (int i = 0; i < freq; i++){
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}
