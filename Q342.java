342. Power of Four

 Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion? 


public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        if (num == (num & -num)){//this is to check only one bit == 1 in num; as 2's complement
            return num == (num & 0x55555555); //this there is one 1 only, now check if this one 1 if exit on bit 0 or 3 or 5..
        }    
        return false;


    }

}
