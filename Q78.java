78. Subsets
Total Accepted: 85211 Total Submissions: 278799 Difficulty: Medium

Given a set of distinct integers, nums, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

public class Solution {
   //similar to Q9.4 CC150
    public List<List<Integer>> subsets(int[] nums) {
        //recursion way to do it; base case and build
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
       // Arrays.sort(nums); //NO NEED TO DO THIS
        //if length > 1; then execute below
        return subsetGen(nums, nums.length - 1);
        
    }

    private List<List<Integer>> subsetGen(int[] nums, int position){
        List<List<Integer>> oldResult = new ArrayList<List<Integer>>();
        //base case here
        if (position == 0){
            List<Integer> emptyList = new ArrayList<Integer>();
            List<Integer> newList = new ArrayList<Integer>();
            newList.add(nums[0]);
            oldResult.add(emptyList);
            oldResult.add(newList);
            return oldResult;
        }

        //to build here
        oldResult = subsetGen(nums, position - 1);
        List<List<Integer>> newResult = new ArrayList<List<Integer>>(oldResult);
        //newResult.addAll(oldResult);
        for(List<Integer> oldList : oldResult){
            List<Integer> newList = new ArrayList<Integer>(oldList);
           // newList.addAll(oldList);
            newList.add(nums[position]);
            //return newReuslt
            newResult.add(newList);
        }
        return newResult;
    }

}

