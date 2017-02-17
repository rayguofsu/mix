224. Basic Calculator
Total Accepted: 20507 Total Submissions: 101270 Difficulty: Medium

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:

"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23

Note: Do not use the eval built-in library function. 
public class Solution {
    //can use 25 + 5 + ((1+2) + 32) to walk through
  public int calculate(String s) {
       //idea is to ignore ' '; if '(', then store previous result and the sign for () into stack; then when ')' shows, pop the stack to get the sign for () and pop() again to add back the previous result from this pop
    int len = s.length(), sign = 1, result = 0;
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < len; i++) {
        if (Character.isDigit(s.charAt(i))) {
            int sum = s.charAt(i) - '0';
            while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                sum = sum * 10 + s.charAt(i + 1) - '0';
                i++;
            }
            result += sum * sign;
        } else if (s.charAt(i) == '+')
            sign = 1;
        else if (s.charAt(i) == '-')
            sign = -1;
        else if (s.charAt(i) == '(') {
            stack.push(result);
            stack.push(sign);
            result = 0;
            sign = 1;
        } else if (s.charAt(i) == ')') {
            result = result * stack.pop() + stack.pop();
        }
    }
    return result;
  }
}
