346. Moving Average from Data Stream

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

public class MovingAverage {//did myself

    /** Initialize your data structure here. */
    private int size;
    private double average;
    private Queue<Integer> que;
    public MovingAverage(int size) {
        average = 0;
        this.size = size;
        que = new LinkedList<>();
    }
    
    public double next(int val) {
        int first = 0;
        int oldSize = que.size();
        if (que.size() == size){
            first = que.poll();
        }
        que.offer(val);
        average = (average * oldSize + val - first) / que.size();
        return average;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
