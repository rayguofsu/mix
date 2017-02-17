21. Merge Two Sorted Lists
Total Accepted: 107744 Total Submissions: 311912 Difficulty: Easy

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.


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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {










        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while(l1 != null && l2 != null){
            if (l1.val <= l2.val){
                node.next = l1;
                l1 = l1.next;
            }
            else{
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 == null){
            node.next = l2;
        }
        else{
            node.next = l1;
        }
        return dummy.next;
    }
    
}







public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        ListNode head = null; //first get the head;
        if (l1.val < l2.val){
            head = l1;
            connect(head, head.next, l2);
        }
        else{
            head = l2;
            connect(head, head.next, l1);
        }
        return head;
    }
    public void connect(ListNode n, ListNode p, ListNode q){
        //this is like two runner p and q
        //n.next = smaller node
        while (p != null && q != null){
            if (p.val < q.val){
                n.next = p;
                p = p.next;
            }
            else{
                n.next = q;
                q = q.next;
            }
            n = n.next;
        }
        //in case one is shorter and shorter runs over sooner
        n.next = (q == null) ? p : q;
    }
}
