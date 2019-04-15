// Verify Preorder Sequence in Binary Search Tree

// Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

// You may assume each number in the sequence is unique.

// Follow up:
// Could you do it using only constant space complexity?

// Example
// Example1

// Input: preorder = [1,3,2]
// Output: true
// Example2

// Input: preorder = [1,2]
// Output: true

public class Solution {
    /**
     * @param preorder: List[int]
     * @return: return a boolean
     */
    public boolean verifyPreorder(int[] preorder) {
        // write your code here
        Stack<Integer> stack=new Stack<>();
        int min=Integer.MIN_VALUE;
        if (preorder.length<=1){
            return true;
        }
        for (int num:preorder){
            if (num<min){return false;}
            while (!stack.isEmpty()&&num>stack.peek()){
                min=stack.pop();
            }
            stack.push(num);
        }
        return true;
    }
}