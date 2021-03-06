207. Course Schedule
Total Accepted: 30427 Total Submissions: 118927 Difficulty: Medium

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]

There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]

There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.
Hints:

    This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
    Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
    Topological sort could also be done via BFS.


public class Solution {
public boolean canFinish(int numCourses, int[][] prerequisites) {
    //track[] is an DP; although recursion, it is time O(numCOurses); as if visited, it will not be vistied again, it will return as track[i] = 2; so every point will be visted only once
    List<List<Integer>> courses=new ArrayList<List<Integer>>();
    for (int i = 0; i < numCourses; i++){
       courses.add(i, new ArrayList<Integer>());
    }
    for (int i = 0; i < prerequisites.length; i++){ //some courses[i] will be empty meaning no prerequest for it
       courses.get(prerequisites[i][0]).add(prerequisites[i][1]);
    }
    int[] track = new int[numCourses]; 
    for (int i = 0; i < numCourses; i++){
       if (!dfs(courses, i, track)) return false;
    }
    return true;
}

private boolean dfs(List<List<Integer>> courses, int start, int[] track){
    if (track[start] == 2) return true; //==2 means either no prerequest or from start point going down all the road no cycle detected //this maks O(N)
    if (track[start] == 1) return false; //loop ditected; as this is the 2nd time visiting an under-exploring point
    //if track[start == 0]
    track[start] = 1; //if first time visit, mark it as under explored
    for (int i = 0; i < courses.get(start).size(); i++){ //walk from all courses which needs a prerequest
       if (!dfs(courses, courses.get(start).get(i), track)) return false;
    }
    track[start] = 2; //point cleared; no cycle or no prerequest for start point
    return true;
}
}





 
