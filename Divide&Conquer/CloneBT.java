// Clone Binary Tree

// For the given binary tree, return a deep copy of it.

// Example
// Example 1:

// Input: {1,2,3,4,5}
// Output: {1,2,3,4,5}
// Explanation:
// The binary tree is look like this:
//      1
//    /  \
//   2    3
//  / \
// 4   5
// Example 2:

// Input: {1,2,3}
// Output: {1,2,3}
// Explanation:
// The binary tree is look like this:
//    1
//  /  \
// 2    3

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of binary tree
     * @return: root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        // write your code here
        if (root==null){
            return null;
        }
        //Use "new" to achieve deep copy
        TreeNode newTree = new TreeNode(root.val);
        newTree.left = cloneTree(root.left);
        newTree.right = cloneTree(root.right);
        return newTree;
    }
}

