330. Patching Array
Total Accepted: 301 Total Submissions: 1209 Difficulty: Medium

Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.

Example 1:
nums = [1, 3], n = 6
Return 1.

Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

Example 2:
nums = [1, 5, 10], n = 20
Return 2.
The two patches can be [2, 4].

Example 3:
nums = [1, 2, 2], n = 5
Return 0.

public class Solution {
public int minPatches(int[] nums, int n) {  //Greedy
     long max = 1;  //max represent so far the sum range is [0, max)
     int cnt = 0;  //if max <= n, then it is better to add max as an element so the new range 
     int i = 0;    //can be [0, max) combined with [max, max+max), i.e. [0, 2max) to 
                  //make sure no gap in between, if adding one larger element > max
                  //instead of adding max; then will have gap
     while (max <= n){
        //if (nums[i] <= max){
        if (i < nums.length && nums[i] <= max){
            max = max + nums[i];
            i++;
        }
        //else if (nums[i] > max){
        else {//if (i >= nums.length || nums[i] > max){
            max += max;
            cnt++;
        }
     }
     return cnt;
}
}
/*
Solution

int minPatches(vector<int>& nums, int n) {
    long miss = 1, added = 0, i = 0;
    while (miss <= n) {
        if (i < nums.size() && nums[i] <= miss) {
            miss += nums[i++];
        } else {
            miss += miss;
            added++;
        }
    }
    return added;
}

Explanation

Let miss be the smallest sum in [0,n] that we might be missing. Meaning we already know we can build all sums in [0,miss). Then if we have a number num <= miss in the given array, we can add it to those smaller sums to build all sums in [0,miss+num). If we do not, then we must add such a number to the array, and it's best to add miss itself, to maximize the reach.

Example: Let's say the input is nums = [1, 2, 4, 13, 43] and n = 100. We need to ensure that all sums in the range [1,100] are possible.

Using the given numbers 1, 2 and 4, we can already build all sums from 0 to 7, i.e., the range [0,8). But we can't build the sum 8, and the next given number (13) is too large. So we insert 8 into the array. Then we can build all sums in [0,16).

Do we need to insert 16 into the array? No! We can already build the sum 3, and adding the given 13 gives us sum 16. We can also add the 13 to the other sums, extending our range to [0,29).

And so on. The given 43 is too large to help with sum 29, so we must insert 29 into our array. This extends our range to [0,58). But then the 43 becomes useful and expands our range to [0,101). At which point we're done.

Another implementation, though I prefer the above one.

int minPatches(vector<int>& nums, int n) {
    int count = 0, i = 0;
    for (long miss=1; miss <= n; count++)
        miss += (i < nums.size() && nums[i] <= miss) ? nums[i++] : miss;
    return count - i;
}


*/
