//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//For example,
//Given 1->1->2, return 1->2.
//Given 1->1->2->3->3, return 1->2->3. 
//
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {


    }
}












        ListNode headCopy = head; //keep a copy to return in the end
        while (head != null){ //tranverse through the list
            ListNode newHead = head; //copy the head
            while(head.next != null && head.next.val == head.val){ //to skip duplicates
                head = head.next; //duplicate meets; so go down one step
            }
            //when here: head.next != head.val: so: connect below
            newHead.next = head.next;
            //now iterate to next node
            head = head.next;
        }
        return headCopy;
    }
}
