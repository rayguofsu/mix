61. Rotate List
Total Accepted: 57938 Total Submissions: 259851 Difficulty: Medium

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {







                //idea is to use two runner; place one k steps before the other;
        //when the fast one runs to the end; the slow one's next is the new head
       //just cut slow.next  to null and connect the fast.next to old head and return new head
        if (head == null || k <= 0 || head.next == null) return head; //.next == null is newly added
        ListNode fast = head;
        int count = 0;
        while (fast != null){
            count++;
            fast = fast.next;
        }
        k = k % count;
        if (k == 0) return head; //has to return here, otherwise it may cause null pointer issue when doing while(fast.next != null)
        fast = head;
        while(k-->0){
          fast = fast.next;
        }
        ListNode slow = head;
        while (fast.next != null){
           slow = slow.next;
           fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}


