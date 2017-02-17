281. Zigzag Iterator 

 Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]

It should return [1,4,8,2,5,9,3,6,7]. 
//Uses a linkedlist to store the iterators in different vectors. Every time we call next(), we pop an element from //the list, and re-add it to the end to cycle through the lists.
public class ZigzagIterator {
    LinkedList<Iterator> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator>();
        if(!v1.isEmpty()) list.add(v1.iterator());
        if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        //remove the head of linkedlist below
        Iterator<Integer> poll = list.remove(); //or syntax just drop <> here
        int result = poll.next();            //and use (Integer) poll.next()
        if(poll.hasNext()) list.add(poll);  
        //
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}


/*public class ZigzagIterator {//not able to pass due to Iterator array
    private int cur;
    private Iterator<Integer>[] itrs ;
    private List<List<Integer>> list;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new ArrayList<>();
        if (v1 != null && v1.size() != 0)
        list.add(v1);
        if (v2 != null && v2.size() != 0)
        list.add(v2);
        cur = 0;
        itrs = new Iterator<Integer>()[2];
        for (int i = 0; i < list.size(); i++){
            itrs[i] = list.get(i).iterator();
        }
    }

    public int next() {
        int next = itrs[cur].next();
        if (cur == list.size()-1) cur =0;
        else cur++;
        while(!itrs[cur].hasNext()){
            cur++;
            if (cur == list.size()-1) cur =0;
        }
        return next;
    }

    public boolean hasNext() {
        boolean res = false;
        for (int i = 0; i < list.size(); i++){
            res |= itrs[i].hasNext();
        }
        return res;
    }
}
*/

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
public class ZigzagIterator {

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        
    }

    public int next() {
        
    }

    public boolean hasNext() {
        
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
