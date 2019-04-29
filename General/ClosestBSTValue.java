// Closest Binary Search Tree Value

// Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

// Example
// Example1

// Input: root = {5,4,9,2,#,8,10} and target = 6.124780
// Output: 5
// Example2

// Input: root = {3,2,4,1} and target = 4.142857
// Output: 4
// Notice
// Given target value is a floating point.
// You are guaranteed to have only one unique value in the BST that is closest to the target.

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
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        int result=root.val;
        while (root!=null){
            if (Math.abs(target-root.val)<Math.abs(target-result)){
                result=root.val;
            }
            root=target<root.val?root.left : root.right;
        }
        return result;
    }
}

//O(logN)