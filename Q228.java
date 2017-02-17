//Given a sorted integer array without duplicates, return the summary of its ranges.
//
//For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"]. 

Input: 
int i = 5; 
Output:
char c = '5'

This has been already answered above, however if the integer value i  > 10, then need to use char array.

char[] c = String.valueOf(i).toCharArray();

int a = 1
char b = Integer.toString(a).charAt(0);

public class Solution {
    //idea is to use one for loop; but two ajacent index to determine whether single or sequence
    // very important for adding string to arraylist; has to have extra of ""
    //(guess) unless there is other string added, like "->"
    public List<String> summaryRanges(int[] nums) {










        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0){
           return result;
        }
	int start = nums[0];
        if (nums.length == 1) result.add(start + "");
        for (int i = 1; i < nums.length; i++){
           if (nums[i] - nums[i - 1] != 1){  //disconnected here
              //two cases below
              if (nums[i - 1] == start){ //single case
                 result.add(nums[i - 1] + "");
              }
              else{ //sequence case
                 result.add(start + "->" + nums[i - 1]);
              }
              start = nums[i];//new start
           }
           if (i == nums.length - 1){  //last element has to be handled separately
              //still two cases for last element
              if (start == nums[i]){ //disconnected; single case
                 result.add(nums[i] + "");
              }
              else{//sequence case
                 result.add(start + "->" + nums[i]);
              }
           }
        }
        return result;
    }
}
