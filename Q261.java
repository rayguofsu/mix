261. Graph Valid Tree

 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

    Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
    According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

    Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
    According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

ZZ
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 1) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++){
            List<Integer> left = map.get(edges[i][0]);
            List<Integer> right = map.get(edges[i][1]);
            if (left == null) {
                left = new ArrayList<>();
                map.put(edges[i][0], left);
            }
            
            if (right == null) {
                right = new ArrayList<>();
                map.put(edges[i][1], right);
            }
            left.add(edges[i][1]);
            right.add(edges[i][0]);
        }
        int[] path = new int[n];
        boolean loop = dfs(map, path, 0, 0);   //for square question, need to have for loop here also
        if (!loop) return false;
        for (int i = 0; i < n; i++){    //for square question, no need for this part
            if (path[i] != 2) return false;
        }
        return true;
    }
    private boolean dfs(Map<Integer, List<Integer>> map, int[] path, int cur, int prev){
        if (path[cur] == 2) return true;
        if (path[cur] == 1) return false;
        path[cur] = 1;
        List<Integer> edges = map.get(cur);
        if (edges == null){
            path[cur] = 2;
            return true;
        }
        for (int i = 0; i < edges.size(); i++){
            if (edges.get(i) == prev) continue;//this trick is to make sure each edge can be used only once. otherwise, just[1, 2] also not working here, as [1, 2] can be viewed as [2, 1], so cycle detected, if having this line, it will bypass it.
            if (!dfs(map, path, edges.get(i), cur)) return false;
        }
        path[cur] = 2;
        return true;
    }
    
}
