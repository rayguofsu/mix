215. Kth Largest Element in an Array
Total Accepted: 43339 Total Submissions: 135782 Difficulty: Medium

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.

/*Concise JAVA solution based on Quick Select

The basic idea is to use Quick Select algorithm to partition the array with pivot:

Put numbers < pivot to pivot's left
Put numbers > pivot to pivot's right

Then

if indexOfPivot == k, return A[k]
else if indexOfPivot < k, keep checking left part to pivot
else if indexOfPivot > k, keep checking right part to pivot

Time complexity = O(n)

Discard half each time: n+(n/2)+(n/4)+..+1 = n + (n-1) = O(2n-1) = O(n), because n/2+n/4+n/8+..1=n-1.

Quick Select Solution Code:
*/
//Quickselect 的平摊复杂度是 Ɵ(n)，而最坏情况下复杂度是 Ɵ(n2)，n = 元素数量
    public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return -1;
        return helper(nums, 0, nums.length - 1, k);

    }
    private int helper(int[] nums, int lo, int hi, int k){
        int left = lo;
        int last = nums[hi];
        for (int i = lo; i <= hi; i++){
            if (nums[i] > last){
                swap(nums, i, left++);
            }
        }
        swap(nums, left, hi);
        if (left == k - 1) return nums[left];
        else if (left > k - 1) {
            return helper(nums, lo, left - 1, k);
        }
        else return helper(nums, left + 1, hi, k);
    }
    void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;             
}
}


    
    
    
    
    
public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
    return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
}    

public int findKthLargest(int[] nums, int start, int end, int k) {// quick select: kth smallest
    if (start > end) return Integer.MAX_VALUE;

    int pivot = nums[end];// Take A[end] as the pivot, 
    int left = start;
    for (int i = start; i < end; i++) {
        if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
            swap(nums, left++, i);          
    }
    swap(nums, left, end);// Finally, swap A[end] with A[left]

    if (left == k)// Found kth smallest number
        return nums[left];
    else if (left < k)// Check right part
        return findKthLargest(nums, left + 1, end, k);
    else // Check left part
        return findKthLargest(nums, start, left - 1, k);
} 

void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;             
}


/*public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
        
    }
}
*/
