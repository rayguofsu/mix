278. First Bad Version
Total Accepted: 32162 Total Submissions: 147012 Difficulty: Easy

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API. 


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
//if I use 'int mid = (left + right)/2;' in the while sentance,the program will apear error 'Time Limit Exceeded'. Why? Thank you!
//Hi, lixiao, if left and right are both very large, their sum will exceed integer limit
//I think there is no need to use long.We can use "int mid = start + (end-start) / 2;" to solve the problem.
public class Solution extends VersionControl {
    //Binary search
    public int firstBadVersion(int n) {



/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
      int low = 1;
      int high = n;
      int res = n;
      while(low <= high){
         int mid = low + (high - low) / 2;
         if (isBadVersion(mid)){
           high = mid - 1;
           res = mid;
         }
         else{
           low = mid + 1;
         }
      }
      return res;
    }
}








        if (n < 1) return -1;
        int low = 1;
        int high = n;
        int middle;
        
        //if (isBadVersion(1)) return 1;
        while (low <= high){
            middle = low + (high - low) / 2;
            if (isBadVersion(middle)){
                if (!isBadVersion(middle -1)){ //BS: modified here; good!
                    return middle;
                }
                high = middle - 1;
            }
            else{
                low = middle + 1;
            }
        }
        return -1; 
    }
}
