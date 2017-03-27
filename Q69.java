69. Sqrt(x)
Total Accepted: 81240 Total Submissions: 330850 Difficulty: Medium

Implement int sqrt(int x).

Compute and return the square root of x.
//keep in mind that 
//(1) (low+high)/2 is not the same with low+(high-low)/2 //the former can overflow
//(2) mid*mid == x is not the same with mid == x/mid     //the former can overflow
public class Solution {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        int lo = 0, hi = x;
        int res = 0;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (mid * mid <= x){
                res = mid;
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return res;
    }
}
public class Solution {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        if (x == 1) return 1;
        int lo = 0; 
        int hi = x;
        int res = 0;
        while (lo <= hi){
            int mid = (hi - lo) / 2 + lo;
            if (mid > x / mid) hi = mid -1;
            else if (mid < x/mid){
                lo = mid+1;
                res = mid;
            }
            else{
                res = mid;
                break;
            }
        }
        return res;
    }
}











public class Solution {
//keep in mind that 
//(1) (low+high)/2 is not the same with low+(high-low)/2 //the former can overflow
//(2) mid*mid == x is not the same with mid == x/mid     //the former can overflow
    public int mySqrt(int x) {

























        if (x < 4) return x == 0 ? 0 : 1;
       //try Binary search
       int low = 1; //low = 0; will give x/low issue as divide by zero
       int high = x;
       int res = 0;
       while (low <= high){
         if (low > x/low) break;  //for speed up only; as smallest's squre > x; no need to go further
         int mid = low + (high - low)/2; 
         if (mid <= x/mid){
            res = mid; //to store the latest value whose power is <= x
            low = mid + 1;
         }
         else{
            high = mid - 1;
         }
       } 
       return res;
    }
}











