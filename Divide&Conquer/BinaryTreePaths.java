// Binary Tree Paths

// Given a binary tree, return all root-to-leaf paths.

// Note: A leaf is a node with no children.

// Example:

// Input:

//    1
//  /   \
// 2     3
//  \
//   5

// Output: ["1->2->5", "1->3"]

// Explanation: All root-to-leaf paths are: 1->2->5, 1->3

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root==null){
            return result;
        }
        if (root.left==null && root.right==null){
            result.add(""+root.val);
        }
        
        List<String> leftPath = binaryTreePaths(root.left);
        List<String> rightPath = binaryTreePaths(root.right);
        
        for (String path : leftPath){
            result.add(root.val+"->"+path);
        }
        for (String path : rightPath){
            result.add(root.val+"->"+path);
        }
        return result;
    }
}