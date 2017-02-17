161. One Edit Distance

Given two strings S and T, determine if they are both one edit distance apart.

public class Solution {
    /*
 * There're 3 possibilities to satisfy one edit distance apart: 
 * 
 * 1) Replace 1 char:
 	  s: a B c
 	  t: a D c
 * 2) Delete 1 char from s: 
	  s: a D  b c
	  t: a    b c
 * 3) Delete 1 char from t
	  s: a   b c
	  t: a D b c
 */
    public boolean isOneEditDistance(String s, String t) {
        //to make sure t.length < s.length
        if (t.length() > s.length()) return isOneEditDistance(t, s);
        //for shorter one:
        for (int i = 0; i < t.length(); i++){
            if (s.charAt(i) != t.charAt(i)){//
             //below 1st equals covers cases for length diff >=1
             //2nd equals covers cases for length diff = 0 or diff >=1
                return (s.substring(i+1).equals(t.substring(i)) 
                         || s.substring(i+1).equals(t.substring(i+1)));
            }
        }
        //if reaching here, means now should check the lengther one's length
        return s.length() == t.length()+1;
    }
}
