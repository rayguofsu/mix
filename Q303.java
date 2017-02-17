//Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//
//Example:
//
//Given nums = [-2, 0, 3, -5, 2, -1]
//
//sumRange(0, 2) -> 1
//sumRange(2, 5) -> -1
//sumRange(0, 5) -> -3
//
//Note:
//
//    You may assume that the array does not change.
//    There are many calls to sumRange function.
//

        //using haspMap could be expensive here, can just use int[] to store the sum only; see better solution below commented//

public class NumArray {
    



    
    private int[] table;
    public NumArray(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        table = new int[nums.length+1]; //table[nums.length] = 0;
        for (int i = 0; i < nums.length; i++){
            table[i] = sum;
            sum -= nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return table[i] - table[j+1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);








    private HashMap<Integer, Integer> map;
//    private int[] array;
    public NumArray(int[] nums) {
        map = new HashMap<Integer, Integer>();
 //       array = new int[nums.length];
 //       System.arraycopy(nums, 0, array, 0, nums.length);

        int sum = 0;
        for (int i: nums){
           sum += i;
        }
        for (int i = 0; i < nums.length; i++){
           map.put(i, sum);
           sum -= nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (!map.containsKey(i) || !map.containsKey(j)){
           return 0;
        }
        else{
           if (map.containsKey(j + 1)){
              return map.get(i) - map.get(j+1);
           }
           else{
              return map.get(i);
           }
        }
    }
/* better solution
    int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length];
        if(nums.length>0)sum[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            sum[i]=sum[i-1]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i==0)return sum[j];
        return sum[j]-sum[i-1];
    }
*/


}


//int[] src  = new int[]{1,2,3,4,5};
//int[] dest = new int[5];

//System.arraycopy( src, 0, dest, 0, src.length );


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
