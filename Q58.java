//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
//If the last word does not exist, return 0.
//
//Note: A word is defined as a character sequence consists of non-space characters only.
//
//For example,
//Given s = "Hello World",
//return 5. 
public class Solution {
    public int lengthOfLastWord(String s) { //my simplified version starting from back
        s = s.trim();
        int len = s.length();
        if (len <= 2) return len;
        for (int i = len - 1; i >= 0; i--){
            if (s.charAt(i) == ' ') return len - i - 1;
        }
        return len;
    }
}


public class Solution {
    public int lengthOfLastWord(String s) {













       char[] array = s.toCharArray();
       int length = array.length;
       int count = 0;
       //when "abc  "; the result should be 3, not 0;
       //so below is to recalculate the length by removing the trailing spaces
       while (length > 0 && array[length - 1] == ' '){//lenth > 0 is for length == 0's case
          length--;                       //as you need to access length - 1
       }
       for (int i = 0; i < length; i++){
          //reset counter when meeting ' '
          if (array[i] == ' '){
             count = 0;
          }
          else{
             count++;
          }
       }
       return count;
    }
     //per shiva, we can start from behind, but after I did that, for coner cases, I could 
     //not handle well, such as all while; empty or only one word with no space
}

