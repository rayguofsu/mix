 320. Generalized Abbreviation 
Write a function to generate the generalized abbreviations of a word.

Example:

Given word = "word", return the following list (order does not matter):

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]




Approach #1 (Backtracking) [Accepted]

Intuition

How many abbreviations are there for a word of length nnn? The answer is 2n2^n2​n​​ because each character can either be abbreviated or not, resulting in different abbreviations.

Algorithm

The backtracking algorithm enumerates a set of partial candidates that, in principle, could be completed in several choices to give all the possible solutions to the problem. The completion is done incrementally, by extending the candidate in many steps. Abstractly, the partial candidates can be seen as nodes of a tree, the potential search tree. Each partial candidate is the parent of the candidates that derives from it by an extension step; the leaves of the tree are the partial candidates that cannot be extended any further.

In our problem, the partial candidates are incomplete abbreviations that can be extended by one of the two choices:

    keep the next character;
    abbreviate the next character.

We extend the potential candidate in a depth-first manner. We backtrack when we reach a leaf node in the search tree. All the leaves in the search tree are valid abbreviations and shall be put into a shared list which will be returned at the end.

Java



public class Solution {
    public List<String> generateAbbreviations(String word){
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), word, 0, 0);
        return ans;
    }

    // i is the current position
    // k is the count of consecutive abbreviated characters
    private void backtrack(List<String> ans, StringBuilder builder, String word, int i, int k){
        int len = builder.length(); // keep the length of builder
        if(i == word.length()){//base case
            if (k != 0) builder.append(k); // append the last k if non zero
            ans.add(builder.toString());
        } else {
            //recursion and build when build, two cases it has
            // the branch that word.charAt(i) is abbreviated
            backtrack(ans, builder, word, i + 1, k + 1);

            // the branch that word.charAt(i) is kept
            if (k != 0) builder.append(k);
            builder.append(word.charAt(i));
            backtrack(ans, builder, word, i + 1, 0);
        }
        builder.setLength(len); // important: reset builder to the original state
    }
}

Complexity Analysis

    Time complexity : O(n*2^n). For each call to backtrack, it either returns without branching, or it branches into two recursive calls. All these recursive calls form a complete binary recursion tree with 2^n leaves and 2^n - 1inner nodes. For each leaf node, it needs O(n) time for converting builder to String; for each internal node, it needs only constant time. Thus, the total time complexity is dominated by the leaves. In total that is O(n*2^n).

    Space complexity : O(n)O(n)O(n). If the return list doesn't count, we only need O(n)O(n)O(n) auxiliary space to store the characters in StringBuilder and the O(n)O(n)O(n) space used by system stack. In a recursive program, the space of system stack is linear to the maximum recursion depth which is nnn in our problem.

