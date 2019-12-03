// Balanced Binary Tree

// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as:

// a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

// Example 1:

// Given the following tree [3,9,20,null,null,15,7]:

//     3
//    / \
//   9  20
//     /  \
//    15   7
// Return true.

// Example 2:

// Given the following tree [1,2,2,3,3,null,null,4,4]:

//        1
//       / \
//      2   2
//     / \
//    3   3
//   / \
//  4   4
// Return false.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ResultType {
    public boolean is_balanced;
    public int maxDepth;
    public ResultType(boolean is_balanced, int maxDepth){
        this.is_balanced = is_balanced;
        this.maxDepth = maxDepth;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return FindDepth(root).is_balanced;   
    }
    
    private ResultType FindDepth(TreeNode root) {
        if (root == null){
            return new ResultType(true,0);
        }
        ResultType left = FindDepth(root.left);
        ResultType right = FindDepth(root.right);
        
        if (!left.is_balanced || !right.is_balanced) {
            return new ResultType(false,-1);
        }
        if (Math.abs(left.maxDepth-right.maxDepth)>1) {
            return new ResultType(false,-1);
        }
        return new ResultType(true, Math.max(left.maxDepth,right.maxDepth)+1);
    }
}