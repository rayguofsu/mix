141. Linked List Cycle
Total Accepted: 93194 Total Submissions: 253077 Difficulty: Medium

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        /*
        == checks if two objects have the same address in the memory and for primitive it checks if they have the same value.
        
        equals method on the other hand checks if the two objects which are being compared have an equal value(depending on how ofcourse the equals method has been implemented for the objects. equals method cannot be applied on primitives(which means that if a is a primitive a.equals(someobject) is not allowed, however someobject.equals(a) is allowed).

An example of the equals() method being overriden  (overriden does not necessarily explictie self define what is equal, but for string, itt seems automatically overriden)
String obj1 = new String("xyz");

String obj2 = new String("xyz");

if(obj1.equals(obj2))
   System.out.printlln("obj1 equals obj2 is TRUE");
else
  System.out.println("obj1 equals obj2 is FALSE");

This code will output the following:

obj1 equals obj2 is TRUE

if(obj1 == obj2)
   System.out.printlln("obj1 equals obj2 is TRUE");
else
  System.out.println("obj1 equals obj2 is FALSE");

This code will output the following:

obj1 equals obj2 is FALSE

but for contant string, like String constant1 = "abc"; String constant2 = "abc";
then == and euqals both true


        */
        
        
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast != null && fast == slow){ //if using .equals, then it tells not defined
                return true;
            }
        }
        return false;
    }
}
