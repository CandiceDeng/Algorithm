// Flatten Binary Tree to Linked List

// Flatten a binary tree to a fake "linked list" in pre-order traversal.

// Here we use the right pointer in TreeNode as the next pointer in ListNode.

// Example
// Example 1:

// Input:{1,2,5,3,4,#,6}
// Output：{1,#,2,#,3,#,4,#,5,#,6}
// Explanation：
//      1
//     / \
//    2   5
//   / \   \
//  3   4   6

// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// Example 2:

// Input:{1}
// Output:{1}
// Explanation：
//          1
//          1
// Challenge
// Do it in-place without any extra memory.

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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        // write your code here
        // Traverse
        // if (root==null){
        //     return;
        // }
        // if (lastNode!=null){
        //     lastNode.left = null;
        //     lastNode.right = root;
        // }
        // lastNode = root;
        // TreeNode right = root.right; //If not set this variable, root.right will change because of in-place reorder
        // flatten(root.left);
        // flatten(right);
        reOrder(root);
    }
    private TreeNode reOrder(TreeNode root){
        if (root==null){
            return null;
        }
        TreeNode left = reOrder(root.left);
        TreeNode right = reOrder(root.right);
        
        if (left!=null){
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (right!=null){
            return right;
        }
        if (left!=null){
            return left;
        }
        return root;
    }
}

