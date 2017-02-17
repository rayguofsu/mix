142. Linked List Cycle II
Total Accepted: 67862 Total Submissions: 215633 Difficulty: Medium

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space? 

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //cc150 original question:
    //fast runs at 2x, slow runs at 1x; assume when slow runs to the start of cicle, it has run K steps, then fast is K%lc into the circle (lc is the length of the circle); or in other words, now fast is behind slow by lc - k%lc steps; so after another slow runs for another lc - k % lc; fast runs another 2 * (lc - k % lc); this time, slow and fast meet 1st time @ slows is lc - k % lc into the circle; or k % lc step behind the starting point 0f the circle; now put fast back to head and let fast run at 1X speed, after K steps, fast is the start of circle; and slow runs also K steps, since K = K % lc + N*lc; so they meet now at start of circle
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            //first time meet
            if (fast == slow){//compare by reference using ==
                break;
            }
        }
        if (fast == null || fast.next == null){//to check here if this is the reason it breaks above while
            return null;
        }
        fast = head;
        //if have not return null by above, it means it has to have a circle;
        //so next while for 2nd time meet, do not check on null
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast; //when exiting the 2nd while, they meet 2nd time
    }
}

