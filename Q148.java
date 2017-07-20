148. Sort List
Total Accepted: 62803 Total Submissions: 262807 Difficulty: Medium

Sort a linked list in O(n log n) time using constant space complexity.
//use 2nd solution ie. merge sort
public ListNode sortList(ListNode head) {
  //JAVA 5ms Quick Sort //O(n log n) average but O(n^2) worst
  //merge sort is O(n log n) for both average and worst cases
  //so you had better check out merge sort below in 2nd round
   if (head == null || head.next == null) return head;
   ListNode left = new ListNode(0), leftHead = left;
   ListNode right = new ListNode(0), rightHead = right;
   ListNode mid = new ListNode(0), midHead = mid;
   int val = head.val;
   while(head != null){
      if (head.val < val){
         left.next = head;
         left = left.next;
      }
      if (head.val > val){
         right.next = head;
         right = right.next;
      }
      if (head.val == val){
         mid.next = head;
         mid = mid.next;
      }
      head = head.next;
   }
   left.next = null;
   mid.next = null;
   right.next = null;
   return conCat(sortList(leftHead.next), midHead.next, sortList(rightHead.next)); //recursion part here;

}

private ListNode conCat(ListNode left, ListNode mid, ListNode right){
   ListNode leftTail = tail(left);
   ListNode midTail = tail(mid);
   midTail.next = right;
   if (leftTail != null){ //important here also
      leftTail.next = mid;
      return left;
   }
   else{
      return mid;
   }
}

private ListNode tail(ListNode head){
   while (head != null && head.next != null){
      head = head.next;
   }
   return head;
}

   
/*
Java Merge Sort with detailed explanation O(n log n) for average and worst cases
1. Use 2 pointers: fast and slow to divide the list into 2 sublist: list1 and list2 and make sure list1 is equal to or is longer than list2.
The key is the condition of while loop while(fast.next!=null && fast.next.next!=null). After this while loop slow will be at the position of the end of list1.
2. sort list1 and list2
3. merge list1 and list2

public class Solution {
    public ListNode sortList(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode h1=head;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode h2=slow.next;
        slow.next=null;
        h1=sortList(h1);
        h2=sortList(h2);
        return merge(h1,h2);
    }

    public ListNode merge(ListNode h1, ListNode h2){
        ListNode fakeHead = new ListNode(9);
        ListNode cur = fakeHead;
        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                cur.next=h1;
                cur=h1;
                h1=h1.next;
            }else{
                cur.next=h2;
                cur=h2;
                h2=h2.next;
            }
        }
        cur.next=h1==null?h2:h1;
        return fakeHead.next;
    }
}

*/
