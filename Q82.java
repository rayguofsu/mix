//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
//For example,
//Given 1->2->3->3->4->4->5, return 1->2->5.
//Given 1->1->1->2->3, return 2->3. 


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














        //the idea here is to move the intense code into another method; otherwise it is 3 while loop
        //then using the below while loop to connect each non-duplicated newHead node;
        head = newHeadGen(head);
        ListNode headCp = head; //to return it later
        while (head != null){
           ListNode newHead = head; //newHead is the runner here
           head = newHeadGen(head.next);
           newHead.next = head; //connecting here
        }
        return headCp;
    }
    private ListNode newHeadGen(ListNode head){ //this generates each non-duplicated node
       while (head != null){
           //"||" is for cases where distinct one is at the end
          if (head.next == null || head.next.val != head.val){//at here: we are guanranteed that the head here is the first node followed by repeated or non-repeated trace
            //and this if is the condition to check whether it is repeated, if not, return
              return head;
          }
          while (head.next != null && head.next.val == head.val){//skip duplicated
              head = head.next;
          }
          head = head.next; //head is the first node followed by repeated or non-repeated trace
       }
       return head;
    }
}
