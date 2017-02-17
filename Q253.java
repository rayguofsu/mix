253. Meeting Rooms II

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2. 

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
    public int minMeetingRooms(Interval[] intervals) {
        //Just want to share another idea that uses min heap, average time complexity is O(nlogn).
        if (intervals == null || intervals.length == 0) return 0;
        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>(){
            //@Override? has it or not does not matter; if new obj just do not add it I think
           // @Override
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        // Use a min heap to track the smallest end time of intervals
        PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
          // @Override
           public int compare(Interval a, Interval b){
               return a.end - b.end;
           } 
        });
        minHeap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++){
             // get the meeting room that finishes earliest
            Interval firstFinish = minHeap.poll();
            if (firstFinish.end<=intervals[i].start){
                //if current meeting start after it ends; just use the same room by removing the one which ends and save current
                firstFinish = intervals[i];
            }
            else{//otherwise, when it overlap, we need another room; so add it into minHeap
                minHeap.offer(intervals[i]);
            }
            //adding the meeting room back to minHeap
            minHeap.offer(firstFinish);
        }
        
        return minHeap.size();
        
    }
}
