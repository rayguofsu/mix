92. Reverse Linked List II
Total Accepted: 66428 Total Submissions: 241676 Difficulty: Medium

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. 


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
    public ListNode reverseBetween(ListNode head, int m, int n) {
















        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int c = 1;
        while (c < m){//move prev and head to right by m nodes
            prev = head;
            head = head.next;
            c++;
        }
        prev.next = reverse(head, n-m+1);  //reverse list from head by n-m+1 times and connect prev with reversed head
        return dummy.next;
    }
    private ListNode reverse(ListNode head, int count){
        ListNode headCp = head;
        ListNode prev = null;
        ListNode nxt = null;
        while (count > 0){
            nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
            count--;
        }
        headCp.next = head;  //connect the tail of the reversed list to remaining nodes
        return prev;  //return prev as the reversed head
    }
}






public class Solution { //below code is so hard to understand
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode headCp = head;
        int c = 1;
        ListNode newHead = null;
        ListNode preNode = null;
        while (c <= n){
            if (m > 1 && c == m - 1) newHead = head;
            head = head.next;
            c++;
        }
        preNode = head;
        ListNode nodeM = (m == 1) ? headCp : newHead.next;
        ListNode revNode = reverse(nodeM, n - m + 1, preNode);
        if (m == 1) return revNode;
        else{//m > 1
            newHead.next = revNode;
            return headCp;
        }
    }
    private ListNode reverse(ListNode head, int count, ListNode preNode){
        ListNode tmp = null;
        while (count > 0){
            tmp = head.next;
            head.next = preNode;
            preNode = head;
            head = tmp;
            count--;
        }
        return preNode;
    }
}
