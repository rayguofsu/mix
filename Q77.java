77. Combinations
Total Accepted: 67388 Total Submissions: 202210 Difficulty: Medium

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
//WRONG WRONG//
/*public class Solution {  //Wrong ANSWERr; has duplicates;
//using base case and build approach since asked for "all ways"

    //this same solution is applied to earlier problem in all permutations

    //the idea is to recurse to the base case where n == k;
    //now recurse back to select k elements out of k+1 elements by just replacing each element of the k elements with val of k+1 to gen k new list<integer> for each list in the previous recursion result
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) return null;
        return combineR(n, k);
    }

    public List<List<Integer>> combineR(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //base case below
        if (n == k){
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++){
                list.add(i);
            }
            result.add(list);
            return result;
        }
        //build it here

        //result = combineR(n - 1, k);ConcurrentModificationException
        //CANNOT iterate a list while updating it
        List<List<Integer>> oldResult = combineR(n - 1, k);
        result.addAll(oldResult);
        for (List<Integer> oldList: oldResult){
            for (int i = 0; i < oldList.size(); i++){
                List<Integer> newList = replaceList(oldList, i, n);
                result.add(newList);
            }
        }
        return result;
    }

    public List<Integer> replaceList(List<Integer> list, int position, int val){
        List<Integer> newList = new ArrayList<Integer>(list);//shallow copy
        newList.set(position, val);//replace it to gen new list
        return newList;
    }
}
*/
public class Solution { //recursion
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combR(res, list, n, k, 1);
        return res;
    }
    private void combR(List<List<Integer>> res,  List<Integer> list, int n, int k, int start){
        if (list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++){
            list.add(i);
            combR(res, list, n, k, i+1);
            list.remove(list.size()-1);
        }
    }
}
public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k){
        List<Integer> list = new ArrayList<Integer>();
        genComb(1, n, list, k);
        return result;
    }
    public void genComb(int start, int end, List<Integer> list, int c){
        //base case
        if (c == 0){
            result.add(list);
            return;
        }
        //if (end - start < c) return ///this is unnecessary
        for (int i =  start; i <= end; i++){
            List<Integer> newList = new ArrayList<Integer>(list); //to create a shallow copy here
            newList.add(i);//in the for loop, it adds i for current; for next, it adds i+1; but i is not in next, so no duplicates
            genComb(i + 1, end, newList, c - 1); //c - 1 is the counter to show how many more need to be add
        }
    }
}


