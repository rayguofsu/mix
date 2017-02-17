210. Course Schedule II
Total Accepted: 24270 Total Submissions: 115798 Difficulty: Medium

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]

There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]

There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.
Hints:

    This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
    Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
    Topological sort could also be done via BFS.

public class Solution {
//To keep the dfs algorithm from loop, I used 0, 1, 2 to represent the states of "unvisited", "visiting", "visited", respectively.
public int[] findOrder(int numCourses, int[][] prerequisites) {
    //track[] is an DP; although recursion, it is time O(numCOurses); as if visited, it will not be vistied again, it will return as track[i] = 2; so every point will be visted only once
    List<List<Integer>> courses=new ArrayList<List<Integer>>();
    for (int i = 0; i < numCourses; i++){
       courses.add(i, new ArrayList<Integer>());
    }
    for (int i = 0; i < prerequisites.length; i++){ //some courses[i] will be empty meaning no prerequest for it
       courses.get(prerequisites[i][0]).add(prerequisites[i][1]);
    }
    int[] track = new int[numCourses];
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < numCourses; i++){
       if (!dfs(courses, i, track, res)) return new int[0];
    }
    int[] result = new int[res.size()];
    for (int i = 0; i < res.size(); i++){
        result[i] = res.get(i);
    }
    return result;
}

private boolean dfs(List<List<Integer>> courses, int start, int[] track, List<Integer> res){
    if (track[start] == 2) return true; //==2 means either no prerequest or from start point going down all the road no cycle detected
    if (track[start] == 1) return false; //loop ditected; as this is the 2nd time visiting an under-exploring point
    //if track[start == 0]
    track[start] = 1; //if first time visit, mark it as under explored
    for (int i = 0; i < courses.get(start).size(); i++){ //walk from all courses which needs a prerequest
       if (!dfs(courses, courses.get(start).get(i), track, res)) return false;
    }
    track[start] = 2; //point cleared; no cycle or no prerequest for start point
    res.add(start);
    return true;
}

/*public int[] findOrder(int numCourses, int[][] prerequisites) {
    List[] course=new List[numCourses];
    int[] map=new int[numCourses];
    List<Integer> ans=new ArrayList<Integer>();
    
    for(int i=0;i<numCourses;i++)
    course[i]=new ArrayList<Integer>();
    
    for(int i=0;i<prerequisites.length;i++)
    course[prerequisites[i][0]].add(prerequisites[i][1]);
    
    for(int i=0;i<numCourses;i++)
    if(dfs(course,i,ans,map)==false) return new int[0];
    
    int[] an=new int[ans.size()];
    
    for(int i=0;i<ans.size();i++)
    an[i]=ans.get(i);
    return an;
}
public boolean dfs(List[] course,int req,List<Integer> ans,int[] map){
    if(map[req]==0){
        map[req]=1;
        for(int i=0;i<course[req].size();i++) 
        if(dfs(course,(int)course[req].get(i),ans,map)==false) return false;
        map[req]=2;
    } 
    else if(map[req]==1) return false;
    else if(map[req]==2) return true;
    ans.add(req);
    return true;
}
*/
}


