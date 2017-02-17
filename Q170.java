170. Two Sum III - Data structure design 
\
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,

add(1); add(3); add(5);
find(4) -> true
find(7) -> false



/*	I use HashMap to store times of number be added.

When find be called, we iterate the keys of HashMap, then find another number minus by value.
Then combine the detections together.

Java:
*/

public class TwoSum {
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0)+ 1);
    }

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int i = entry.getKey();
            int j = value - i;
            if ((i == j && entry.getValue() > 1) || (i != j && map.containsKey(j))) {
                return true;
            }
        }
        return false;
    }
}



// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
