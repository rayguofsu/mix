//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//Note:
//You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int i = m + n - 1;
        while(p1 >= 0 && p2 >= 0){
            if (nums1[p1] < nums2[p2]) nums1[i--] = nums2[p2--];
            else nums1[i--] = nums1[p1--];
        }
        while(p2 >= 0) nums1[i--] = nums2[p2--];
    }

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       if (m < 0 || n < 0) return;
       int index = m + n - 1;
       m--;
       n--;
       while (n >= 0 && m >= 0){
          index--;
          if (nums1[m] > nums2[n]){
              //start from behind to avoid overwritting
             nums1[index] = nums1[m];
             m--;
          }
          else{
             nums1[index] = nums2[n];
             n--;
          }
       }
       //look nums1 and nums2 cannot run out at the same time

       //if nums1 runs out first; then copy over rest of nums2
       if (m < 0){
          for (int i = 0; i <= n; i++){
             nums1[i] = nums2[i];
          }
       }
       //if n < 0; meaning nums2 runs out first; then no need to do anything
    }
}
