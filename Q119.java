//Given an index k, return the kth row of the Pascal's triangle.
//
//For example, given k = 3,
//Return [1,3,3,1].
//
//Note:
//Could you optimize your algorithm to use only O(k) extra space? 
//
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
//
public class Solution {
    public List<Integer> getRow(int rowIndex) {//to use bottom up solution



















        List<Integer> result = new ArrayList<Integer>();
        //Base Case
        if (rowIndex == 0){
            //list is an interface, you must be careful about the differencer between add and set
            //set(i, val) is to replace and add(i, val) is to insert
            //(insert (i, val): original val* at i will shift right)
            //add(val) is to append
            //if origianally, list does not have element at i; you cannot use set; have to use add
           result.add(0, 1);
           return result;
        }
       //recursion
        result = getRow(rowIndex - 1);
        int i = 0;
        //re-writting all the previous list except the first entry which is 1, has to use set
        for (i = rowIndex - 1; i >= 1; i--){ //the order from right -> left is important
            //if by order: (i = 1; i < rowIndex) then 
            //the new setted value will be used to generate next new setted val
            //which is wrong
            result.set(i, result.get(i - 1) + result.get(i));
        }
        //add-in new entry at the last for current level
        result.add(rowIndex, 1);
        return result;
    }
}
