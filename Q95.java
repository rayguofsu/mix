//Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//
//For example,
//Given n = 3, your program should return all 5 unique BST's shown below.
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
//confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
//OJ's Binary Tree Serialization:
//
//The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
//
//Here's an example:
//
//   1
//  / \
// 2   3
//    /
//   4
//    \
//     5
//
//The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}". 
//
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Analysis
//
//Also check out Unique Binary Search Trees I.
//
//This problem can be solved by recursively forming left and right subtrees. The different combinations of left and right subtrees form the set of all unique binary search trees.
//
public class Solution {
    //this one is too hard, just memorize it
    public List<TreeNode> generateTrees(int n) {
        
        /*
        LinkedList and ArrayList are two different implementations of the List interface. LinkedList implements it with a doubly-linked list. ArrayList implements it with a dynamically resizing array.

As with standard linked list and array operations, the various methods will have different algorithmic runtimes.

For LinkedList<E>

    get(int index) is O(n)
    add(E element) is O(1)
    add(int index, E element) is O(n)
    remove(int index) is O(n)
    Iterator.remove() is O(1) <--- main benefit of LinkedList<E>
    ListIterator.add(E element) is O(1) <--- main benefit of LinkedList<E>

For ArrayList<E>

    get(int index) is O(1) <--- main benefit of ArrayList<E>
    add(E element) is O(1) amortized, but O(n) worst-case since the array must be resized and copied
    add(int index, E element) is O(n - index) amortized, but O(n) worst-case (as above)
    remove(int index) is O(n - index) (i.e. removing last is O(1))
    Iterator.remove() is O(n - index)
    ListIterator.add(E element) is O(n - index)

LinkedList<E> allows for constant-time insertions or removals using iterators, but only sequential access of elements. In other words, you can walk the list forwards or backwards, but finding a position in the list takes time proportional to the size of the list.

ArrayList<E>, on the other hand, allow fast random read access, so you can grab any element in constant time. But adding or removing from anywhere but the end requires shifting all the latter elements over, either to make an opening or fill the gap. Also, if you add more elements than the capacity of the underlying array, a new array (1.5 times the size) is allocated, and the old array is copied to the new one, so adding to an ArrayList is O(n) in the worst case but constant on average.

So depending on the operations you intend to do, you should choose the implementations accordingly. Iterating over either kind of List is practically equally cheap. (Iterating over an ArrayList is technically faster, but unless you're doing something really performance-sensitive, you shouldn't worry about this -- they're both constants.)

The main benefits of using a LinkedList arise when you re-use existing iterators to insert and remove elements. These operations can then be done in O(1) by changing the list locally only. In an array list, the remainder of the array needs to be moved (i.e. copied). On the other side, seeking in a LinkedList means following the links in O(n), whereas in an ArrayList the desired position can be computed mathematically and accessed in O(1).

Also, if you have large lists, keep in mind that memory usage is also different. Each element of a LinkedList has more overhead since pointers to the next and previous elements are also stored. ArrayLists don't have this overhead. However, ArrayLists take up as much memory as is allocated for the capacity, regardless of whether elements have actually been added.

The default initial capacity of an ArrayList is pretty small (10 from Java 1.4 - 1.7). But since the underlying implementation is an array, the array must be resized if you add a lot of elements. To avoid the high cost of resizing when you know you're going to add a lot of elements, construct the ArrayList with a higher initial capacity.

It's worth noting that Vector also implements the List interface and is almost identical to ArrayList. The difference is that Vector is synchronized, so it is thread-safe. Because of this, it is also slightly slower than ArrayList. So as far as I understand, most Java programmers avoid Vector in favor of ArrayList since they will probably synchronize explicitly anyway if they care about that.*/
        List<TreeNode> list = new ArrayList<>();  //above is when to use linkedlist or arraylist; most just use arraylist
        if (n == 0) return list;
        return generateTreesR(1, n);
    }
    private List<TreeNode> generateTreesR(int start, int end){
       List<TreeNode> list = new ArrayList<>();
       if (start > end){
          list.add(null);
          return list;
       }
       for (int i = start; i <= end; i++){ //each i is root
          List<TreeNode> leftNodes = generateTreesR(start, i - 1); //generates leftTrees containing start to i - 1 
          List<TreeNode> rightNodes = generateTreesR(i + 1, end); //generate rightTrees containing i + 1 to end
          for (TreeNode left : leftNodes){ //use i as root and generate difference combinations of leftTree and rightTree
             for (TreeNode right: rightNodes){
                 TreeNode node = new TreeNode(i); //each combination is a new tree, so a new root node is generated each time
                 node.left = left;
                 node.right = right;
                 list.add(node);
             }
          }
       }
       return list;
    }

}

// LeetCode – Unique Binary Search Trees (Java)
// 
//
//Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
//
//For example, Given n = 3, there are a total of 5 unique BST's.
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
//Analysis
//
//Let count[i] be the number of unique binary search trees for i. The number of trees are determined by the number of subtrees which have different root node. For example,
//
//i=0, count[0]=1 //empty tree
//
//i=1, count[1]=1 //one tree
//
//i=2, count[2]=count[0]*count[1] // 1 is root
//            + count[1]*count[0] // 2 is root
//
//i=3, count[3]=count[0]*count[2] // 1 is root
//            + count[1]*count[1] // 2 is root
//            + count[2]*count[0] // 3 is root
//
//i=4, count[4]=count[0]*count[3] // 1 is root
//            + count[1]*count[2] // 2 is root
//            + count[2]*count[1] // 3 is root
//            + count[3]*count[0] // 4 is root
//..
//..
//..
//
//i=n, count[n] = sum(count[0..k]*count[k+1...n]) 0 <= k < n-1
//
//Use dynamic programming to solve the problem.
//
//Java Solution

public int numTrees(int n) {
	int[] count = new int[n + 1];
 
	count[0] = 1;
	count[1] = 1;
 
	for (int i = 2; i <= n; i++) {
		for (int j = 0; j <= i - 1; j++) {
			count[i] = count[i] + count[j] * count[i - j - 1];
		}
	}
 
	return count[n];
}


