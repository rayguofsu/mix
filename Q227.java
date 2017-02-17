227. Basic Calculator II
Total Accepted: 15852 Total Submissions: 69316 Difficulty: Medium

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:

"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
public class Solution {
   //idea is to use stack to store numbers and sign; 
  // e.g. 1 + 2*3 /2; 1 is added to stack; + is added to stack; and 2 is added to stack, * is added to stack;
  //then 3 is met, will see if the sign on top of stack is * or /, if yes, then pop() and pop() to get 2; then put 2*3 into stack and / is added to stack again, basically except last number; all number pushed into stack has a operator (+-*/) following it also which is also pushed to stack
  //in the second round, just looking at stack, now stack only has + and - operator in it
  //why needing 2 rounds, first round taking care of * / and last round for + -; thatis because, * / has higher priority if using one round only a + b *c; a+b will be done first, which is wrong.
  //this one does not have () ; what if have ()? 1 - ( 2 - 1 + 2) * (a * b); one way to do this is to first process the string by eliminating (); that is if '(' met, then if in front of '(' is '-', then you need to updating the operator inside () by making +  to -  and - to + and eleminate next ); then use the current solution to do it.  what if (())?
   public int calculate(String s) {
    Stack<Integer> stack = new Stack<Integer>();
    int len = s.length();
    for (int i = 0; i < len; i++) {
        if (Character.isDigit(s.charAt(i))) {
            int sum = s.charAt(i) - '0';
            while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                sum = sum * 10 + s.charAt(i + 1) - '0';
                i++;
            }
            if (!stack.empty() && (stack.peek() == 2 || stack.peek() == 3)) {
                int sign = stack.pop();
                int firstNumber = stack.pop();
                if (sign == 2)
                    stack.push(firstNumber * sum);
                else if (sign == 3)
                    stack.push(firstNumber / sum);
            } else
                stack.push(sum);
        } else if (s.charAt(i) == '+')
            stack.push(0);
        else if (s.charAt(i) == '-')
            stack.push(1);
        else if (s.charAt(i) == '*')
            stack.push(2);
        else if (s.charAt(i) == '/')
            stack.push(3);
    }

    int result = 0;
    while (!stack.isEmpty()) {
        if (stack.size() > 1) {
            int num = stack.pop();
            int op = stack.pop();
            if (op == 0)
                result += num;
            else if (op == 1)
                result -= num;
        } else
            result += stack.pop();
    }
    return result;
}
}


