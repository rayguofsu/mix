Reverse a singly linked list.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {

    //iteration solution cost O(n) time but O(1) space
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null){
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }

















//below is recursion
       if (head == null) return null;  //if empty list just return null
       if (head.next == null) return head; //return the last node
       
       ListNode sec = head.next;  //this is nothing; but helping to recurse to end
       head.next = null;  //cut the connection
       //now recurse to the end
       ListNode newHead = reverseList(sec);
       sec.next = head;
       return newHead; //this will return newHead all the way to 1st recursion
    }
}




