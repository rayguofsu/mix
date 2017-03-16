Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {//O(k*len*logK: right)
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(1, new Comparator<ListNode>(){
            public int compare(ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        });
        for (ListNode l: lists){
            if (l != null){
           //     System.out.println("haha ffis " + l.val);
                pq.offer(l);
            }
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
           // System.out.println("haha is " + node.val);
            if (node.next != null) pq.offer(node.next);
            tmp.next = node;
            tmp = tmp.next;
        }
        return dummy.next;
    }
}
