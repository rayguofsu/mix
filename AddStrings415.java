Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.



public class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null) return num2;
        if (num2 == null) return num1;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        String longS = num1.length() > num2.length() ? num1 : num2;
        String shortS = num1.length() > num2.length() ? num2 : num1;
        int lenLong = longS.length();
        int lenShort = shortS.length();
        for (int i = 0; i < lenLong; i++){
            int n1 = longS.charAt(lenLong - 1 - i) - '0';
            int n2 = i < lenShort ? shortS.charAt(lenShort - 1 - i) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            res.append(sum % 10);
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }
}
