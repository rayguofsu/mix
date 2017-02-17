2. Add Two Numbers
//Total Accepted: 131370 Total Submissions: 580453 Difficulty: Medium
//
//You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//Input: (3 -> 4 -> 0) + (6 -> 6 -> 4)
//Output: 9 -> 0 -> 5 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //CC150 Q2.5
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersBackWard(l1, l2, 0);
    }
    private ListNode addTwoNumbersBackWard(ListNode l1, ListNode l2, int carry){
        if (l1 == null && l2 == null && carry == 0) return null;
        int sum = 0;
        if (l1 != null) sum += l1.val;
        if (l2 != null) sum += l2.val;
        sum += carry;
        ListNode node = new ListNode(sum % 10);
        node.next = addTwoNumbersBackWard(l1 == null ? null : l1.next, 
                                          l2 == null ? null : l2.next,
                                          sum / 10);
        return node;
    }
}
