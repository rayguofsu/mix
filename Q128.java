128. Longest Consecutive Sequence

 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity. 

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){//O(N)
            int down = nums[i]-1;//every time down falls at not existed
            int up = nums[i]+1; //every time up goes at not existed;
            //so up-down-1 is the total we can expand by nums[i] 
            while(set.contains(down)){
                set.remove(down);
                down--;
            }
            while(set.contains(up)){
                set.remove(up); //to make O(N)
                up++;
            }
            set.remove(nums[i]); //to make O(N)
            max = Math.max(up-down-1, max);
        }
        return max==Integer.MIN_VALUE ? 1 : max;
    }
}
