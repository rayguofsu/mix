// Implement the following operations of a stack using queues.
//
//    push(x) -- Push element x onto stack.
//    pop() -- Removes the element on top of the stack.
//    top() -- Get the top element.
//    empty() -- Return whether the stack is empty.
//
//Notes:
//
//    You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
//    Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
//    You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
//
class MyStack {
    //the goal is to always keep an empty queue after pop and top; and currentQ will point at the non-empty queque
    Queue<Integer>[] q;
    //Queue<Integer>[] q = new LinkedList<Integer>()[2];
    private int currentQ = 0;
    public MyStack(){
        //has to be like below; cannot have the commented line only
        q = new LinkedList[2];
//       q = new LinkedList<Integer>()[2];  
       q[0] = new LinkedList<Integer>();
       q[1] = new LinkedList<Integer>();
    }

    // Push element x onto stack.
    public void push(int x) {
      q[currentQ].add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
       while(q[currentQ].size() > 1){
          q[currentQ ^ 1].add(q[currentQ].poll());
       }
       q[currentQ].poll(); //here, size == 1; after poll, size ==0
       currentQ ^= 1; //update q index
    }

    // Get the top element.
    public int top() {
       while(q[currentQ].size() > 1){
          q[currentQ ^ 1].add(q[currentQ].poll());
       }
       int top = q[currentQ].peek(); //size==1 here
       q[currentQ ^ 1].add(q[currentQ].poll());  //after this, size==0
       currentQ ^= 1; //update q index
       return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q[currentQ].isEmpty() && q[currentQ ^ 1].isEmpty();
       //return q[1].isEmpty() && q[0].isEmpty();

    }
}
