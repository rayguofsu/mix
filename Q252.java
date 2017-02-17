Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false. 

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        for (int i = 1; i < intervals.length; i++){
             if (intervals[i].start-intervals[i-1].end < 0) return false;
        }
        /*
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(5, new Comparator<Integer>(){
           //@Override it seems having this one or not does not matter a lot, but it may gives more useful info if having it.
           public int compare(Integer a, Integer b){
               return b- a;
           }
        });
        minHeap.offer(2);
               minHeap.offer(1);
                      minHeap.offer(5);
        System.out.println(minHeap.poll());
                System.out.println(minHeap.poll());
                        System.out.println(minHeap.poll());
                        
                        Set<Integer> set = new HashSet<>();
                        set.add(1);
                        set.add(2);
                        set.add(3);
                        //FOR HASHMAP; JUST ITERATOR THROUGH map.keySet() for (String key : map.keySet()) {
                        Iterator itr = set.iterator();
                        while(itr.hasNext()){
                            System.out.println(itr.next());
                        }
                        Integer a  = 1;
                        int b = 2;
                        a = b;
                        System.out.println("b is " + b + " a is " + a);
                        b = a;
                        System.out.println("b is " + b + " a is " + a);
                        */

                        
        return true;
    }
}
