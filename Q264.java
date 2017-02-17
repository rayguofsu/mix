264. Ugly Number II
Total Accepted: 25861 Total Submissions: 95057 Difficulty: Medium

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

    The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
    An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
    The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
    Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).


public class Solution {
    public int nthUglyNumber(int n) {
               //use three pointer i2/i3/i5;
       //An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.  
       //the next uglyNumber is Min of (ugly-sequence itself (1, 2, 3, 4, 5, \u2026) multiply 2, 3, 5)
       //if next ugly is uglyNum[i2] * 2; then i2 will increase to point to next a little larger uglyNum
       // and wait to compare to get min for next ugly, if this time, next ugly is not ugly[i2] * 2, then i2 not changed and wait to compare to get min in next next ugly
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
       //
       //
       //
       //
       //
       //
       //
       //
       //
       if (n < 1) return 0;
       int i2 = 0;
       int i3 = 0;
       int i5 = 0;
       int[] uglyNum = new int[n];
       uglyNum[0] = 1;
       int count = 1;
       while(count < n){
         int tmp = Math.min(uglyNum[i2] * 2, uglyNum[i3] * 3);
         int nextUgly = Math.min(tmp, uglyNum[i5] * 5);
         if (nextUgly == uglyNum[i2] * 2) i2++;  //by doing 3 if will avoid duplicate, such as 3*2 = 2*3; if using else if style will be wrong as there will be duplicates
         if (nextUgly == uglyNum[i3] * 3) i3++;
         if (nextUgly == uglyNum[i5] * 5) i5++;
         uglyNum[count] = nextUgly;
         count++;
       }
       return uglyNum[n - 1];
    }
}



//METHOD 2 (Use Dynamic Programming)
//Here is a time efficient solution with O(n) extra space. The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, \u2026
//     because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:
//     (1) 1×2, 2×2, 3×2, 4×2, 5×2, \u2026
//     (2) 1×3, 2×3, 3×3, 4×3, 5×3, \u2026
//     (3) 1×5, 2×5, 3×5, 4×5, 5×5, \u2026
//
//     We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, \u2026) multiply 2, 3, 5. Then we use similar merge method as merge sort, to get every ugly number from the three subsequence. Every step we choose the smallest one, and move one step after.
//
//Algorithm:
//
//1 Declare an array for ugly numbers:  ugly[150]
//2 Initialize first ugly no:  ugly[0] = 1
//3 Initialize three array index variables i2, i3, i5 to point to 
//   1st element of the ugly array: 
//        i2 = i3 = i5 =0; 
//4 Initialize 3 choices for the next ugly no:
//         next_mulitple_of_2 = ugly[i2]*2;
//         next_mulitple_of_3 = ugly[i3]*3
//         next_mulitple_of_5 = ugly[i5]*5;
//5 Now go in a loop to fill all ugly numbers till 150:
//For (i = 1; i < 150; i++ ) 
//{
//    /* These small steps are not optimized for good 
//      readability. Will optimize them in C program */
//    next_ugly_no  = Min(next_mulitple_of_2,
//                                  next_mulitple_of_3,
//                                  next_mulitple_of_5); 
//    if  (next_ugly_no  == next_mulitple_of_2) 
//    {             
//        i2 = i2 + 1;        
//        next_mulitple_of_2 = ugly[i2]*2;
//    } 
//    if  (next_ugly_no  == next_mulitple_of_3) 
//    {             
//        i3 = i3 + 1;        
//        next_mulitple_of_3 = ugly[i3]*3;
//     }            
//     if  (next_ugly_no  == next_mulitple_of_5)
//     {    
//        i5 = i5 + 1;        
//        next_mulitple_of_5 = ugly[i5]*5;
//     } 
//     ugly[i] =  next_ugly_no       
//}/* end of for loop */ 
//6.return next_ugly_no
//
//Example:
//Let us see how it works
//
//initialize
//   ugly[] =  | 1 |
//   i2 =  i3 = i5 = 0;
//
//First iteration
//   ugly[1] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
//            = Min(2, 3, 5)
//            = 2
//   ugly[] =  | 1 | 2 |
//   i2 = 1,  i3 = i5 = 0  (i2 got incremented ) 
//
//Second iteration
//    ugly[2] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
//             = Min(4, 3, 5)
//             = 3
//    ugly[] =  | 1 | 2 | 3 |
//    i2 = 1,  i3 =  1, i5 = 0  (i3 got incremented ) 
//
//Third iteration
//    ugly[3] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
//             = Min(4, 6, 5)
//             = 4
//    ugly[] =  | 1 | 2 | 3 |  4 |
//    i2 = 2,  i3 =  1, i5 = 0  (i2 got incremented )
//
//Fourth iteration
//    ugly[4] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
//              = Min(6, 6, 5)
//              = 5
//    ugly[] =  | 1 | 2 | 3 |  4 | 5 |
//    i2 = 2,  i3 =  1, i5 = 1  (i5 got incremented )
//
//Fifth iteration
//    ugly[4] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
//              = Min(6, 6, 10)
//              = 6
//    ugly[] =  | 1 | 2 | 3 |  4 | 5 | 6 |
//    i2 = 3,  i3 =  2, i5 = 1  (i2 and i3 got incremented )
//
