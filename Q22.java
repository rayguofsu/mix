// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//For example, given n = 3, a solution set is:
//
//"((()))", "(()())", "(())()", "()(())", "()()()" 
//
//
//
//
//
//



public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateR(n, n, "", list);
        return list;
    }
    private void generateR(int left, int right, String res, List<String> list){
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {list.add(res); return;}
        //left >= 0 below
        generateR(left-1, right, res+"(", list);
        if (right > left) generateR(left, right-1, res+")", list);
    }
}





public class Solution {
    //cc150 original Question
    //for original solution 1: we need to use below convert hashset to list
    //Set<String> listOfTopicAuthors = ....
    //List<String> list = new ArrayList<String>(listOfTopicAuthors);
    public List<String> generateParenthesis(int n) {












       List<String> result = new ArrayList<String>();
       char[] str = new char[2*n];
       addPattern(result, n, n, str, 0);
       return result;
    }
    private void addPattern(List<String> result, int leftRem, int rightRem, char[] str, int count){
       //count used as index, can use it to overwrite existing character
      //this line is an extra if (leftRem > rightRem) return; //invalid, so return
       if (leftRem == 0 && rightRem == 0){ //here all has been in char[] str
          result.add(String.copyValueOf(str));  //char[] to string
          return;
       }
       else{
          if (leftRem > 0){//as long as it > 0, we can always insert it
             str[count] = '(';
             addPattern(result, leftRem - 1, rightRem, str, count + 1);
          }
          if (rightRem > leftRem){ //if rightRem > leftRem, we can insert ')'
             str[count] = ')';
             addPattern(result, leftRem, rightRem - 1, str, count + 1);
          }
      }
   }
}




