120. Triangle
Total Accepted: 58270 Total Submissions: 202573 Difficulty: Medium

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 




public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //first thinking to do it recursively, then realized that it is easier to do it top -down; so choose to iterative solution
        //so doing it top-down using DP to save previous level sum results O(N)
        //the idea is using sumDP to store so far minSum value including current index entry at current level;
        //the minSum value is the min value between the upper level two adjacent entry sum values plus the current entry
        //but need to store entry0 first and insert it to sumDP later, otherwise will overwritten it; 
        //for last entry using if to special handle
        //in the end need to remove the initilized zero
        //if do not like list.add(0, val) for insert entry at 0 in order to shift, can use array for DP and System.arraycopy to shift index
        if (triangle == null || triangle.size() == 0) return 0;
        if (triangle.size() == 1) return triangle.get(0).get(0); //to make sure for loop is doable
        List<Integer> sumDP= new ArrayList<Integer>();
        int level = 0;
        sumDP.add(0); //for initialization; otherwise, first time line 14 sumDP.get(0) will give error; as does not exist
        while (level < triangle.size()){
           List<Integer> list = triangle.get(level);
           int entryZero = sumDP.get(0) + list.get(0);//for first entry
           for (int i = 1; i < list.size(); i++){
              int tmp;
              if (i == list.size() - 1){ //for last entry on this level
                tmp = sumDP.get(i - 1) + list.get(i);
              }
              else{
                tmp = Math.min(sumDP.get(i - 1), sumDP.get(i)) + list.get(i); //minSum
              }
              sumDP.set(i - 1, tmp);
           }
           sumDP.add(0, entryZero);  //no list.insert, add(int, int) is for list insert
           level++;
        }
        sumDP.remove(sumDP.size() - 1); //this is to remove the initialized zero; otherwise, if all positive, 0 will be returned//Because when j = 0; the forloop will not be triggerred..directly dpSum.add(0, first) will do
        return Collections.min(sumDP); //O(n)
    }
/*Sort the array in either ascending or descending order and pick either the first or last item in the array depending on the order!

Collections.sort(arrayList); // Sort the arraylist
arrayList.get(arrayList.size() - 1); //gets the last item, largest for an ascending sort

@EDIT

IMORTANT: On second thought, you can use the Collections API to achieve what you want easily - read efficiently - enough Javadoc for Collection.max

Collections.max(arrayList);

    Returns the maximum element of the given collection, according to the specified comparator.
*/
}
