371. Sum of Two Integers
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3. 
public class Solution {
    public int getSum(int a, int b) {
    //return b==0? a:getSum(a^b, (a&b)<<1); //be careful about the terminating condition;
    //}
     
        
        
        int c = a & b;
        while (c != 0){ //using c > 0 for positive; but != 0 can handle both neg and pos
            a = a ^ b;
            b = c << 1;
            c = a & b;
        }
        return (a ^ b);
    }
}
