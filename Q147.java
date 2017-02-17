147. Insertion Sort List
Total Accepted: 64795 Total Submissions: 225916 Difficulty: Medium

Sort a linked list using insertion sort.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {//O(n^2)? Chris
















        //the idea is to get another linkedlist with dummy fixed(result list) in front; as moving along old listnode, need to traverse the result list to find the last smaller than current node value; and then insert current node to result list and move current node one step further in the old list
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);//create a dummy here is for better returning result; as head is moving; but dummy is not
       /* these lines can be removed due to the first iteration of while loop will get it done; the first iteration will not trigger inner while loop;as traverResult.next = null; just add the first head to dummpy's back in the first iteration
       dummy.next = head;
        dummy.next.next = null;
        head = head.next;
        */
        while(head != null){
            ListNode traverseResult = dummy;
            while(traverseResult.next != null && traverseResult.next.val < head.val){
                traverseResult = traverseResult.next;
            }//here is to find the last smaller than head.val element in current result 
            //now insert head into its back
            ListNode tmp = head.next;  //copy
            head.next = traverseResult.next;
            traverseResult.next = head;
            head = tmp; //move head one more step
        }
        return dummy.next;
    }
}
