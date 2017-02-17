294. Flip Game II 

   You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity. 

public class Solution {
/*
    

The idea is try to replace every "++" in the current string s to "--" and see if the opponent can win or not, if the opponent cannot win, great, we win!

For the time complexity, here is what I thought, let's say the length of the input string s is n, there are at most n - 1 ways to replace "++" to "--" (imagine s is all "+++..."), once we replace one "++", there are at most (n - 2) - 1 ways to do the replacement, it's a little bit like solving the N-Queens problem, the time complexity is (n - 1) x (n - 3) x (n - 5) x ..., so it's O(n!!), double factorial. By mathwork: n!!={n·(n-2)...5·3·1 n>0 odd; n·(n-2)...6·4·2 n>0 even; 1 n=-1,0. 

That's what I thought, but I could be wrong :)*/

public boolean canWin(String s) {
  if (s == null || s.length() < 2) {
    return false;
  }
    
  for (int i = 0; i < s.length() - 1; i++) {//recursion has the nature of backtracking; does not need to delete list.size()-1
    //if (s.startsWith("++", i)) {
    if (i+2 <=s.length() && s.substring(i, i+2).equals("++")){
      String t = s.substring(0, i) + "--" + s.substring(i + 2);
      
      if (!canWin(t)) {
        return true;
      }
    }
  }
    
  return false;
}


}


public class Solution {
/*
    

The idea is try to replace every "++" in the current string s to "--" and see if the opponent can win or not, if the opponent cannot win, great, we win!

For the time complexity, here is what I thought, let's say the length of the input string s is n, there are at most n - 1 ways to replace "++" to "--" (imagine s is all "+++..."), once we replace one "++", there are at most (n - 2) - 1 ways to do the replacement, it's a little bit like solving the N-Queens problem, the time complexity is (n - 1) x (n - 3) x (n - 5) x ..., so it's O(n!!), double factorial. By mathwork: n!!={n·(n-2)...5·3·1 n>0 odd; n·(n-2)...6·4·2 n>0 even; 1 n=-1,0. 

That's what I thought, but I could be wrong :)*/

public boolean canWin(String s) {
  if (s == null || s.length() < 2) {
    return false;
  }
    
  for (int i = 0; i < s.length() - 1; i++) {//recursion has the nature of backtracking; does not need to delete list.size()-1
    if (s.startsWith("++", i)) {
      String t = s.substring(0, i) + "--" + s.substring(i + 2);
      
      if (!canWin(t)) {
        return true;
      }
    }
  }
    
  return false;
}


}
