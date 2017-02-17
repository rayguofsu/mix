class Solution {
  
  private static class TrieNode{
    TrieNode[] child;
    String item;
    public TrieNode(){
        child = new TrieNode[26];
        item = "";
    }
  }

  static TrieNode root = new TrieNode();
    // Adds a word into the data structure.
  public static void addWord(String word) {
        int index = 0;
        TrieNode node = root;
        for (char c: word.toCharArray()){
            index = c-'a';
            if (node.child[index] == null){
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
        }
        node.item = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public static List<String> search(String word) {
        List<String> list = new ArrayList<>();
        helper(word, root, 0, list);
        return list;
    }
    
    
    private static void helper(String word, TrieNode node, int start, List<String> list) {
        //base case
        if (node == null) return;
        if (start == word.length()){
            if (!node.item.equals("")) list.add(node.item);
            return;
        }
        
        char c = word.charAt(start);
        if (c == '.'){  
            for (int j = 0; j < 26; j++){
                helper(word, node.child[j], start+1, list);
            }
        }
        else{
            int index = c - 'a';
            helper(word, node.child[index], start+1, list);
        }
    }


// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
  
  
  
  public static void main(String[] args) {
      addWord("abc");
      addWord("abcde");
    addWord("aecde");
    addWord("aacde");
    addWord("afcde");
    addWord("accde");
    addWord("ade");
    
      boolean abc = true;
      System.out.println(abc);
      List<String> res = search("a....");
      for (String str : res){
        System.out.println("string is " + str);
      }
    
    
  }
}

