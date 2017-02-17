//Write a program to find the node at which the intersection of two singly linked lists begins.
//
//For example, the following two linked lists:
//
//A:          a1 → a2
//                   ↘
//                     c1 → c2 → c3
//                   ↗            
//B:     b1 → b2 → b3
//
//begin to intersect at node c1.
//
//Notes:
//
//    If the two linked lists have no intersection at all, return null.
//    The linked lists must retain their original structure after the function returns.
//    You may assume there are no cycles anywhere in the entire linked structure.
//    Your code should preferably run in O(n) time and use only O(1) memory.
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) {
// *         val = x;
// *         next = null;
// *     }
// * }
// */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       int lengthA = lengthCompute(headA);
       int lengthB = lengthCompute(headB);
       ListNode longNode = lengthA > lengthB ? headA : headB;
       ListNode shortNode = lengthA > lengthB ? headB : headA;
       int lengthDiff = Math.abs(lengthA - lengthB);
       while (lengthDiff-- > 0){
          longNode = longNode.next;
       }
       for (int i = 0; i < Math.min(lengthA, lengthB); i++){  //can use while (long !- short) here
           if (longNode == shortNode) return longNode; //when A == B; it means A/B are the same node
           /*if (shortNode.val != longNode.val){
              result = null;
           }
           else{
              if (result == null){
                 result = shortNode;
              }
           }//the reason why two runner can move simutaneously below is because that they are aligned now;
           //so the merge point if any, has to be at the node with the same index
           */
           longNode = longNode.next;
           shortNode = shortNode.next;
       }
       return null;
    }
    
    private int lengthCompute(ListNode head){
       int length = 0;
       while (head != null){
          length++;
          head = head.next;
       }
       return length;
    }
}

