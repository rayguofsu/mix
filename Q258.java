// Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
//
//For example:
//
//Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
//
//Follow up:
//Could you do it without any loop/recursion in O(1) runtime? 


Using digtial root method: return 1+(n-1)%9





public class Solution {
   public int addDigits(int n){
      int sum = n;
      while (sum >= 10){
          int scaler = roundDn(sum); //if sum =595; then roundDN will be 100
          int sumReg = sum;  //this keeps a copy of sum; as sum will be edited
          //after each iteration; sum will be cleared to zero; 
          //then sum will calculate the newSum from the new digit in sumReg
          sum = 0;
          while (scaler > 0){
             //sum is accumulating from MSB
             sum += sumReg / scaler; //get the MSB
             sumReg %= scaler; //removing sumReg's MSB
             scaler /= 10;
          }
      }
      return sum;
   }

   private int roundDn(int sum){ //if sum = 595; then roundDn is 100
      int scaler = 10;
      while (sum / scaler >= 10){
         scaler *= 10;
      }
      return scaler;
   }
   /*Even though question asks answer for non-negative integer, this one works for +ve and -ve numbers. I referred this code on stackoverflow.

Note: Negative numbers have digit sum as negative number. If positive digit sum needed for negative numbers then Math.abs() can be used while returning result.
   digital root method:         return 1 + (num-1)%9;*/
}

