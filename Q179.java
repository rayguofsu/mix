179. Largest Number
Total Accepted: 37737 Total Submissions: 210905 Difficulty: Medium

Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

public class Solution {
    public String largestNumber(int[] nums) {
       if (nums == null || nums.length == 0) return "";
       int length = nums.length;
       String[] str = new String[length];
       for (int i = 0; i < length; i++){
          str[i] = nums[i] + "";//String.valueOf(nums[i])
       }
       Arrays.sort(str, new Comparator<String>(){
          @Override
          public int compare(String i, String j){//from small to larger order
              return (i+j).compareTo(j+i);
          }
       });
//       if (str[length -1].charAt(0) == '0') return "0"; //in case of {0, 0}; if last one's first char is 0; return 0 //but non-negative assumed?
//wrong code       if (str[length -1] == '0') return "0"; //in case of {0, 0}; if last one's first char is 0; return 0 //but non-negative assumed?
       if (str[length -1].equals("0")) return "0"; //in case of {0, 0}; if last one is 0; return 0 //but non-negative assumed? //cannot use == for string
       String res = new String(); 
       for (int i = 0; i < length; i++){
          res = str[i] + res;//adding larger in front
       }
       return res;
     }
}


public class Solution { //QuickSort page 129
public String largestNumber(int[] nums) {
    int N = nums.length;
    String[] strs = new String[N];
    for(int i = 0; i< N; i++){
        strs[i] = String.valueOf(nums[i]);
    }

    quicksort(strs, 0, N-1);

    if(strs[0].equals("0")) return "0";
    StringBuilder sb = new StringBuilder();
    for(String s: strs) sb.append(s);
    return sb.toString();
}
private void quicksort(String[] a, int lo, int hi){
    if(lo>=hi) return;
    int lt = lo, gt = hi;
    int i = lo+1;
    String v = a[lo];
    while(i<=gt){
        String s = a[i];
        if(compare(s,v) > 0) exch(a, i++, lt++);
        else if(compare(s, v) < 0) exch(a, i, gt--);
        else i++;
    }
    quicksort(a, lo, lt-1);
    quicksort(a, gt+1, hi);
}
private int compare(String i, String j){
    String str1 = i+j;
    String str2 = j+i;
    return str1.compareTo(str2);
}
private void exch(String[] a, int i, int j){
    String tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
}
