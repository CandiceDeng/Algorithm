// 133. Clone Graph

// Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

 

// Example:



// Input:
// {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

// Explanation:
// Node 1's value is 1, and it has two neighbors: Node 2 and 4.
// Node 2's value is 2, and it has two neighbors: Node 1 and 3.
// Node 3's value is 3, and it has two neighbors: Node 2 and 4.
// Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 

// Note:

// The number of nodes will be between 1 and 100.
// The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
// Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
// You must return the copy of the given node as a reference to the cloned graph.

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node==null){
            return node;
        }
        
        //1. Traverse the graph to get all nodes
        List<Node> nodes = getnodes(node);
        
        //2. Copy all nodes
        HashMap<Node, Node> mapping = new HashMap<>();
        for (Node n:nodes){
            mapping.put(n, new Node(n.val, new ArrayList<>()));
        }
        
        //3. Copy all edges
        for (Node n:nodes){
            Node newNode = mapping.get(n);
            for (Node neighbor:n.neighbors){
                Node newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return mapping.get(node);
        
    }
    
    private List<Node> getnodes(Node node){
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()){
            Node head = queue.poll();
            for (Node neighbor:head.neighbors){
                if (set.contains(neighbor)){
                    continue;
                }
                set.add(neighbor);
                queue.offer(neighbor);
            }
        }
        return new ArrayList<Node>(set);
    }
}