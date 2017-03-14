186. Reverse Words in a String II 
 Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space? 
   public static void reverseWords(char[] s) {//mine
        //first reverse the entire word
        //the sky is blue becomes " eulb si kys eht"
        //then reverse each word
        //it becomes "blue is sky the"
        reverse(s, 0, s.length-1);
        int start = 0;
        int i = 0;
        while(i < s.length){
            if (s[i] == ' '){
              reverse(s, start, i - 1);
              start = i + 1;
            }
            i++;
        }
        reverse(s, start, s.length - 1);
    }


public class Solution {
    public void reverseWords(char[] s) {
        //first reverse the entire word
        //the sky is blue becomes " eulb si kys eht"
        //then reverse each word
        //it becomes "blue is sky the"
        reverse(s, 0, s.length-1);
        int r = 0;
        int l = 0;
        while(r < s.length){
            l = r;
            while(r < s.length && s[r] !=' '){
                r++;
            }
            reverse(s, l, r-1);
            r++;
        }
    }
    private void reverse(char[] s, int l, int r){
        while(l < r){
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }
}
