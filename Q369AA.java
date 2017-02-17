369. Plus One Linked List 

Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

Example:

Input:
1->2->3

Output:
1->2->4


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {


/*At the first glance, I want to reverse the inputs, add one, then reverse back. But that is too intuitive and I don't think this is an expected solution. Then what kind of alg would adding one in reverse way for list?

Recursion! With recursion, we can visit list in reverse way! So here is my recursive solution.*/

public ListNode plusOne(ListNode head) {
    if( DFS(head) == 0){
        return head;
    }else{
        ListNode newHead = new ListNode(1);
        newHead.next = head;
        return newHead;
    }
}

public int DFS(ListNode head){
    if(head == null) return 1;
    
    int carry = DFS(head.next);
    //using recursion: when below doing backtracking, edit it.
    if(carry == 0) return 0;
    
    int val = head.val + 1; //the +1 means either the added one for last non-null node or 1 for carry for non-last node
    head.val = val%10;
    return val/10;
}


}
