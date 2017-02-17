131. Palindrome Partitioning
Total Accepted: 56947 Total Submissions: 208061 Difficulty: Medium

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]


//String string="whatever";
//String reverse = new StringBuffer(string).reverse().toString();

public class Solution { //why O(n * 2^n)//java , recursion, backtracking O(n * 2^n)
    public List<List<String>> partition(String s) {
      List<List<String>> res = new ArrayList<>();
      if (s == null || s.length() == 0) return res;
      List<String> path = new ArrayList<>();
      palinRecBec(s, res, path, 0);
      return res;
    }


    private void palinRecBec(String s, List<List<String>> res, List<String> path, int start){
        if (start == s.length()){
            res.add(new ArrayList<>(path));
            //res.add(path);IMPORTANT: this sucks, as it will be removed after all
            return;
        }
        for(int i = start + 1; i <= s.length(); i++){
            String sub = s.substring(start, i);
            if (isPalindrom(sub)){//if not Palin? then expand it, when reaching the end, if it is Palindrome, the above if will add it; otherwise, it will not be added, but it will get removed when backtraing one by one
                path.add(sub);
                palinRecBec(s, res, path, i);
                path.remove(path.size() - 1);//this is called backtracking
            }
        }
    }
    
    private boolean isPalindrom(String sub){
       for (int i = 0; i < sub.length()/2; i++){ //remeber /2
          if (sub.charAt(i) != sub.charAt(sub.length() - 1 -i))
             return false;
       }
       return true;
    }
}























