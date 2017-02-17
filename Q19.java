//Given a linked list, remove the nth node from the end of list and return its head.
//
//For example,
//
//   Given linked list: 1->2->3->4->5, and n = 2.
//
//   After removing the second node from the end, the linked list becomes 1->2->3->5.
//
//Note:
//Given n will always be valid.
//Try to do this in one pass. 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
         //actually we should use two runner at the same step size but n nodes apart is maintained as they are both moving
        if (head == null) return null;
        //below case (only one node and try to delete itself) 
        //cannot be handled well, therefore list it below
        //lucked that below "if case" can be handled well by the next if 
        // (fast == null)
       // if (n == 1 && head.next == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        //distance between fast and slow is n
        while (n-- > 0){
           fast = fast.next;
        }
        //if try to remove the head; then below "if" handles it
        if (fast == null){
           return head.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //here fast is at the end and slow is the node before nth to last 
        slow.next = slow.next.next;
        return head;
    }
}
/*   Another initial complex idea is to use Queue to keep n ListNode all the time
        if (head == null) return null;
        Queue<ListNode> q = new LinkedList<ListNode>();
        q.add(head);
        ListNode tmpHead = head;
        while (q.size() != n){
           tmpHead = tmpHead.next;
           //below is a violation of the description; n is unvalid
           if (tmpHead == null) return null; 
           q.add(tmpHead);
        }
        //now q has n entries inside alrady
        //tmpHead is pointing at latest entry in q;
        ListNode node = tmpHead;
        while (tmpHead.next != null){
           tmpHead = tmpHead.next;
           node = q.poll();
           q.add(tmpHead);
        }
        //now, you have tmpHead pointing at the last ListNode
        //and node pointing at the node ahead of nth to last
        q.poll();
        node.next = q.poll();
        return head;
    }

*/

