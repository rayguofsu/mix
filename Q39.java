// Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//The same repeated number may be chosen from C unlimited number of times.
//
//Note:
//
//    All numbers (including target) will be positive integers.
//    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//    The solution set must not contain duplicate combinations.
//
//For example, given candidate set 2,3,6,7 and target 7,
//A solution set is:
//[7]
//[2, 2, 3]

/*public class Solution { //2nd solution is better
    public List<List<Integer>> combinationSum(int[] candidates, int target) {//just realize that for leetcode, it is not perfect
    //[1, 1] 2, answer gives duplicate lists, which are not allowed.
    //Idea is simple; just sort it first, then for each mupltiple of current entry, just recurse it starting from next entry.
        System.out.println("I solved this Question by myself");
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       if (candidates == null || candidates.length == 0) return result;
       Arrays.sort(candidates); //need to sort it; as required non-descending list
       List<Integer> list = new ArrayList<Integer>();
       generateSum(candidates, target, 0, result, list);
       return result;
    }
    private void generateSum(int[] nums, int target, int start, List<List<Integer>> result, List<Integer> list){
       for (int i = start; i < nums.length; i++){
           if (i > 0 && nums[i] == nums[i - 1]) continue; //this is the standard way to avoid duplicate list as in other problem
           //only the first entry in sequence of duplicate entries will be processed
           int multiple = target / nums[i]; //all numbers postive
           for (int j = 1; j <= multiple; j++){
              int count = j;
              List<Integer> newList = new ArrayList<Integer>(list);//shallow copy it as this is the right place to do as below while will modify the newList
              while(count > 0){
                 newList.add(nums[i]);
                 count--;
              }
              int newTarget = target - nums[i] * j;
              if (newTarget == 0){
                  result.add(newList);
                  break;
              }
              else if (newTarget > nums[i]){ //cannot include == here; even if put == here, the next geneareSum will bypass duplicates due to continue sentence; then break for each larger entry; == condition is covered by the next j in the current for loop
                  int newStart = i + 1;
                  generateSum(nums, newTarget, newStart, result, newList);
              }
              //else if (newTarget == nums[i]) continue;
              else if (newTarget < nums[i]){
                 break;
              }
           }
       }
   }
}
*/


public class Solution {
//(same idea with Combinations)
public List<List<Integer>> combinationSum(int[] candidates, int target) {











    Arrays.sort(candidates);
    List<List<Integer>> ans = new LinkedList<>();
    List<Integer> mid = new LinkedList<>();
    helper(candidates, target, ans, mid, 0);
    return ans;
}

private void helper(int[] candidates, int target, List<List<Integer>> ans, List<Integer> mid, int start) {
    if(target < 0) return;
    if(target == 0) {
        ans.add(new LinkedList<>(mid));
        return;
    }

    for(int i = start ; i < candidates.length ; i++) {
        if (i > 0 && candidates[i] == candidates[i-1]) continue;//typical way of avoiding duplicates
        mid.add(candidates[i]);
        helper(candidates, target-candidates[i], ans, mid, i); //you do not need to give i+1 here; by using i, it will give multiple of same entry which is what we want;
        mid.remove(mid.size()-1); //typical way of backtracking
    }
}
}


