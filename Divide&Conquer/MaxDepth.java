// Maximum Depth of Binary Tree

// Given a binary tree, find its maximum depth.

// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

// Note: A leaf is a node with no children.

// Example:

// Given binary tree [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its depth = 3.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

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
    private int depth;
    public int maxDepth(TreeNode root) {
        //Divide Conquer
        if (root==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1; //plus root level
    }
        
        //Traverse
    //     depth = 0;
    //     traverse(root, 1);
    //     return depth;
    // }
    // private void traverse(TreeNode root, int curDepth){
    //     if (root==null){
    //         return;
    //     }
    //     if (curDepth>depth){
    //         depth = curDepth;
    //     }
    //     traverse(root.left,curDepth+1);
    //     traverse(root.right,curDepth+1);
    // }
}
