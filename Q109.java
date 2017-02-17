Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {

















        //idea is to find middle using fast and slow two runners; then connect each of middle
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPre = head; //this the previous slow node; used to cut off
        while (fast != null && fast.next != null){
           fast = fast.next.next;
           slowPre = slow;
           slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        TreeNode right = sortedListToBST(slow.next);
        slowPre.next = null; //used to cut off
        TreeNode left = null;
        if (head != slow){  //has to have it; if head == slow and keep doing sorted(head) will be a infinite loop
           left = sortedListToBST(head);
        }
        root.right = right;
        root.left = left;
        return root;
    }
}
