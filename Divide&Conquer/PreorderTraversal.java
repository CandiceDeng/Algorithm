// 144. Binary Tree Preorder Traversal

// Given a binary tree, return the preorder traversal of its nodes' values.

// Example:

// Input: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3

// Output: [1,2,3]
// Follow up: Recursive solution is trivial, could you do it iteratively?

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
    public List<Integer> preorderTraversal(TreeNode root) {
        //Recursion
        // List<Integer> result=new ArrayList<Integer>();
        // if (root==null){
        //     return result;
        // }
        // List<Integer> left=preorderTraversal(root.left);
        // List<Integer> right=preorderTraversal(root.right);
        // result.add(root.val);
        // result.addAll(left);
        // result.addAll(right);
        // return result;
        
        //Non-recursion
        List<Integer> result=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        if (root==null){
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            result.add(node.val);
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }
        return result;
    }
}