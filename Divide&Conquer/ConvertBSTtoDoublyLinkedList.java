// Convert Binary Tree to Doubly Linked List

// Convert a binary tree to doubly linked list with in-order traversal.

// Example
// Example 1：

// Input:
// 	    4
// 	   / \
// 	  2   5
// 	 / \
// 	1   3		

// Output: 1<->2<->3<->4<->5
// Example 2：

// Input:
// 	    3
// 	   / \
// 	  4   1

// Output:4<->3<->1

/**
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * } * Definition of TreeNode:
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
    DoublyListNode first;
    DoublyListNode last;
    public ResultType(DoublyListNode first,DoublyListNode last){
        this.first = first;
        this.last = last;
    }
}

public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        if (root==null){
            return null;
        } //Boundary to avoid {}, which means no "result.first"
        ResultType result = ConvertBST(root);
        return result.first;
    }
    private ResultType ConvertBST(TreeNode root){
        ResultType result = new ResultType(null,null);
        if (root==null){
            return null;
        }
        ResultType left = ConvertBST(root.left);
        ResultType right = ConvertBST(root.right);
        DoublyListNode node = new DoublyListNode(root.val);
        
        if (left==null){
            result.first = node;
        }else{
            result.first = left.first;
            left.last.next = node;
            node.prev = left.last;
        }
        if (right==null){
            result.last = node;
        }else{
            result.last = right.last;
            right.first.prev = node;
            node.next = right.first;
        }
        return result;
    }
}