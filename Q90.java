// Given a collection of integers that might contain duplicates, nums, return all possible subsets.
//
//Note:
//
//    Elements in a subset must be in non-descending order.
//    The solution set must not contain duplicate subsets.
//
//For example,
//If nums = [1,2,2], a solution is:
//
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]

/*
1  2  2  3
.  .  .  .
 \ .  .  .
    \ .  .
       \ .

*/
//[[],[1],[1,2],[1,2,2],[1,2,2,3],[1,2,3],[1,3],[2],[2,2],[2,2,3],[2,3],[3]]
//this p is complicated; Chris could not solve the 2nd time;
//use the above fig idea; but needs to take a look at photo in phone
//if doing it naively to see whether results contains the new list before adding it to result
//, it could be O(n^2*(2^n)).

public class Solution {
    int justRmvd = Integer.MIN_VALUE; //using external flag to control is smart; otherwise cannot return value 
    //with both list and int in it except using a data structure class
    boolean justRMValid = false;  //only used to avoid first entry = MIN_VALUE case

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList();

        if(nums.length>0) {
            Arrays.sort(nums); //as non-descending order in subset
            helper(nums, 0, new ArrayList<Integer>(), results);
        }
        return results;
    }

    void helper(int[] nums, int index, List<Integer> path, List<List<Integer>> results) {
        //generalized backtracking solution
        results.add(new ArrayList<Integer>(path)); //shallow copy
        for(int i=index; i<nums.length; i++) {
            //when justRmvd equals nums[i] it means previous entry (which is justRmvd) equals current num[i]
            // however with previous entry, it has already generated all subsets with previous entry in it; 
            //no need to remove previous entry and add current entry and generate again, as pre and current are equal.
            if(justRMValid && justRmvd==nums[i]) continue;
            path.add(nums[i]);
            helper(nums, i+1, path, results);
            //here it will indeed remove the added num[i] even after so many recursions
            justRmvd = path.remove(path.size()-1);
            justRMValid = true;
        }
    }
}

