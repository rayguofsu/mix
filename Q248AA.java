248. Strobogrammatic Number III
  A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

For example,
Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

Note:
Because the range might be a large number, the low and high numbers are represented as string. 

public class Solution {
    
  /*  Construct char arrays from low.length() to high.length()
    Add stro pairs from outside
    When left > right, add eligible count */

private static final char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

public int strobogrammaticInRange(String low, String high) {
    int[] count = {0};
    for (int len = low.length(); len <= high.length(); len++) {
        char[] c = new char[len];
        dfs(low, high, c, 0, len - 1, count);
    }
    return count[0];
}

public void dfs(String low, String high , char[] c, int left, int right, int[] count) {
    if (left > right) {
        String s = new String(c);
        if ((s.length() == low.length() && s.compareTo(low) < 0) || 
            (s.length() == high.length() && s.compareTo(high) > 0)) {
            return;
        }
        count[0]++;
        return;
    }
    for (char[] p : pairs) {
        c[left] = p[0];
        c[right] = p[1];
        if (c.length != 1 && c[0] == '0') {
            continue;
        }
        if (left == right && p[0] != p[1]) {
            continue;
        }
        dfs(low, high, c, left + 1, right - 1, count);
    }
}
}

/*
The basic idea is to find generate a list of strobogrammatic number with the length between the length of lower bound and the length of upper bound. Then we pass the list and ignore the numbers with the same length of lower bound or upper bound but not in the range.

I think it is not a a very optimized method and can any one provide a better one?



Same Algorithm, but just use O(1) Space. :)

public class Solution {
public class Wrapper{
    int cnt = 0;
}

public int strobogrammaticInRange(String low, String high) {
    Wrapper w = new Wrapper();
    for(int i = low.length(); i <= high.length(); i++){
        help(w, "", i, low, high);
        help(w, "0", i, low, high);
        help(w, "1", i, low, high);
        help(w, "8", i, low, high);
    }
    return w.cnt;
}

//w:      used to record the number of valid Strobogrammatic Number
//path:   current string
//len:    the limit string length
//low:    the lower bound
//high:   the upper bound
public void help(Wrapper w, String path, int len, String low, String high){
    if(path.length() >= len){
        //Invalid String path
        if(path.length() != len || (len != 1 && path.charAt(path.length()-1) == '0')){
            return;
        }
        //If low and high both have the same length
        else if(low.length() == high.length()){
            if(path.compareTo(low) >= 0 && path.compareTo(high) <= 0){
                w.cnt ++;
            }
            return;
        }
       //If low and high have different lengthes
        else{
            if(len == low.length() && path.compareTo(low) >= 0){
                w.cnt ++;
            }
            else if(len == high.length() && path.compareTo(high) <= 0){
                w.cnt ++;
            }
            else if(len > low.length() && len < high.length()){
                w.cnt ++;
            }
            return;
        }
    }
    
    help(w, "0"+path+"0", len, low, high);
    help(w, "1"+path+"1", len, low, high);
    help(w, "6"+path+"9", len, low, high);
    help(w, "8"+path+"8", len, low, high);
    help(w, "9"+path+"6", len, low, high);
}
}

*/
