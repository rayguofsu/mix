// Given an array of integers, every element appears three times except for one. Find that single one.
//
//Note:
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 

public class Solution {
    //idea is to count the number of 1-bit on each binary reprentation of each number of entire array
    //then if any bit in the count is 3 times, just clear it back to zero; at the end, the count is to be returned
   //implementation: use ones to keep bits with one time one
   //use twos to keep bits with twice one
   //imagine, twos are like carry; when twos has an one on some bit; and ones has also one on the same bit; then it means this bit already have one 3 times; so clear ones and twos on this bit//

    public int singleNumber(int[] nums) {
       int ones = 0;
       int twos = 0;
       int threes = 0;
       for (int i = 0; i < nums.length; i++){
          twos = twos | (nums[i] & ones);  //like carry (but on the same bit as sum), needs to be before updating ones because when one occurs twice on the same bit, ones will have zero on that bit, but twos will have an one on that same bit
          ones = ones ^ nums[i]; //like sum; here does not need = ones | (ones ^ nums[i])
          threes = twos & ones;

          //to clear all 3-time one-bit
          twos = (~threes) & twos;
          ones = (~threes) & ones;
          threes = 0;
       }
       return ones;
    }
}
If we know on which bits '1' occurs twice, and also know on which bits '1' occurs 1-time, a simple '&' operation would result in the bit where '1' occurs three times. Then we turn these bit to zero, would do well for this problem.

(1). Check bits which have 1-time '1', use the XOR operation.
(2). Check bits which have 2-times '1's, use current 1-time result & current number.
(3). Check bits which have 3-times '1's, use '1-time' result & '2-times' result
(4). To turn 3-times bits into 0:   ~(3-times result) & 1-time result
                                                     ~(3-times result) & 2-times result
   
E.g.,We have numbers:  101101,   001100, 101010
To count the occurrence of 1's:
101101
001100
101010
count:  {2,0,3,2,1,1}


Denote:
t1: bit=1 if current bit has 1-time '1'
t2: bit=1 if current bit has 2-times '1'
t3: bit=1 if current bit has 3-times '1'

Result:
t1 = 000011, t2 = 100100, t3 = 001000



Initialization: t1 = 000000, t2=000000, t3 = 000000
(1) 101101
t1 = 101101  (using XOR)
t2 = 000000
t3 = 000000

(2)001100
% Current 2 times bits (t2) and NEW 2 times bits coming from 1 time bits and new number.
t2 = t2 | 001100 & t1 =  001100 & 101101 = 001100
t1 = t1 XOR 001100 = 100001
t3 = t2 & t1 = 000000

(3)101010
t2 = t2 | (101010 & t1) = t2 | (101010 & 100001) = 101100  //this is like the carry bit vectors;
t1 = t1 XOR 101010 = 100001 XOR 101010 = 001011
//this is the sum

//when twice, then sum = 0; carry = 1; when 3 times, then sum = 1 and carry =  1; now
//t3 will be one.
t3 = t1 & t2 = 001000

%Turn 3-time bits into zeros
t1 = t1 & ~t3 = 000011
t2 = t2 & ~t3 = 100100


