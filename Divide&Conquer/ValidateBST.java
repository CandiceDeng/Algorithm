// Validate Binary Search Tree

// Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
// Example 1:

// Input:
//     2
//    / \
//   1   3
// Output: true
// Example 2:

//     5
//    / \
//   1   4
//      / \
//     3   6
// Output: false
// Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
//              is 5 but its right child's value is 4.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class ResultType{
    boolean is_bst;
    double min_value, max_value;
    ResultType(boolean is_bst, double max_value, double min_value){
        this.is_bst = is_bst;
        this.max_value = max_value;
        this.min_value = min_value;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        ResultType result = Helper(root);
        return result.is_bst;
        
    }
    
    private ResultType Helper(TreeNode root){
        if (root==null){
            return new ResultType(true, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        }
        
        ResultType left=Helper(root.left);
        ResultType right=Helper(root.right);
        
        if (!left.is_bst||!right.is_bst){
            return new ResultType(false,0,0);
        }
        if (left!=null&&left.max_value>=root.val||
          right!=null&&right.min_value<=root.val){
            return new ResultType(false,0,0);
        }
        return new ResultType(true, Math.max(root.val, right.max_value),
                             Math.min(root.val, left.min_value));
    }
}