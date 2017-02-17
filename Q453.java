453. Minimum Moves to Equal Array Elements
Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
public class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < min) min = nums[i];
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i] - min;
        }
        return sum;
    }
}
//say 1, 2, 5; then 1+1= 2, 2, 5+1 = 6; so 2, 2, 6(to update this, 6-2 = 5 - 1; ie.difference is the same), then just add 4 that is all
