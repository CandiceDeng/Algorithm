// Topological Sorting

// Given an directed graph, a topological order of the graph nodes is defined as follow:

// For each directed edge A -> B in graph, A must before B in the order list.
// The first node in the order can be any node in the graph with no nodes direct to it.
// Find any topological order for the given graph.

// Example
// For graph as follow:

// GRAPH

// The topological order can be:

// [0, 1, 2, 3, 4, 5]
// [0, 2, 3, 1, 5, 4]
// ...
// Challenge
// Can you do it in both BFS and DFS?

// Clarification
// Learn more about representation of graphs

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        Map<DirectedGraphNode,Integer> inDegree = new HashMap<>();
        
        for (DirectedGraphNode node: graph){
            for (DirectedGraphNode neighbor : node.neighbors){
                if (!inDegree.containsKey(neighbor)){
                    inDegree.put(neighbor,1); //"node" is its inDegree
                }
                inDegree.put(neighbor,inDegree.get(neighbor)+1);
            }
        }
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph){
            if (!inDegree.containsKey(node)){
                queue.offer(node); //Offer nodes with 0 inDegree;
            }
        }
        int count = 0;
        while (!queue.isEmpty()){
            DirectedGraphNode vertex = queue.poll();
            result.add(vertex);
            count++;
            for (DirectedGraphNode neighbor : vertex.neighbors){
                inDegree.put(neighbor,inDegree.get(neighbor)-1);
                if (inDegree.get(neighbor)==0){
                    queue.offer(neighbor);
                }
            }
        }
        if (count==graph.size()){
            return result;
        }
        return new ArrayList<DirectedGraphNode>(0);
    }
    
}