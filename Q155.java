155. Min Stack
Total Accepted: 61565 Total Submissions: 286408 Difficulty: Easy

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

class MinStack {
    //no need to set it as public
    //same idea as cc150; but using linkedlist to implement stack




    class Node{
        int val;
        int min;
        Node(int val, int min){
            this.val = val;
            this.min = min;
        }
        Node next;
    }
    Node head;
    public void push(int x) {
        if (head == null){
            head = new Node (x, x);
        }
        else{
            Node n = new Node (x, Math.min(x, head.min));
            n.next = head;
            head = n;
        }
    }

    public void pop() {
        if (head != null){
            head = head.next;
        }
    }

    public int top() {
        if (head != null){
            return head.val;
        }
        return 0;
    }

    public int getMin() {
        if (head != null){
            return head.min;
        }
        return 0;
    }
}

