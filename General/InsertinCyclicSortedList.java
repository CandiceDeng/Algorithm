// Insert into a Cyclic Sorted List

// Given a node from a cyclic linked list which has been sorted, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be any single node in the list. Return the inserted new node.

// Example
// Example 1:

// Input:
// 3->5->1
// 4
// Output:
// 5->1->3->4
// Example 2:

// Input:
// 2->2->2
// 3
// Output:
// 3->2->2->2
// Notice
// 3->5->1 is a cyclic list, so 3 is next node of 1.
// 3->5->1 is same with 5->1->3

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param node: a list node in the list
     * @param x: An integer
     * @return: the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // write your code here
        if (node==null){
            node=new ListNode(x);
            node.next=node;
            return node;
        }
        ListNode head=node;
        while (node.next!=null){
            if (node.val<node.next.val){
                if (node.val<=x&&node.next.val>=x){
                    insertNode(node, x);
                    break;
                }
            }else if (node.val>node.next.val){
                if (x>node.val||x<node.next.val){
                    insertNode(node, x);
                    break;
                }
            }else{
                if (node.next==head){
                    insertNode(node, x);
                    break;
                }
            }
            node=node.next;
        }
        return head;
    }
    private void insertNode(ListNode node, int x){
        ListNode newNode=new ListNode(x);
        newNode.next=node.next;
        node.next=newNode;
    }
}