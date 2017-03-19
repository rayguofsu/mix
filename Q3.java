3. Longest Substring Without Repeating Characters
Total Accepted: 137224 Total Submissions: 630948 Difficulty: Medium

Given a string, find the length of the longest substring without repeating characters.
Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int start = 0, i = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if (!set.contains(c)){
                set.add(c);
                max = Math.max(max, set.size());
            }
            else{
                while(set.contains(c)){
                    set.remove(s.charAt(start++));
                }
                set.add(c);
            }
            i++;
        }
        return max;
    }
    
}
    
    
    
public class Solution { //My solution is much eaiser to understand.
    public int lengthOfLongestSubstring(String s){
        int max = 0;
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length()){
            char c = s.charAt(i);
            if (set.contains(c)){
                max = Math.max(max, i - j);
                while (set.contains(c)){
                    set.remove(s.charAt(j++));
                }
                set.add(c);
            }
            else{
                set.add(c);
            }
            i++;
        }
        return Math.max(max, i-j);
    }
}
public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) return 0;         
    int len = s.length();
    if (len == 1) return 1;         
    HashSet<Character> set = new HashSet<Character>();
    int i, j = 0, maxLen = 0;        
    for (i = 0; i < len; i++) {            
        char currentChar = s.charAt(i);            
        if ( set.contains(currentChar) ) {                
            maxLen = Math.max(maxLen, i-j);                
            while ( s.charAt(j) != s.charAt(i) ) set.remove(s.charAt(j++));  //to remove all previous chars until meeting the duplicate one then below line will do j++ to make j at next char
            j++;                
        } 
        else set.add(currentChar);            
    }        
    return Math.max(maxLen, i-j);         
}


//public class Solution { //off bell shape
//    public int lengthOfLongestSubstring(String s) {
//        //maybe need to revisit, as it stays off the bell shape
//        if (s == null) return 0;
//        List<Character> list = new ArrayList<Character>();
//        int maxLen = 0;
//        int i = 0;
//        while (i < s.length()){
//            char c = s.charAt(i);
//            if (!list.contains(c)){
//                list.add(c);
//            }
//            else{
//                int index = list.indexOf(c);
//                //the two methods below give the same results, but somehow the 2nd one gives time out
//                //(If fromIndex and toIndex are equal, the returned list is empty.)
//                list= new ArrayList<Character>(list.subList(index + 1, list.size()));
//                //list = list.subList(index + 1, list.size());
//                list.add(c);
//            }
//            maxLen = Math.max(maxLen, list.size());
//            i++;
//        }
//        System.out.println(Arrays.toString(list.toArray()));
//        return maxLen;
//    }
//}
