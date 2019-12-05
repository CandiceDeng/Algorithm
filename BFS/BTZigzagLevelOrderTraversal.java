// Binary Tree Zigzag Level Order Traversal

// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

// Example
// Example 1:

// Input:{1,2,3}
// Output:[[1],[3,2]]
// Explanation:
//     1
//    / \
//   2   3
// it will be serialized {1,2,3}
// Example 2:

// Input:{3,9,20,#,#,15,7}
// Output:[[3],[20,9],[15,7]]
// Explanation:
//     3
//    / \
//   9  20
//     /  \
//    15   7
// it will be serialized {3,9,20,#,#,15,7}

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
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = false;
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int curSize = queue.size();
            for (int i=0;i<curSize;i++){
                TreeNode node = queue.poll();
                if (leftToRight){
                    level.add(0,node.val); //add to the top
                }else{
                    level.add(node.val); //add to the bottom
                }
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }

            }
            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;
    }
}