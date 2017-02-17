17. Letter Combinations of a Phone Number
Total Accepted: 72763 Total Submissions: 258812 Difficulty: Medium

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want. 

public class Solution {
    public List<String> letterCombinations(String digits) {
        //similar to Q permutations
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        
        if (digits == null || digits.length() == 0) return new ArrayList<String>();
        char[][] map = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        return combGenR(digits, digits.length() -1, map);
    }

    private List<String> combGenR(String digits, int index, char[][] map){
        char c = digits.charAt(index);
        char[] mask = map[c - '0'];
        //base case
        if (index == 0){//somehow the base case here is a little redundant; tried shift index, but needing other changes..
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < mask.length; i++){
                String newStr = new String(mask[i] +"");
                list.add(newStr);
            }
            return list;
        }
        //recurse
        List<String> pre = combGenR(digits, index - 1, map);
        //build
        List<String> newList = new ArrayList<String>();
        for (int i = 0; i < mask.length; i++){
            for (int j = 0; j < pre.size(); j++){
                String newStr = new String(pre.get(j));
                newStr += mask[i];
                newList.add(newStr);
            }
        }
        return newList;
    }
}
