 Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000. 

public class Solution {
    
    public int nthSuperUglyNumber(int n, int[] primes) {//the primes cannot contain 1; otherwise, it won't work; as next pointer for 1 is 0, which is always smaller, since it will give 0
       // the idea is from Q264
        if (n < 1 || primes == null || primes.length == 0) return 0;
        int[] pointer = new int[primes.length];
        int[] ugly = new int[n];
        ugly[0] = 1;
        int count = 1;
        while (count < n){
           int next = nextUgly(primes, ugly, pointer, count - 1);
           ugly[count] = next;
           count++;
           // System.out.println("ugly are: " + Arrays.toString(ugly));
            //System.out.println("pointers are: " + Arrays.toString(pointer));
        }

        return ugly[n - 1];
    }

    private int nextUgly(int[] primes, int[] ugly, int[] pointer, int last){
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < pointer.length; i++){
            int tmp = ugly[pointer[i]] * primes[i];
            if (tmp == ugly[last]){//to handle duplicates; as 3*2 = 2*3
                pointer[i]++;
                //continue;  //this is a bug; as it will missed current pointer[i]; as maybe after pointer[i]++, it still less than min
                tmp = ugly[pointer[i]] * primes[i];
            }
            if (min > tmp){ //!=  is because, there could be duplcate; as 2*7 is next; and for next next, 7 * 2 again is the next
               min = tmp;
               index = i;
            }
        }
        pointer[index]++;
        return min;
    }
}

