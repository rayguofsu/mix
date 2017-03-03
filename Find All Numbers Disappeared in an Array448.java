Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]


/*The idea is to take element at index i and replace it with element at index A[i] until we get i equal to A[i] - 1 . We iterate this logic over each element of the Array beginning from first element. After this iteration each element at index i will have i + 1 as it's value and those element that are not in this array will have value other than i + 1.*/
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(i+1 == nums[i])
                continue;
                
            int x = nums[i];
            int y = nums[x-1];
            
            while(x != y){
                nums[x - 1] = x;
                nums[i] = y;
                x = nums[i];
                y = nums[x - 1];
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i + 1){
                result.add(i+1);
            }
        }
        return result;
    }
}


/*another 
The basic idea is that we iterate through the input array and mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1]. In this way all the numbers that we have seen will be marked as negative. In the second iteration, if a value is not marked as negative, it implies we have never seen that index before, so just add it to the return list.

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }

*/
