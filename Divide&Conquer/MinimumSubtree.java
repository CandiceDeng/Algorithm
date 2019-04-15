// Minimum Subtree

// Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

// Example
// Example 1:

// Input:
//      1
//    /   \
//  -5     2
//  / \   /  \
// 0   2 -4  -5 

// Output:1
// Example 2:

// Input:
//    1
// Output:1

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
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    private TreeNode subtree=null;
    private int subtreeSum=Integer.MAX_VALUE;
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        helper(root);
        return subtree;
    }
    
    private int helper(TreeNode root){
        if (root==null){
            return 0;
        }
        int sum=root.val+helper(root.left)+helper(root.right);
        
        if (sum<subtreeSum){
            subtreeSum=sum;
            subtree=root;
        }
        return sum;  //No matter what is returned, the parameter in use is "subtree"
    }
}