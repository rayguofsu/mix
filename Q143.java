143. Reorder List
Total Accepted: 56742 Total Submissions: 258157 Difficulty: Medium

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}. 

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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }//this is a good way to make sure slow.next always points to the later half's head; 5 or 4 elements, it points at fourth or third
        ListNode newHead = reverse(slow.next);
        slow.next = null;
        while (newHead !=null){
            ListNode headNext = head.next;
            ListNode newNext = newHead.next;
            head.next = newHead;
            newHead.next = headNext;
            head = headNext;
            newHead = newNext;
        }
    }
    private ListNode reverse(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}

//need to 1). Change it to move fast runner one step first; then at end make slow.next = null to guarantee two things : 1. first half size >= 2nd half always; 2. make it slow.next = null can handle even/odd length both cases; can remove the count as we know 2nd half always size small
//2). change to use iterative to handle it as too long for recursion on some inputs
//
public class Solution {
    public void reorderList(ListNode head) {
        //idea is simple, just make sure the first half size >= sec half, (need to use smart way to do this, see below);
        //then reverse the 2nd half and merge/insert element by element into first half
        if (head == null || head.next == null || head.next.next == null) return ;
        ListNode fast = head.next.next;
        ListNode slow = head;
       // while (fast != null && fast.next != null){
       //     fast = fast.next.next;
       //     slow = slow.next;
       // }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
            if (fast != null){
               fast = fast.next;
            }
        } //now while can guanree first half size >= 2nd half size
        fast = head;
        ListNode newHead = reverseList(slow.next);
        slow.next = null;
        while(newHead != null){
            ListNode fastNxt = fast.next; //cp
            ListNode newNxt = newHead.next; //cp
            fast.next = newHead; //connect
            //System.out.println("connecting " + fast.val + " and " + newHead.val);
            newHead.next = fastNxt; //connect
            //System.out.println("connecting " + newHead.val + " and " + sec.val);
            fast = fastNxt; //move
            newHead = newNxt; //move
        }
    }
    private ListNode reverseList(ListNode head){
        if (head == null || head.next == null) return head;//changed to use iterative solution rather than recursion solution
        ListNode newHead = null;
        while (head != null){
            ListNode tmp = head.next; 
            head.next = newHead; 
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
}
