// Binary Tree Inorder Traversal

// Given a binary tree, return the inorder traversal of its nodes' values.

// Example:

// Input: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3

// Output: [1,3,2]

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        
        while (cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            node=node.right;
            
            while (node!=null){
                stack.push(node);
                node=node.left;
            }
        }
        return result;
            
    }
}