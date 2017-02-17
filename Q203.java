203. Remove Linked List Elements
Total Accepted: 51605 Total Submissions: 185659 Difficulty: Easy

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5 

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
    public ListNode removeElements(ListNode head, int val) {
        //first valid code
        while (head != null && head.val == val){
            head = head.next;
        }
        ListNode prev = head;
        while (prev != null){
            ListNode nxt = prev.next;
            while (nxt != null && nxt.val == val){
                nxt = nxt.next;
            }
            prev.next = nxt;
            prev = prev.next;
        }
        return head;
    }
}















public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //the idea is to keep two listNodes moving along
        //maintaining the pre does not have val; when next has val, remove it; then pre goes to next non-val node
        //and set next to be pre.next; and repeat this.
        
        //this while loop is to find the first non-val node and assign it to head















        while (head != null && head.val == val){
            head = head.next;
        }
        ListNode pre = head;
        
        //this while loop is to maintain pre does not have val; and check next; then move pre to next non-val node and repeat
        while (pre != null && pre.next != null){
            ListNode next = pre.next;
            if (next.val == val){
                pre.next = next.next;
            }
            else{//next does not have val, so move pre to next
                pre = next;
            }
        }
        return head;
    }
}
