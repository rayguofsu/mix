// Given a linked list, swap every two adjacent nodes and return its head.
//
//For example,
//Given 1->2->3->4, you should return the list as 2->1->4->3.
//
//Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed. 
//

public ListNode swapPairs(ListNode head) {
























   if (head == null || head.next == null) return head; //for empty or one node case
   ListNode newHead = head.next;
   ListNode dummy = new ListNode(0); //adding extra in ordder to access the first
   while (head != null && head.next != null){
      //process the first pair
      dummy.next = head.next;
      head.next = head.next.next;
      dummy.next.next = head;
      //now move dummy and head to their original position to process next pair
      dummy = head;
      head = head.next;
   }
   return newHead;
}

    /*
    public ListNode swapPairs(ListNode head) {//this solution causes Memory Limit Exceeded
        if (head == null || head.next == null) return head; //empty or one node 
        ListNode previous = head;
        ListNode nextLeft = null;
        ListNode newHead = head.next;
        ListNode left = head;
        while (left != null && left.next != null){
            nextLeft = left.next.next;
            previous.next = left.next;
            left.next.next = left;
            previous = left;
            left = nextLeft;
        }
        return newHead;
        
    }
    */
