//
//Combination Sum III
//Total Accepted: 18588 Total Submissions: 58227 Difficulty: Medium
//
//Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
//Ensure that numbers within the set are sorted in ascending order.
//
//Example 1:
//
//Input: k = 3, n = 7
//
//Output:
//
//[[1,2,4]]
//
//
//Example 2:
//
//Input: k = 3, n = 9
//
//Output:
//
//[[1,2,6], [1,3,5], [2,3,4]]
//
//
//
//
//
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combR(res, k, n, list, 1);
        return res;
    }
    private void combR(List<List<Integer>> res , int k, int remainSum, List<Integer> list, int start){
        if (remainSum < 0 || k <0) return;
        if (remainSum == 0){
            if (k == 0)
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++){
            list.add(i);
            combR(res, k-1, remainSum-i, list, i+1);
            list.remove(list.size()-1);
        }
        
    }
}





/*public class Solution {//this solution is not space efficient
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<Integer>();
        if (k > n) return result;
        genComb(1, n, k, list);
        return result;
    }

    private void genComb(int start, int residueSum, int c, List<Integer> list){
       //terminate case, when count c = 0; need to add to result now
       if (c == 0){
          if (residueSum == 0){
             result.add(list);
          }
          return;
       }
       if (list.isEmpty() || (residueSum > list.get(list.size() - 1))){ //this can save time //differece ==null??
          for (int i = start; i <= 9; i++){
             List<Integer> newList = new ArrayList<Integer>(list);
             newList.add(i);
             genComb(i + 1, residueSum - i, c - 1, newList);
          }
       }
    }
}
*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k > n) return res;
        List<Integer> list = new ArrayList<Integer>();
        genCombR(res, list, k, n);
        return res;
    }
    private void genCombR(List<List<Integer>> res, List<Integer> list, int k, int remainSum){
        if (k == 0){
            if (remainSum == 0){
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        //last entry//
        boolean empty = list.isEmpty();
        if (empty || remainSum > list.get(list.size() - 1)){
           // System.out.println("yes");
            int start = empty ? 1 : (1+ list.get(list.size() - 1));
            for (int i = start; i <= 9; i++){
                list.add(i);
                genCombR(res, list, k-1, remainSum - i);
                list.remove(list.size() - 1);
            }
        }
    }
}





public class Solution {//this solution is space efficient
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {










        List<Integer> list = new ArrayList<Integer>();
        if (list == null) System.out.println("yes null");
        if (list.isEmpty()) System.out.println("yes empty");
        if (k > n) return result;
        genComb(1, n, k, list);
        return result;
    }

    private void genComb(int start, int residueSum, int c, List<Integer> list){
       //terminate case, when count c = 0; need to add to result now
       if (c == 0){
          if (residueSum == 0){
             List<Integer> newList = new ArrayList<Integer>(list);
             result.add(newList);
          }
          return;
       }
       if (list.isEmpty() || (residueSum > list.get(list.size() - 1))){ //this can save time; should not use == null here
          for (int i = start; i <= 9; i++){
             list.add(i);   //this is space efficient 
             genComb(i + 1, residueSum - i, c - 1, list);
             list.remove(list.size() - 1);   //this is space efficient, here it will remove the just added i;
             //it is called backtracking?
          }
       }
    }
}
