229. Majority Element II
Total Accepted: 20609 Total Submissions: 83033 Difficulty: Medium

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //searching for linear time majority vote
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return result;
        int num1 = nums[0];
        int count1 = 0;
        int num2 = nums[0];
        int count2 = 0;
        for (int i = 0; i < nums.length; i++){
           if (nums[i] == num1) count1++;
           else if (nums[i] == num2) count2++;
           else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
           }
           else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
           }
           else{
               count1--;
               count2--;
           }
        }
        //second round to make sure whether there really exists such >n/3 times number
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++){
           if (nums[i] == num1) count1++;
           else if (nums[i] == num2) count2++;
        }
        if (count1 > nums.length/3) result.add(num1);
        if (count2 > nums.length/3) result.add(num2);
        return result;
    }
}




















public List<Integer> majorityElement(int[] nums) {
    if (nums == null || nums.length == 0)
        return new ArrayList<Integer>();
    List<Integer> result = new ArrayList<Integer>();
    int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
    for (int i = 0; i < len; i++) {
        if (nums[i] == number1)
            count1++;
        else if (nums[i] == number2)
            count2++;
        else if (count1 == 0) {
            number1 = nums[i];
            count1 = 1;
        } else if (count2 == 0) {
            number2 = nums[i];
            count2 = 1;
        } else {
            count1--;
            count2--;
        }
    }
    count1 = 0;
    count2 = 0;
    for (int i = 0; i < len; i++) {
        if (nums[i] == number1)
            count1++;
        else if (nums[i] == number2)
            count2++;
    }
    if (count1 > len / 3)
        result.add(number1);
    if (count2 > len / 3)
        result.add(number2);
    return result;
}

nums i is 2 number1 is 2 by 1
            number2 is 2 by 0
nums i is 2 number1 is 2 by 2
            number2 is 2 by 0
nums i is 0 number1 is 2 by 2
            number2 is 0 by 1
nums i is 0 number1 is 2 by 2
            number2 is 0 by 2
nums i is 1 number1 is 2 by 1
            number2 is 0 by 1
nums i is 1 number1 is 2 by 0
            number2 is 0 by 0
nums i is 4 number1 is 4 by 1
            number2 is 0 by 0
nums i is 1 number1 is 4 by 1
            number2 is 1 by 1
nums i is 0 number1 is 4 by 0
            number2 is 1 by 0



nums i is 2 number1 is 2 by 1
            number2 is 2 by 0
nums i is 2 number1 is 2 by 2
            number2 is 2 by 0
nums i is 0 number1 is 2 by 2
            number2 is 0 by 1
nums i is 0 number1 is 2 by 2
            number2 is 0 by 2
nums i is 1 number1 is 2 by 1
            number2 is 0 by 1
nums i is 1 number1 is 2 by 0
            number2 is 0 by 0
nums i is 1 number1 is 1 by 1
            number2 is 0 by 0
nums i is 0 number1 is 1 by 1
            number2 is 0 by 1
