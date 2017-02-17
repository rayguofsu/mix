//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//Note:
//
//    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//    The solution set must not contain duplicate triplets.
//
//    For example, given array S = {-1 0 1 2 -1 -4},
//
//    A solution set is:
//    (-1, 0, 1)
//    (-1, -1, 2)
//

Sort the array, iterate through the list, and use another two pointers to approach the target. Runtime: 7ms

public List<List<Integer>> threeSum(int[] nums) { //online faster soluion also O(n^2)









   List<List<Integer>> list = new ArrayList<List<Integer>>();
   if (nums == null || nums.length < 3) return list;
   Arrays.sort(nums);
   for (int i = 0; i < nums.length; i++){
       //the first entry of duplicates will be processed only by below line
       if (i > 0 && nums[i] == nums[i - 1]) continue; //skip same result; avoid dup
       int target = 0 - nums[i];
       int j = i + 1;
       int k = nums.length - 1;
       while (j < k){//two pointer j and k
          if (nums[j] + nums[k] == target){
             //using nums[i] as base, we found one match; so to avoid duplicate matches, the next match, using same nums[i] as base, should nums[new j] > nums[j] && nums[new k] < nums[k]; that is why we have two below while to find new j and new k
             list.add(Arrays.asList(nums[i], nums[j], nums[k]));
             while(j < k && nums[j] == nums[j+1]) j++; //j < k is incase if all duplicates, without it for all duplicates case, nums[j+1] will throw error
             while(j < k && nums[k] == nums[k-1]) k--; //skip same result
             j++;
             k--;
          }
          else if (nums[j] + nums[k] > target){
             k--;
          }
          else{
             j++;
          }
       }
   }
   return list;
}




/*public class Solution { //my solution
    //My solution is based on Two Sum solution; it is O(N^2)
    public List<List<Integer>> threeSum(int[] nums) {
        //Run time far away from Bell Shape, need to revisit this one
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
             if (i == 0 || nums[i] != nums[i-1]) {
                if (2 * nums[i + 1] <= -nums[i]){
                    twoSum(nums, result, i + 1, -nums[i]);
                }
             }
        }
        return result;
    }


    private void twoSum(int[] nums, List<List<Integer>> threeEntry, int start, int target) {//it is O(N)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //has to be here; otherwise, it will match to wrong value
        map.put(target - nums[start], start);
        for (int i = start + 1; i < nums.length; i++){
                //if (nums[i] * 2 <= target){
                List<Integer> newList = new ArrayList<Integer>();
                if (map.get(nums[i]) != null){
                    newList.add(nums[map.get(nums[i])]);
                    newList.add(nums[i]);
                    newList.add(0, -target);
                    if (!threeEntry.contains(newList)){ //O(1)
                        threeEntry.add(newList);
                    }
                }
                //}
                map.put(target - nums[i], i);
                
        }
    }
}
*/
