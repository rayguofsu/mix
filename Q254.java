 254. Factor Combinations 

Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.

Write a function that takes an integer n and return all possible combinations of its factors.

Note:

    You may assume that n is always positive.
    Factors should be greater than 1 and less than n.

Examples:
input: 1
output:

[]

input: 37
output:

[]

input: 12
output:

[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]

input: 32
output:

[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getFactorR(2, n, res, list);
        return res;
    }
    private void getFactorR(int start, int n, List<List<Integer>> res, List<Integer> list){
     //   if (n==1 && list.size() > 1){
      //      res.add(new ArrayList<Integer>(list));//it is wrong if using new List<Integer>(list);
        //    return;
    //    }
        for (int i = start; i*i <= n; i++){//below if is used to avoid duplicate, 2, 2, 3, 3, and 2, 3, 2, 2
            if (n % i == 0 && n/i >= i){ // The previous factor is no bigger than the next && the recursion is start from i; so i>=i; can use input 36 to see what's going on.
                list.add(i);
                list.add(n/i);
                res.add(new ArrayList<Integer>(list));//it is wrong if using new List<Integer>(list);
                list.remove(list.size()-1);
                
                getFactorR(i, n/i, res, list);
                list.remove(list.size()-1);
            }
        }
    }
    
    
   /* public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(n <= 3)  return ret;
        List<Integer> path = new LinkedList<Integer>();
        getFactors(2, n, path, ret);
        return ret;
    }
    //BACKTRACKING can be done as below also.i.e. no clear base case
    private void getFactors(int start, int n, List<Integer> path, List<List<Integer>> ret){
       for(int i = start; i <= Math.sqrt(n); i++){
           if(n % i == 0 && n/i >= i){  // The previous factor is no bigger than the next
               path.add(i);
               path.add(n/i);
               ret.add(new LinkedList<Integer>(path));
               path.remove(path.size() - 1);
               getFactors(i, n/i, path, ret);
               path.remove(path.size() - 1);
           }
       }
    }
    */

}
