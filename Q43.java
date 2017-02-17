43. Multiply Strings
Total Accepted: 57404 Total Submissions: 248208 Difficulty: Medium

Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.

public class Solution {
    public String multiply(String num1, String num2) {

















        int m = num1.length();
        int n = num2.length();
        int[] p = new int[m + n];
        for (int i = m - 1; i >=0 ; i--){
            for (int j = n - 1; j >= 0; j--){
                int p1 = i + j;
                int p2 = i + j + 1;  //last digit is m - 1 + n - 1 + 1 = m + n -1 //first digit is 0; therefore, totally m+n digits
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int product = n1 * n2;
                int sum = product + p[p2];
                p[p2] = sum % 10;
                p[p1] += sum / 10; //here p[p1] can be larger than 10, but it does not matter, as later p1 will become p2 for some index i, j// then it will get %10;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int digit : p){
            if (digit != 0 || res.length()!= 0){ //for leading zeros, will skipp "them" by this line
                res.append(digit);
            }
        }
        return res.length() == 0 ? "0" : res.toString();
       /* int num12 = Integer.parseInt(num1);
        int num22 = Integer.parseInt(num2);
        return Integer.toString(num12 * num22); //arbitary larget, i.e. cannnot mutiply it
        //Normal ways would be Integer.toString(i) or String.valueOf(i).
        */
    }
}
