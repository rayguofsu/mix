//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '('){
                stack.push(c);
            }
            else{
                if (stack.isEmpty()) return false;
                char tmp = stack.pop();
                if (c == ')' && tmp != '(') return false;
                if (c == ']' && tmp != '[') return false;
                if (c == '}' && tmp != '{') return false;
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}


public class Solution {
    public boolean isValid(String s) {











       if (s == null || s.length() == 0) return true;
       Stack<Character> mem = new Stack<Character>();
       for (int i = 0; i < s.length(); i++){
           char q = s.charAt(i);
           if (q == '{'){
             mem.push('}');
           }
           else if (q == '('){
             mem.push(')');
           }
           else if (q == '['){
             mem.push(']');
           }
           else{
               if (mem.isEmpty()) return false;  //here it means all pairs so far have a match, but a new char (} or ] or )) comes; so here return false
               if (mem.pop() != q) return false;  //if it is left char of 3 pair, we just push into stack, if it is right char of 3 pairs, we need to check whether match the stack or not;
                   //e.g. ([{(({[?  (if ? ==  left side of pair, we keep pushing it, if ? == right side of pair, it has to be ], otherwise it is unvalid)
           }
       }
       if (mem.isEmpty()) return true; //in case has odd length of chars
       return false;
    }
}

