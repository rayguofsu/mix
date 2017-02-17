163. Missing Ranges

 Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"]. 

public class Solution {     
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {         
        //next is used as a mark here\         
        long next = lower;         
        int[] a = nums;         
        List<String> res = new ArrayList<>();         
        for (int i = 0; i < nums.length; i++){             
            if (next > a[i]) continue;//only needed to move into target range; also can be used to bypass duplicates             
            if (next == a[i]){                 
                next = a[i]+1;
                continue;  
            }            
                //here next < a[i]             
            res.add(getString(next, a[i]-1));            
            next = (long)a[i]+1;
            System.out.println("haha" + next);
        }         
        if (next <= upper){             
            res.add(getString(next, upper));         
        }         
        return res;     
    }     
    private String getString(long lo, long hi){         
        return lo==hi?String.valueOf(lo):String.format("%d->%d", lo, hi);
    } 
    
}
