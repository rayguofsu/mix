86. Partition List
Total Accepted: 57516 Total Submissions: 200547 Difficulty: Medium

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {







               //similar to Q sort list
       ListNode left = new ListNode(0), leftHead = left;
       ListNode right = new ListNode(0), rightHead =right;
       while (head != null){
           ListNode tmp = head.next;
          if (head.val < x){
             left.next = head;
             left = left.next;
          }
          else{
              right.next = head;
              right = right.next;
              right.next = null;//need to have this line to save memory as it can become circle list which consumes infinite memory e.g. [0, 1, 5, 6, 2] 3; 6 will point to 2, 2 points to 5, 5 points to 6
          }
          head = tmp;
       }
       //if (leftHead.next == null) this case is also coverred by below 2 lines//
       left.next = rightHead.next;
       return leftHead.next;
    }
}



