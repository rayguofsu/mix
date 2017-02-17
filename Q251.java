251. Flatten 2D Vector

 Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
public class Vector2D implements Iterator<Integer> {

    public Vector2D(List<List<Integer>> vec2d) {
        
    }

    @Override
    public Integer next() {
        
    }

    @Override
    public boolean hasNext() {
        
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */







Hint:

    How many variables do you need to keep track?
    Two variables is all you need. Try with x and y.
    Beware of empty rows. It could be the first few rows.
    To write correct code, think about the invariant to maintain. What is it?
    The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
    Not sure? Think about how you would implement hasNext(). Which is more complex?
    Common logic in two different places should be refactored into a common method.

Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java. 

Since the OJ does while (i.hasNext()) cout << i.next();, i.e., always calls hasNext before next, I don't really have to call it myself so I could save that line in next. But I think that would be bad, we shouldn't rely on that.

public class Vector2D {

    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public int next() {
        hasNext();
        return j.next();
    }

    public boolean hasNext() {
        while ((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext();
    }
}


/*good solution 
I first hold the 2D List inside a Iterator of List this allows me to operate on the subsequent list once needed. I then remove the first list from the 2D List and store as row which is evaluated when next() & hasNext() are called. I then want to ensure row iterator is pointing to a none empty list so i call the getNextRow() method. next() and hashNext() are now very simple. next() returns the next element of the current list then ensures row isn't empty. hasNext() checks row isn't null and has a next value.

public class Vector2D {
    Iterator<List<Integer>> itrs;
    Iterator<Integer> row;
    public Vector2D(List<List<Integer>> vec2d) {
        if(vec2d == null || vec2d.size() == 0) return;
        itrs = vec2d.iterator();
        row = itrs.next().iterator();
        getNextRow();
    }
    
    private void getNextRow(){
        while(!row.hasNext() && itrs.hasNext()) row = itrs.next().iterator();
    }

    public int next() {
        int next = row.next();
        getNextRow();
        return next;
    }

    public boolean hasNext() {
        return row != null && row.hasNext();
    }
}
*/
