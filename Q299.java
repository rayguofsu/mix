//You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
//
//For example:
//
//Secret number:  "1807"
//Friend's guess: "7810"
//
//Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
//
//Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".
//
//Please note that both secret number and friend's guess may contain duplicate digits, for example:
//
//Secret number:  "1123"
//Friend's guess: "0111"
//
//In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
//
//You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.


public class Solution {
    /*public String getHint(String secret, String guess) {
       //remember int[] can be used as hashtable
       //two pass solution: 
       // first pass: calculate bulls if i == i; for non-bulls, count current entry at index i in secret;
       // 2nd pass: for non-bulls, check if current entry in guess has a record; if so, cows++ and record of it --;
        
       int[] mem = new int[10];
       int bulls = 0;
       int cows = 0;
       for (int i = 0; i < secret.length(); i++){
           char s = secret.charAt(i);
           char g = guess.charAt(i);
           if (s == g) bulls++;
           else{
               mem[s - '0']++;
           }
       }
       for (int i = 0; i < secret.length(); i++){
           char s = secret.charAt(i);
           char g = guess.charAt(i);
           if (s != g && mem[g - '0'] != 0){
               mem[g - '0']--;
               cows++;
           }
       }
       return String.valueOf(bulls) + 'A' + String.valueOf(cows) + 'B';
    }
    */

    public String getHint(String secret, String guess) {
       //remember int[] can be used as hashtable
       //One pass solution: similar to two pass; if i == i bulls++;
       // if not {
       //1).first check to see if current secrete entry has less than 0 record, 
//       if so then it means previously has one same entry in guess;
//      2).  check to see if currrent guess entry has larger than 0 record, if yes, then it means previously has one same entry in secret;
//
//     last current secrete entry, its record++; for current guess entry, its record--;}
       int[] mem = new int[10];
       int bulls = 0;
       int cows = 0;
       for (int i = 0; i < secret.length(); i++){
           char s = secret.charAt(i);
           char g = guess.charAt(i);
           if (s == g) bulls++;
           else{
               if (mem[s - '0'] < 0){
                  cows++;
               }
               if (mem[g - '0'] > 0){
                  cows++;
               }
               mem[s - '0']++;
               mem[g - '0']--;
           }
       }
       return String.valueOf(bulls) + 'A' + String.valueOf(cows) + 'B';
    }
}
