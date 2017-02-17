// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.
//
//Note:
//Have you consider that the string might be empty? This is a good question to ask during an interview.
//
//For the purpose of this problem, we define empty string as valid palindrome. 

public class Solution {
    //there are so many solutions; two pointer; stack; naive; recursion;
    //see link  http://www.programcreek.com/2013/01/leetcode-valid-palindrome-java/
    //it seems the two pointer one is much easier
    /*recursion
    public static boolean isPalindrome(String word) {
  //Strip out non-alphanumeric characters from string
  String cleanWord = word.replaceAll("[^a-zA-Z0-9]","");
  //Check for palindrome quality recursively
  return checkPalindrome(cleanWord);
}
private static boolean checkPalindrome(String word) {
  if(word.length() < 2) { return true;  }
  char first  = word.charAt(0);
  char last   = word.charAt(word.length()-1);
  if(  first != last  ) { return false; }
  else { return checkPalindrome(word.substring(1,word.length()-1)); }
}
*/
    public boolean isPalindrome(String s) {












        s = s.toLowerCase();
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i <= j){
           //pointer i moving from head
           if (!isValidChar(array[i])){
              i++;
              continue;
           }

           //pointer j moving from the end
           if (!isValidChar(array[j])){
              j--;
              continue;
           }

           //here means both i and j are valid
           if (array[i] != array[j]){
              return false;
           }
           
           i++;
           j--;
        }
        return true;
    }

    public boolean isValidChar(char c){
      return (c >= '0' && c <= '9' || c >= 'a' && c <= 'z');
    }
    
    //2 reverse string methods

/*1st
String string="whatever";
String reverse = new StringBuffer(string).reverse().toString();
System.out.println(reverse);
*/

/*2nd
public static String reverseIt(String source) {
    int i, len = source.length();
    StringBuilder dest = new StringBuilder(len);

    for (i = (len - 1); i >= 0; i--){
        dest.append(source.charAt(i));
    }

    return dest.toString();
}
*/


}
    

