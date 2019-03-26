// Graph Valid Tree

// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a 
// function to check whether these edges make up a valid tree.

// Example
// Example 1:

// Input: n = 5 edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
// Output: true.
// Example 2:

// Input: n = 5 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
// Output: false.
// Notice
// You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the 
// same as [1, 0] and thus will not appear together in edges.

public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n==0 || edges.length!=n-1){  //Feature#1 of Tree: n nodes, n-1 edges
            return false;
        }
        Map<Integer, Set<Integer>> graph = initialGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();
        
        queue.offer(0);  //Labeled from 0 to n-1
        hash.add(0);
        while (!queue.isEmpty()){
            Integer node = queue.poll();
            for (int neighbor:graph.get(node)){
                if (hash.contains(neighbor)){
                    continue;
                }
                queue.offer(neighbor);
                hash.add(neighbor);
            }
        }
        return (hash.size()==n);
        
    }
 
    // Save as graph structure
    private Map<Integer, Set<Integer>> initialGraph(int n, int[][] edges){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=0; i<n; i++){
            graph.put(i, new HashSet<Integer>());
        }
        for (int i=0; i<edges.length; i++){
            int x=edges[i][0];
            int y=edges[i][1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        return graph;
    }
}