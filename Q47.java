47. Permutations II
Total Accepted: 60064 Total Submissions: 221621 Difficulty: Medium

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1]. 

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //idea is same as permutation; but adding set here only to ensure unique
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
       if (nums == null || nums.length == 0) return null;
       return permuteR(nums, nums.length -1);
    } 

    private List<List<Integer>> permuteR(int[] nums, int c){
        List<List<Integer>> res = new ArrayList<>();
       //base
       if (c == 0){
         List<Integer> list = new ArrayList<Integer>();
         list.add(nums[c]);
         res.add(list);
         return res;
       }
       //recurse
       List<List<Integer>> prev = permuteR(nums, c - 1);
       //build
       
       Set<String> set = new HashSet<String>();
       for (List<Integer> list : prev){
          for (int i = 0; i <= list.size(); i++){
              List<Integer> newList = new ArrayList<Integer>(list);
              newList.add(i, nums[c]);
              if (set.add(String.valueOf(newList))){
                 res.add(newList);
              }
          }
       }
       return res;
    }
}
