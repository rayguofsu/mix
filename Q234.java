Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
    //thinking to use two runner; after finding middle node, then reverse
    //from middle to the end using iteration instead of recursion, as O(1) space required
    //then compare value on this two half list











       if (head == null || head.next == null) return true;
       ListNode slow = head;
       ListNode fast = head;
       while (fast != null && fast.next != null){
         slow = slow.next;
         fast = fast.next.next;
       }
       //slow is at middle now
       ListNode newHead = reverse(slow);
       while (newHead != null){
          if (newHead.val != head.val){
             return false;
          }
          newHead = newHead.next;
          head = head.next;
       }
       return true;
    }

    public ListNode reverse(ListNode head){
    //same code solution as shown in leetcode another reverse linkedlist Q
       ListNode newHead = null;
       ListNode tmp = null;
       while (head != null){
         tmp = head.next;
         head.next = newHead;
         newHead = head;
         head = tmp;
       }
       return newHead;
   }
}
