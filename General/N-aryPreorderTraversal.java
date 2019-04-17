// 589. N-ary Tree Preorder Traversal

// Given an n-ary tree, return the preorder traversal of its nodes' values.

// For example, given a 3-ary tree:

// Return its preorder traversal as: [1,3,5,6,2,4].


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result=new ArrayList<>();
        helper(root, result);
        return result;        
    }
    
    private void helper(Node root, List<Integer> result){
        if (root==null){
            return;
        }
        
        result.add(root.val);
        if (root.children != null){
            for (Node node:root.children){
                helper(node,result);
            }
        }
        
    }
}