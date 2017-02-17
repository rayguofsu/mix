//Given a pattern and a string str, find if str follows the same pattern.
//
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
//
//Examples:
//
//    pattern = "abba", str = "dog cat cat dog" should return true.
//    pattern = "abba", str = "dog cat cat fish" should return false.
//    pattern = "aaaa", str = "dog cat cat dog" should return false.
//    pattern = "abba", str = "dog dog dog dog" should return false.
//
//Notes:
//You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space. 




public class Solution {
    public boolean wordPattern(String pattern, String str) { 










    //HashMap<char, String> map = new HashMap<char, String>(); this is wrong; has to be 
    //reference types (Character), not primitive types (char),
    ////this is correct:HashMap<Character, String> table = new HashMap<Character, String>();
    //recall this is bijection; i.e. double direction mapping 
    if (str.equals("") || pattern.equals("")) return false;
    //if (str == ("") || pattern== ("")) return false;
    String[] patStr = pattern.split("");
    String[] words = str.split(" ");
    if (patStr.length != words.length) return false;
    HashMap<String, String> map = new HashMap<String, String>();
    for (int i = 0; i < words.length; i++){
       boolean containsPat = map.containsKey(patStr[i]);
       boolean containsWord = map.containsValue(words[i]);
       //if both false we need to put it into map//
       if (!containsPat && !containsWord){
          map.put(patStr[i], words[i]);
       }
       else if (containsPat){ //containsWord could be either or; if containsWord is also true, it can be right or wrong; as it may not map to the same key; so you cannot judge by only checking contasinWord instead of checking the real mapping word
          //check word here
          if (!map.get(patStr[i]).equals(words[i])){
             return false;
          }
       }
       else if (containsWord){//do not have pattern, but have word in map; it has to be false
          //check pattern/key here
           /* for (String key : map.keySet()) {  //this is not necessary
                if (key != patternArray[i]) return false;
            }
           */
           return false;
       }
    }
    return true;
    }
}










