316. Remove Duplicate Letters
Total Accepted: 4730 Total Submissions: 21614 Difficulty: Medium

Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:

Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb" 
public class Solution {
    public String removeDuplicateLetters(String s) {
        //The idea is Given the string s, the greedy choice (i.e., the leftmost letter in the answer) is the smallest s[*i](*i is smallest from 0 to i), s.t. the suffix s[j] for all j > i does not contain char at s[i]. (Importantly note that, when there are more than one smallest s[i]'s, we choose the leftmost one. Why? Simply consider the example: "abcacb".)
//
//After determining the greedy choice s[i], we get a new string s' from s by
//
//    removing all letters to the left of s[i],
//    removing all s[i]'s from s.
//
//We then recursively solve the problem w.r.t. s'.
//
//The runtime is O(26 * n) = O(n).

//The runtime looks like O(n^2) to me :) As every time when removeDuplicateLetters is called, it goes through the whole string to collect cnt, and s.substring(j + 1).replaceAll("" + ch, "") is O(n) as well because it runs through the whole string.
//commented Dec 9, 2015 by chris.zhang.336
//
//Each recursive call takes O(n), but at most 26 recursive calls will be triggered.
//commented Dec 9, 2015 by lixx2100

       if (s.length() == 0) return "";
       int[] cnt = new int[26];
       for (int i = 0; i < s.length(); i++){
          cnt[s.charAt(i) - 'a']++;
       }
       int smallPos = 0;
       for (int i = 0; i < s.length(); i++){
          if (s.charAt(i) < s.charAt(smallPos)) smallPos = i; //satisfy the important note
          if (--cnt[s.charAt(i) - 'a'] == 0) break;
       }
       char small = s.charAt(smallPos);  
       return small + removeDuplicateLetters(s.substring(smallPos + 1).replaceAll("" + small, "")); //like delete, but string does not have delete; but has replace and replace all
       // "em".substring(9) returns "" (an empty string)
    }
    //can use a stack see solution 2 on line
    /*
    public String removeDuplicateLetters(String sr) {

    int[] res = new int[26]; //will contain number of occurences of character (i+'a')
    boolean[] visited = new boolean[26]; //will contain if character (i+'a') is present in current result Stack
    char[] ch = sr.toCharArray();
    for(char c: ch){  //count number of occurences of character 
        res[c-'a']++;
    }
    Stack<Character> st = new Stack<>(); // answer stack
    int index;
    for(char s:ch){ 
        index= s-'a';
        res[index]--;   //decrement number of characters remaining in the string to be analysed
        if(visited[index]) //if character is already present in stack, dont bother
            continue;
        //if current character is smaller than last character in stack which occurs later in the string again
        //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
        while(!st.isEmpty() && s<st.peek() && res[st.peek()-'a']!=0){ 
            visited[st.pop()-'a']=false;
        }
        st.push(s); //add current character and mark it as visited
        visited[index]=true;
    }

    StringBuilder sb = new StringBuilder();
    //pop character from stack and build answer string from back
    while(!st.isEmpty()){
        sb.insert(0,st.pop());
    }
    return sb.toString();
}

    */
}







