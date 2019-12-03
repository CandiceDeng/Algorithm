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
 
class ResultType {
    int sum;
    int size;
    public ResultType(int sum, int size){
        this.sum = sum;
        this.size = size;
    }
}

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    private TreeNode maxSubtree = null;
    private ResultType subtreeResult = new ResultType(0,0);
    
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        FindMaximum(root);
        return maxSubtree;
    }
    private ResultType FindMaximum(TreeNode root){
        if (root==null){
            return new ResultType(0,0);
        }
        ResultType left = FindMaximum(root.left);
        ResultType right = FindMaximum(root.right);
        
        ResultType result = new ResultType(left.sum+right.sum+root.val,
                                           left.size+right.size+1);
                                           
        if (maxSubtree==null||result.sum*subtreeResult.size>result.size*subtreeResult.sum){
            subtreeResult = result;
            maxSubtree = root;
        }
        return result;
    }
}