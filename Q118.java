118. Pascal's Triangle
Total Accepted: 73364 Total Submissions: 226510 Difficulty: Easy

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
import java.util.Arrays;
public class Solution {
    public List<List<Integer>> generate(int numRows) {



















        //tried to use clone, but it seems not working for list<integer>;
        //clone has to be arraylist<Integer> a = (ArrayList<Integer) b.clone();
       //can use a = new ArrayList<>(b) to make a shallow copy of b
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0) return result;
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        result.add(pre);
        for (int i = 1; i < numRows; i++){
            //below is necessary; meaning gen a new next;
            //if you copy next = pre; then edit on next; pre will be modified; java is pass by ref
            List<Integer> next = new ArrayList<Integer>();
            next.add(1);
            for (int j = 1; j < pre.size(); j++){
                next.add(j, pre.get(j) + pre.get(j - 1));
            }
            next.add(1);
            result.add(next);
            pre = next;
        }
        return result;
    }
}
