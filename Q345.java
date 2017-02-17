345. Reverse Vowels of a String

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y". 
public class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        List<Integer> index = new ArrayList<>();
       for (int i = 0; i < s.length(); i++){
	      char c = s.charAt(i);
	      Set<Character> set = new HashSet<>();
	      if (valid(c)){
	         index.add(i);
          }
	    }
	int i = 0;
    while (i < index.size()/2){
	   int left = index.get(i);
	   int right = index.get(index.size()-1-i);
	   char c = s.charAt(left);
	   sb.setCharAt(left, s.charAt(right));
       sb.setCharAt(right, c);
       i++;
	}
        return sb.toString();
    }
    private boolean valid(char c){
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
