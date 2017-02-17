;415. Add Strings
Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.


public class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int carry = 0;
        String res = "";
        int i = 0;
        int max = Math.max(len1, len2);
        for (i = 0; i <= max; i++){
            char a = '0', b = '0';
            if (i <= len1) a = char1[len1-i];
            if (i <= len2) b = char2[len2-i];
            int sum = a -'0' + b -'0'+ carry;
            //System.out.println("haha sum is " + sum);
            carry = sum / 10;
            sum %= 10;
            res = (char)(sum+'0') + res;
           // System.out.println("carry is " + carry);
        }
        if (carry == 1){
            res = '1' + res;
           // System.out.println("haha");
        }
        return res;
    }
}
