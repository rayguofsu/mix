323. Number of Connected Components in an Undirected Grappublic class Solution {
 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:

     0          3
     |          |
     1 --- 2    4

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:

     0           4
     |           |
     1 --- 2 --- 3

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

ZZ



/*This is 1D version of Number of Islands II. For more explanations, check out this 2D Solution.

    n points = n islands = n trees = n roots.
    With each edge added, check which island is e[0] or e[1] belonging to.
    If e[0] and e[1] are in same islands, do nothing.
    Otherwise, union two islands, and reduce islands count by 1.
    Bonus: path compression can reduce time by 50%.

Hope it helps!*/

public int countComponents(int n, int[][] edges) {
    int[] roots = new int[n];
    for(int i = 0; i < n; i++) roots[i] = i; 

    for(int[] e : edges) {
        int root1 = find(roots, e[0]);
        int root2 = find(roots, e[1]);
        if(root1 != root2) {      
            roots[root1] = root2;  // union
            n--;
        }
    }
    return n;
}

public int find(int[] roots, int id) {
    while(roots[id] != id) {
        roots[id] = roots[roots[id]];  // optional: path compression
        id = roots[id];
    }
    return id;
}


    
    
    /*
    

Path compression, not pass compression.
about a year ago
0
yavinci
Reputation: 3,181

Haha. Thanks just updated Stefan.
about a year ago
0
Y
Yun.Hu
Reputation: 67

what is the time complexity ? is it O(E*E) ?
10 months ago
2
Ximin.Z
Reputation: 272

The complexity for M quick union + path compression on N objects should be N + MlgN, I think in this problem, M = 2E, N = V, so O(V + 2ElgV), correct me if this is wrong @yavinci
9 months ago
0
B
bluebird
Reputation: 1

@Ximin.Z I am wondering if find() method is O(1) in this case?
3 months ago
0
三
三千世界
Reputation: 218

a smart way of using union found when already know there will n points in total
18 days ago
0
D
dong-fantastic
Reputation: 0

exactly the same idea! union find, a clever and fast processing data structure!
*/







/*union find solution

    private int[] father;
public int countComponents(int n, int[][] edges) {
    
    Set<Integer> set = new HashSet<Integer>();
    father = new int[n];
    for (int i = 0; i < n; i++) {
        father[i] = i;
    }
    for (int i = 0; i < edges.length; i++) {
         union(edges[i][0], edges[i][1]);
    }
    
    for (int i = 0; i < n; i++){ 
        set.add(find(i));
    }
    return set.size();
}

int find(int node) {
    if (father[node] == node) {
        return node;
    }
    father[node] = find(father[node]);
    return father[node];
}

void union(int node1, int node2) {
    father[find(node1)] = find(node2);
}

about a year ago
6
Posts
3.6k
Views
0
S
shalabhvyas
Reputation: 0

How can we determine the complexity of this solution?
11 months ago
0
Y
yunpengw
Reputation: 3

you can find detailed explanation here :
https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf
11 months ago
0
禽
禽兽样
Reputation: 4

No need to use a hashset, every time you use the union function, the number of disjoint components will minus 1.
10 months ago
1
E
epishebe
Reputation: 7

@禽兽样 Not necessarily so. For example, if the components were somehow already connected (components where cycles exist), decreasing the number of components might leave you with 0 components or a negative count.
9 months ago
0
H
hao26
Reputation: 1

I'm not sure. In order to have O(logn) find complexity, doesn't disjoint-set need to keep a depth[] array as well? Always do father[find(node1)] = find(node2) can result in O(n) find complexity.
*/


/*

Java concise DFS
start dfsVisit with sources 0-n-1, count number of unvisited sources.

public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1)
            return n;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited.add(i)) {
                dfsVisit(i, map, visited);
                count++;
            }
        }
        return count;
    }
    
    private void dfsVisit(int i, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        for (int j : map.get(i)) {
            if (visited.add(j))
                dfsVisit(j, map, visited);
        }
    }
}

*/


}h
