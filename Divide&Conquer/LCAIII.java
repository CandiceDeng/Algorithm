// Lowest Common Ancestor III

// Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
// The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
// Return null if LCA does not exist.

// Example
// Example1

// Input: 
// {4, 3, 7, #, #, 5, 6}
// 3 5
// 5 6
// 6 7 
// 5 8
// Output: 
// 4
// 7
// 7
// null
// Explanation:
//   4
//  / \
// 3   7
//    / \
//   5   6

// LCA(3, 5) = 4
// LCA(5, 6) = 7
// LCA(6, 7) = 7
// LCA(5, 8) = null

// Example2

// Input:
// {1}
// 1 1
// Output: 
// 1
// Explanation:
// The tree is just a node, whose value is 1.
// Notice
// node A or node B may not exist in tree.
// Each node has a different value

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
class ResultType{
    boolean a_exist;
    boolean b_exist;
    TreeNode lca;
    public ResultType(boolean a_exist,boolean b_exist,TreeNode lca){
        this.a_exist = a_exist;
        this.b_exist = b_exist;
        this.lca = lca;
    }
}

public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResultType result = FindLCA(root,A,B);
        if (result.a_exist&&result.b_exist){
            return result.lca;
        }
        return null;
    }
    private ResultType FindLCA(TreeNode root, TreeNode A, TreeNode B){
        if (root==null){
            return new ResultType(false,false,null);
        }
        ResultType left = FindLCA(root.left,A,B);
        ResultType right = FindLCA(root.right,A,B);
        boolean a_exist = root==A||left.a_exist||right.a_exist;
        boolean b_exist = root==B||left.a_exist||right.b_exist;
        if (root==A||root==B){
            return new ResultType(a_exist,b_exist,root);
        }
        if (left.lca!=null&&right.lca!=null){
            return new ResultType(a_exist,b_exist,root);
        }
        if (left.lca!=null){
            return new ResultType(a_exist,b_exist,left.lca);
        }
        if (right.lca!=null){
            return new ResultType(a_exist,b_exist,right.lca);
        }
        return new ResultType(false,false,null);
    }
}
