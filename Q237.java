// Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
////Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function. 


//this is the same question as shown in cc150: 2.3

public class Solution {
    public void deleteNode(ListNode node) {
                     //cannot do for tail




















     if (node == null || node.next == null){
         return;
     }
     node.val = node.next.val;
     node.next = node.next.next;
    }
}
