358. Rearrange String k Distance Apart
 Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:

str = "aabbcc", k = 3

Result: "abcabc"

The same letters are at least distance 3 from each other.

Example 2:

str = "aaabc", k = 3 

Answer: ""

It is not possible to rearrange the string.

Example 3:

str = "aaadbbcc", k = 2

Answer: "abacabcd"

Another possible answer is: "abcabcda"

The same letters are at least distance 2 from each other.



/*
    Java 7 version of PriorityQueue O(nlogn) with comments and explanations：
    The greedy algorithm is that in each step, select the char with highest remaining count if possible (if it is not in the waiting queue). PQ is used to achieve the greedy. A regular queue waitQueue is used to "freeze" previous appeared char in the period of k.

In each iteration, we need to add current char to the waitQueue and also release the char at front of the queue, put back to maxHeap. The "impossible" case happens when the maxHeap is empty but there is still some char in the waitQueue.*/

//in my opioine heap is implemented by pq.
public class Solution {
    public String rearrangeString(String str, int k) {
        
        StringBuilder rearranged = new StringBuilder();
        //count frequency of each char
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        
        //construct a max heap using self-defined comparator, which holds all Map entries, Java is quite verbose
        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
                return entry2.getValue() - entry1.getValue();
            }
        });
        
        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        maxHeap.addAll(map.entrySet());
        
        while (!maxHeap.isEmpty()) {
            
            Map.Entry<Character, Integer> current = maxHeap.poll();
            rearranged.append(current.getKey());
            current.setValue(current.getValue() - 1);
            waitQueue.offer(current);
            
            if (waitQueue.size() < k) { // intial k-1 chars, waitQueue not full yet
                continue;
            }
            // release from waitQueue if char is already k apart
            Map.Entry<Character, Integer> front = waitQueue.poll();
            //note that char with 0 count still needs to be placed in waitQueue as a place holder
            if (front.getValue() > 0) {
                maxHeap.offer(front);
            }
        }
        
        return rearranged.length() == str.length() ? rearranged.toString() : "";
    }
    
}

/*
The idea is:

for example: "aaabbcc", k = 3

    Count the statistics of letters, sort them in terms of frequency in a descending way.

so it has the result: a - 3, b - 2, c - 2.

    Suppose the rewrite string length is len, divide the len into bins of size k, so in total
    you have

bin number of nBin = (len - 1) / k + 1,

with last bin size:

lastBinSize = len % k.

in the example, nBin = 3, lastBinSize = 1;

    Fill the same letter in different bins:

after filling 'a' ---> result = a##a##a

after filling 'b' ---> result = ab#ab#a

after filling 'c' ---> result = abcabca

Below is the implementation code:

public class Solution {
    private final static int sizeAZ = 26;
    public String rearrangeString(String str, int k) {
        if (k <= 1) return str;
        char[] c = str.toCharArray();
        int[][] cnt = new int[sizeAZ][2];
        int len = c.length;
        for (int i = 0; i < sizeAZ; cnt[i][0] = i++); // save letter id
        for (int i = 0; i < len; c[i++] = '*')
            cnt[c[i] - 'a'][1]++;
        
        // Sort according to occurance frequency, descending
        Arrays.sort(cnt, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        
        int nBin = (len - 1) / k + 1, sizeLastBin = len % k;
        int[] idx = new int[nBin];
        //System.out.println(nBin + ",,," + sizeLastBin);
        for (int u = 0, i = 0; u < sizeAZ; u++) if (cnt[u][1] > 0) {
            char ch = (char)(cnt[u][0] + 'a');
            int m = cnt[u][1];
            if (m > nBin) return ""; // Bins are not enough for ch, for sure
            for (int y = 0; y < m; y++) {
                while (idx[i] >= binSize(i, k, len)) 
                    i = (i + 1) % nBin;

                int offset = i * k;
                if (idx[i] > 0 && c[offset + idx[i] - 1] == ch) 
                    return ""; //same letter falls in same bin
                c[offset + idx[i]++] = ch;
                i = (i + 1) % nBin;
            }
        }
        return new String(c);
    }
    
    private int binSize(int i, int k, int len) {
        return Math.min(len - i * k, k);
    }
} //14ms



I think this is a great solution. More importantly, this solution gives the proof of why greedy method is correct. The greedy method says: if there exists a solution, the greedy method can find it (by always choosing the most frequent character first). The proof is: after choosing the most frequent character A, and fill these As into buckets, we can guarantee that their distance is >=k. However, if you don't choose greedy method, and choose some less frequent character B first, and fill Bs into buckets. Then you choose A, there is a chance that As might not have >=k distance apart (because #A > #B).

This code does not work for "abcdabcdabdeac", k = 4
Suppose there are n bins, one character is filled into the bins in the order m+1,...., n, 0, ..., m
The two characters filled into the bin m+1 and m have distance less than k, like the last two "d" in this example.*/
