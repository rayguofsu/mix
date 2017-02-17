// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//Each number in C may only be used once in the combination.
//
//Note:
//
//    All numbers (including target) will be positive integers.
//    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//    The solution set must not contain duplicate combinations.
//
//For example, given candidate set 10,1,2,7,6,1,5 and target 8,
//A solution set is:
//[1, 7]
//[1, 2, 5]
//[2, 6]
//[1, 1, 6]
//
//

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target < 1) return res;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        combRBec(candidates, target, res, list, 0);
        return res;
    }
    private void combRBec(int[] candidates, int sum, List<List<Integer>> res, List<Integer> list, int start){
        if (sum < 0) return;
        if (sum == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++){
            if (i != start && candidates[i] == candidates[i-1]) continue; //this is different from i>0 && ==
            //it should be i != start here to avoid dup
            list.add(candidates[i]);
            combRBec(candidates, sum-candidates[i], res, list, i+1);
            list.remove(list.size()-1);
        }
    }
}



public class Solution {
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> rst = new ArrayList<>();
    if( candidates == null || candidates.length == 0){
        return rst;
    }
    Arrays.sort(candidates);
    helper(rst, new ArrayList<>(), 0, candidates, target,0);
    return rst;
}
//DFS
public void helper(List<List<Integer>> rst, List<Integer> path, int sum, int[] candidates, int target, int pos){//DFS
    if(sum == target){
        rst.add(new ArrayList<>(path)); //shallow copy; has to have arrayList<>
        return;
    }
    for(int i=pos; i<candidates.length; i++){
        if(sum + candidates[i] > target) break;
        if( i != pos && candidates[i] == candidates[i-1]) continue; //avoid duplicates ; remember it!
        path.add(candidates[i]);                                         //these three lines are so typical for backtracking
        helper(rst, path, sum+candidates[i],candidates,target, i+1);     //these three lines are so typical for backtracking
        path.remove(path.size()-1);                                      //this is for deleting the entry added by first line of the 3 lines
    }
}
}


