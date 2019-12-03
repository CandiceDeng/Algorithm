// Lowest Common Ancestor II

// Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

// The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

// The node has an extra attribute parent which point to the father of itself. The root's parent is null.

// Example
// Example 1:

// Input：{4,3,7,#,#,5,6},3,5
// Output：4
// Explanation：
//      4
//      / \
//     3   7
//        / \
//       5   6
// LCA(3, 5) = 4
// Example 2:

// Input：{4,3,7,#,#,5,6},5,6
// Output：7
// Explanation：
//       4
//      / \
//     3   7
//        / \
//       5   6
// LCA(5, 6) = 7

/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */


public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // Traverse
        if (root==null){
            return null;
        }
        ArrayList<ParentTreeNode> result = new ArrayList<ParentTreeNode>();
        while (A!=null){
            result.add(A);
            A = A.parent;
        }
        while (B!=null){
            if (result.contains(B)){
                return B;
            }
            B = B.parent;
        }
        return null;
    }
}
