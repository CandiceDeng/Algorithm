// Course Schedule

// There are a total of n courses you have to take, labeled from 0 to n - 1.

// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

// Example
// Example 1:

// Input: n = 2, prerequisites = [[1,0]] 
// Output: true
// Example 2:

// Input: n = 2, prerequisites = [[1,0],[0,1]] 
// Output: false

public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        // BFS(Topological Sorting)
        if (numCourses==0){
            return true;
        }
        ArrayList<Integer>[] preCourse = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i=0;i<numCourses;i++){
            preCourse[i] = new ArrayList<Integer>();
        }
        for (int i=0;i<prerequisites.length;i++){
            preCourse[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<inDegree.length;i++){
            if (inDegree[i]==0){
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            count++;
            int size = preCourse[course].size();
            for (int i=0;i<size;i++){
                inDegree[preCourse[course].get(i)]--;
                if (inDegree[preCourse[course].get(i)]==0){
                    queue.offer(preCourse[course].get(i));
                }
            }
            
        }
        return numCourses==count;
    }
}