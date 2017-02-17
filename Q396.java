396. Rotate Function

 Given an array of integers A and let n to be its length.

Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:

F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

Calculate the maximum value of F(0), F(1), ..., F(n-1).

Note:
n is guaranteed to be less than 105.

Example:

A = [4, 3, 2, 6]

F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

public class Solution {
    public int maxRotateFunction(int[] A) {
        //sum = total
        //F(0) = 0*a0+1*a1+2*a2+3*a3;
        //F(1) = 0*a3+1*a0+2*a1+3*a2 = F(0) +sum - 4*a3;
        //F(2) = 0*a2+1*a3+2*a0+3*a1 = F(1) + sum - 4*a2;
        int sum = 0; int f = 0;
        for (int i = 0; i < A.length; i++){
            sum += A[i];
            f += i*A[i];
        }
        int max = f;
        for (int i = 0; i < A.length; i++){
            f = f + sum - A.length*A[A.length-1-i];
            max = Math.max(max, f);
        }
        return max;
    }
}
