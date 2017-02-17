384. Shuffle an Array
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();

public class Solution {
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null) return null;
        int[] a = nums.clone();
        for (int i = 1; i < a.length; i++){
            int index = random.nextInt(i+1);
            swap(a, index, i);
        }
        return a;
    }
    
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    /*For the 0th element, the probability for that it stays at index 0 position, is (2-1)/2 * (3-1)/3 * 3/4... (n-1)/n = 1/n. The probability for that it will stay at index 1 is 1/2 * (3-1)/3 * ... = 1/n. This means for the 0th element, it has 1/n probability to be placed into any position.

Once we know that 0th element will stay at index x, for simplicity, we know that 0th element will stay at index 0, then what is the probability of 1st element to stay 1st position? it is 1/2 * 2/3(2/3 comes from 3/4 for 0 position by numberitor and denomenator -1 both;) * ... *(n-2)/(n-1) = 1/(n-1). This implies that for the 1st element, it has 1/(n-1) probability to be placed into any un-occupied position; so 1/(n-1) * (n-1)/n = 1/n*/
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
