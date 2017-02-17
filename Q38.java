The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string. 

public class Solution {
    public String countAndSay(int n) {











        if (n <= 0) return "error";
        if (n == 1) return "1";
        //recursion: base and build
        String result = countAndSay(n - 1);

        StringBuilder integer = new StringBuilder();
        //int foo = Integer.parseInt("result");
        char currentChar = result.charAt(0);
        int count = 0;
        for (char ch: result.toCharArray()){
            if (ch == currentChar){
                count++;
            }
            else{
                integer.append(count).append(currentChar);
                currentChar = ch;
                count = 1;
            }
        }
        //below is to handle the last trace of same chs//
        integer.append(count).append(currentChar);

        return (integer.toString());
    }
}
