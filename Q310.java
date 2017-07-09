//310. Minimum Height Trees
//Total Accepted: 6186 Total Submissions: 24314 Difficulty: Medium
//
//For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
//
//Format
//The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
//
//You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
//
//Example 1:
//
//Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
//
//        0
//        |
//        1
//       / \
//      2   3
//
//return [1]
//
//Example 2:
//
//Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
//
//     0  1  2
//      \ | /
//        3
//        |
//        4
//        |
//        5
//
//return [3, 4]
//
//Hint:
//
//    How many MHTs can a graph have at most?
//
//Note:
//
//(1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
//
//(2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf. 
//


public class Solution {
    //On line solution The idea is to layer by layer BFS from the leaf nodes. The last one or two nodes would be the center
  public List<Integer> findMinHeightTrees(int n, int[][] edges) { 








    Set<Integer> res = new HashSet<>();
    Set<Integer>[] adj = (Set<Integer>[]) new HashSet[n];  //remember it
    for (int i = 0; i < n; i++){
      res.add(i);
      adj[i] = new HashSet<>(); //remember it ; for vector, it has to be re-defined again
    }
    for (int i = 0; i < edges.length; i++){
      int from = edges[i][0];
      int to = edges[i][1];
      adj[from].add(to);
      adj[to].add(from);
    }
    Set<Integer> leaf = new HashSet<>();
    while (res.size() > 2){
        //adding leafs;
        for (int v: res){
           if (adj[v].size() == 1){
              leaf.add(v);
           }
        }
        //removing leafs
        res.removeAll(leaf);

        //disconnecting leafs from graph
        for (int v: leaf){
           int adjacent = adj[v].iterator().next(); //remember it
           adj[adjacent].remove(v); //feeling that cannot use list, as list.remove has two def, i.e. 1). remove(int pos) 2). remove(object)
        }
        leaf.clear(); //remember it
     }
     return new ArrayList<>(res); //remember it
  }
}


//My solution
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1){
            res.add(0);
            return res;
        }
        if (edges == null || edges.length ==0 || edges[0] == null || edges[0].length == 0) return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++){
            List<Integer> l1 = map.getOrDefault(edges[i][0], new ArrayList<>());
            l1.add(edges[i][1]);
            map.put(edges[i][0], l1);
            List<Integer> l2 = map.getOrDefault(edges[i][1], new ArrayList<>());
            l2.add(edges[i][0]);
            map.put(edges[i][1], l2);           
        }
        Set<Integer> leaf = new HashSet<>();
        while(map.size() > 2){
            for (int key: map.keySet()){
                List<Integer> l = map.get(key);
                if (l.size() == 1){
                    leaf.add(key);
                    //map.remove remember is wrong here; it cause concurrentmodifiy error as iteratting map
                } 
            }
            for (int key: leaf){
                System.out.println(key);
                int end = map.get(key).get(0);
                System.out.println(key + " " + end);
                //remember below
                map.get(end).remove((Integer) key);
                map.remove(key);
            }
            leaf.clear(); //remember this.
        }
        for (int key: map.keySet()){
            res.add(key);
        }  
        return res;
    }
}


/*
public class HashSetDemo {
   public static void main(String args[]) {
   // create hash set
   HashSet <String> newset = new HashSet <String>();
                  
   // populate hash set
   newset.add("Learning"); 
   newset.add("Easy");
   newset.add("Simply");  
      
   // create an iterator
   Iterator iterator = newset.iterator(); 
      
   // check values
   while (iterator.hasNext()){
   System.out.println("Value: "+iterator.next() + " ");  
   }
   }    
}

Let us compile and run the above program, this will produce the following result.

Value: Learning 
Value: Simply 
Value: Easy
*/

T
