Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:

//    For the return value, each inner list's elements must follow the lexicographic order.
//    All inputs will be in lower-case.
public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {

















     HashMap<String, List<String>> map = new HashMap<>();
     for (String s: strs){
         char[] chars = s.toCharArray();
         Arrays.sort(chars);
         String str = String.valueOf(chars);
         List<String> lis = map.get(str);
         if (lis == null){
            lis = new ArrayList<String>();
            map.put(str, lis);
         }
         lis.add(s);
     }
     List<List<String>> res = new ArrayList<List<String>>();
     for (List<String> l: map.values()){
         Collections.sort(l);//will reorganise the list of string to lexicographic order
         res.add(l);
     }
     return res;
  }
}




