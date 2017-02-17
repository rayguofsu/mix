441. Arranging Coins

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.

Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
public class Solution {
    public int arrangeCoins(int n) {
        int res = 0;
        long st = 0;
        //long end = (n+1) / 2;
        long longn = n;
        long end = (longn+1) / 2;
        while(st <= end){
            long mid = st + (end - st) / 2;
            //System.out.println("mid is " + mid);
            if ((1+mid)*mid <= 2*longn){
                res = (int) mid;
                st = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return res;
    }
}
