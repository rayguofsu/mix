241. Different Ways to Add Parentheses
Total Accepted: 16897 Total Submissions: 51402 Difficulty: Medium

Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1

Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2

Output: [0, 2]

Example 2

Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10

Output: [-34, -14, -10, -10, 10]

public class Solution {//this is a good variant of recursion base case and build approach
    public List<Integer> diffWaysToCompute(String input) {








        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++){
            char s = input.charAt(i);
            if (s == '+' || s == '-' || s == '*'){
                List<Integer> resLeft = diffWaysToCompute(input.substring(0, i));
                List<Integer> resRight = diffWaysToCompute(input.substring(i+1));
                for (Integer left : resLeft){
                  for (Integer right: resRight){//to understand it, just use 2+5*2 example to figure out
                    switch (s){//here idea is to bracket the left and right and do the "s" operation on them;
                        case '+': res.add(left + right); break; //break will break on the swich I guess
                        case '-': res.add(left -right); break;
                        case '*': res.add(left*right); break;
                    }
                  }
                }
            }
        }
        if (res.size() == 0) {  //base case
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
