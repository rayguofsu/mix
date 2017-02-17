151. Reverse Words in a String
Total Accepted: 85117 Total Submissions: 551381 Difficulty: Medium

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.
Clarification:

    What constitutes a word?
    A sequence of non-space characters constitutes a word.
    Could the input string contain leading or trailing spaces?
    Yes. However, your reversed string should not contain leading or trailing spaces.
    How about multiple spaces between two words?
    Reduce them to a single space in the reversed string.

public class Solution {
    //for queue; when to use offer or add? remove or poll? mostly implemented by linkedlist
    //The difference is that offer() will return false if it fails to insert the element on a size restricted Queue, whereas add() will throw an IllegalStateException.
    //The remove() and poll() methods differ only in their behavior when the queue is empty: the remove() method throws an exception, while the poll() method returns null. 
    //
    //Most ppl want no exception, only false or null when in empty/full condition, so to use offer and poll

    //for stack, just use push and pop
    public String reverseWords(String s) {
       if (s == null) return null;
       //String str = s.toLowerCase();
       String str = s.trim(); //may not needed due to continue; it turns out that it is still needed as without it, cannot handle trailing spaces
       StringBuffer sentence = new StringBuffer(); //only for time efficient; as string contactenation too costy; see Chapter 1
       int i = 0;
       while(i < str.length()){
          if (str.charAt(i) == ' '){
             i++;
             continue;
          }
          int j = i;
          while (i < str.length() && str.charAt(i) != ' '){//&& is for last word
             i++;
          }
          sentence.insert(0, str.substring(j, i));
          if (i != str.length()){ //for the last word having no trailing ' '//this if is just like a flag
             sentence.insert(0, ' ');
          }
       }
       return sentence.toString();
   }
}
