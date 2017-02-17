208. Implement Trie (Prefix Tree)
Total Accepted: 28320 Total Submissions: 112580 Difficulty: Medium

Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z. 
class TrieNode {  //see below access level
    // Initialize your data structure here.
    boolean endsHere;
    TrieNode[] branches; 
    public TrieNode() {
        endsHere = false;
        branches = new TrieNode[26];
    }
}
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null) {
            return;
        }
        TrieNode p = root;
        for (int i=0; i<word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (p.branches[index] == null) {//好像如果要是CLASS 的ARRAY是时候必须要这样定义才行； 就是先定义一个宏观的branches = new TrieNode[26];然后实际上每个都还是NULL 呢。。必须要一个个的再定义下。。董了。
                p.branches[index] = new TrieNode();
            }
            p = p.branches[index];
            //Unlike a binary search tree, no node in the tree stores the key associated with that node; instead, its position in the tree defines the key with which it is associated. 
        }
        p.endsHere = true;  //endsHere could have children nodes also.
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        TrieNode p = root;
        for (int i=0; i<word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (p.branches[index] == null) {
                return false;
            }
            p = p.branches[index];
        }
        return p.endsHere == true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        TrieNode p = root;
        for (int i=0; i<prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            if (p.branches[index] == null) {
                return false;
            }
            p = p.branches[index];
        }
        return true;
    }
}


// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

//some thing to learn here:
/*Access Levels Modifier 	Class 	Package 	Subclass 	World
public 	        Y 	Y 	Y 	Y
protected 	Y 	Y 	Y 	N
no modifier 	Y 	Y 	N 	N
private 	Y 	N 	N 	N
*/



/*http://www.javacoffeebreak.com/faq/faq0002.html
We use these keywords to specify access levels for member variables, or for member functions (methods).

    Public variables, are variables that are visible to all classes.
    Private variables, are variables that are visible only to the class to which they belong.
    Protected variables, are variables that are visible only to the class to which they belong, and any subclasses.

Deciding when to use private, protected, or public variables is sometimes tricky. You need to think whether or not an external object (or program), actually needs direct access to the information. If you do want other objects to access internal data, but wish to control it, you would make it either private or protected, but provide functions which can manipulate the data in a controlled way.

Take the following example :

public class bank_balance
{
	public String owner;
	public int balance; 

	public bank_balance( String name, int dollars )
	{
		owner = name;

		if (dollars >= 0)
			balance = dollars;
		else
			dollars =0;
	}
}

We have declared our string and integer to be public. This means that any object in the system can change the balance (setting it to zero, or even giving us a negative balance). This could cause the program to fall over, even though we wrote code in our constructor to prevent negative balances.

Instead, we should have provided a getBalance/setBalance method, and made our balance private or proteced. Other objects can still access the data, but they can't put invalid data in.

public class bank_balance
{
	public String owner;
	private int balance; 

	public bank_balance( String name, int dollars )
	{
		owner = name;

		if (dollars >= 0)
			balance = dollars;
		else
			dollars =0;
	}

	public int getBalance()
	{
		return balance;
	}

	public void setBalance(int dollars)
	{
		if (dollars >= 0)
			balance = dollars;
		else
			dollars = 0;		
	}
}
*/



