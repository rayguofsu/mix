Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]. 
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2){
                return o1.start - o2.start;
            }
        });
        List<Interval> res = new ArrayList<>();
        Interval prev = null;
        for (Interval cur : intervals){
            if (prev == null || cur.start > prev.end){
                res.add(cur);
                prev = cur;
            }
            else if (cur.end > prev.end){
                prev.end = cur.end;
            }
        }
        return res;
        */
