//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//
//Do not allocate extra space for another array, you must do this in place with constant memory.
//
//For example,
//Given input array nums = [1,1,2],
//
//Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length. 
//
import java.util.Arrays;
public class Q26{
   //this is much easier; and the question assume it is sorted
    public int removeDuplicates(int[] nums) {






















        if (nums == null) return 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[j]){
                nums[++j] = nums[i];
            }
        }
        
        return j + 1;
    }

}


   // if(nums == null) return 0;
   // if(nums.length<2) return nums.length;
   // int m = nums[0] == nums[1] ? 0 : 1;
   // for(int i = m; i < nums.length - 1; i++){
   //     if(nums[i] != nums[i + 1]){
   //         nums[++m] = nums[i + 1];
   //     }
   // }
   // return m + 1;

    /*method 1 //quite similar to "remove element" and "remove zeros"
    public static int removeDuplicates(int[] nums) {
       //have to sort it first; otherwise the duplicate item may reside both left and 
       //right when tranverse through array
       if (nums == null) return 0;
       Arrays.sort(nums);
       int dupSum = 0;
       int variable = nums[0];
       for (int i = 1; i < nums.length; i++){
          if (nums[i] == variable){
             dupSum += 1;
          }
          else{ // != variable
             nums[i - dupSum] = nums[i];
             //update variable
             variable = nums[i];
          }
       }
       return nums.length - dupSum;
    }
    */

    public static void main(String[] args){
      int[] nums= {1, 2, 5, 5, 6, 6, 5, 5, 2, 9};
      System.out.println("total non-duplicates are " + removeDuplicates(nums));
      System.out.println("after processing, they are now : " + Arrays.toString(nums));
    }
}
