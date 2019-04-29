// Subtree with Maximum Average

// Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

// Example
// Example 1

// Input：
// {1,-5,11,1,2,4,-2}
// Output：11
// Explanation:
// The tree is look like this:
//      1
//    /   \
//  -5     11
//  / \   /  \
// 1   2 4    -2 
// The average of subtree of 11 is 4.3333, is the maximun.
// Example 2

// Input：
// {1,-5,11}
// Output：11
// Explanation:
//      1
//    /   \
//  -5     11
// The average of subtree of 1,-5,11 is 2.333,-5,11. So the subtree of 11 is the maximun.
// Notice
// LintCode will print the subtree which root is your return node.
// It's guaranteed that there is only one subtree with maximum average.

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
     * @return: the root of the maximum average of subtree
     */
    private class ResultType {
        public int sum, size;
        public ResultType(int sum, int size) {
            this.sum=sum;
            this.size=size;
        }
    }
    TreeNode maxAverageTree=null;
    ResultType subtree=null;
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        helper(root);
        return maxAverageTree;
    }
    private ResultType helper(TreeNode root){
        if (root==null){
            return new ResultType(0,0);
        }
        ResultType Left=helper(root.left);
        ResultType Right=helper(root.right);
        
        ResultType curTree=new ResultType(root.val+Left.sum+Right.sum,
                                          1+Left.size+Right.size);
            
        if (maxAverageTree==null||subtree.sum*curTree.size<subtree.size*curTree.sum){
            maxAverageTree=root;
            subtree=curTree;
        }
        return curTree;
    }
}