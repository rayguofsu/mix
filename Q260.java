// Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
//
//For example:
//
//Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
//
//Note:
//
//    The order of the result is not important. So in the above example, [5, 3] is also correct.
//    Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
//
public class Solution {
    /*
       public class Solution {
        public int[] singleNumber(int[] nums) {
            HashSet h=new HashSet();
            int[] res=new int[2];
            for(int i=0; i<nums.length; i++){
                if(!h.add(nums[i])) h.remove(nums[i]);
            }
            int c=0;
            Iterator i=h.iterator();
            while(i.hasNext()){
                res[c]=(int)i.next();
                c++;
            }
            return res;
        }
    }
    */
    public int[] singleNumber(int[] nums) {
       int num = 0;
       for (int i = 0; i < nums.length; i++){
          num ^= nums[i];
       } //num will be the XOR result of the two numbers
       
       int mask = num & ~(num - 1);  //here mask will only have one bit set (one bit set means only has one 1 bit; all other bits are 0)  //actually, only the last one bit set of num is kept in mask //in other words, num cannot be all zeros; it has to have at least a '1' bit; then mask will be the last '1' bit and all rest bits are zeros
       int[] result = new int[2];
       for (int i = 0; i < nums.length; i++){
           //now group the array into 2 groups, each group has all duplicates plus one non-duplicate
          if ((mask & nums[i]) == 0){  //priority == higher than &
             result[0] ^= nums[i]; //result[0] will be the one non-duplicate; as duplicate ones will not be split into two groups
          }
          else{
             result[1] ^= nums[i];  //result[1] will be the other non-duplicate
          }
       }
       return result;
    }
}
