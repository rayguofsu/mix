18. 4Sum
Total Accepted: 67050 Total Submissions: 285783 Difficulty: Medium

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
    The solution set must not contain duplicate quadruplets.

    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)




public class Solution {
 public List<List<Integer>> fourSum(int[] nums, int target) {
















     //idea is from 3sum
   List<List<Integer>> list = new ArrayList<List<Integer>>();
   if (nums == null || nums.length < 4) return list;
   Arrays.sort(nums);
   for (int i = 0; i < nums.length - 3; i++){
       //the first entry of duplicates will be processed only by below line
       if (i > 0 && nums[i] == nums[i - 1]) continue; //skip same result; 
       for (int j = i+1; j < nums.length - 2; j++){
           if (j > i+1 && nums[j] == nums[j-1]) continue; //tricky here; skip same result; the first entry of the duplicates will be processed
           int newTarget = target - nums[i] - nums[j];
           int m = j+1;
           int n = nums.length - 1;
           while(m < n){
               int sum = nums[m] + nums[n];
               if (sum == newTarget) {
                   list.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                   //since you get the result here; now skip all possible duplicate results
                   while (m < n && nums[m] == nums[m+1]) m++;
                   while (m < n && nums[n] == nums[n-1]) n--;
                   n--;
                   m++;
               }
               else if (sum > newTarget){
                   n--;
               } 
               else{//sum < 
                   m++;
               }
           }
       }
   }
   return list;
}
}
