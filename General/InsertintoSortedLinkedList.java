// Insert Node in Sorted Linked List

// Insert a node in a sorted linked list.

// Example
// Example 1:

// Input: head = 1->4->6->8->null, val = 5
// Output: 1->4->5->6->8->null
// Example 2:

// Input: head = 1->null, val = 2
// Output: 1->2->null

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
    /**
     * @param head: The head of linked list.
     * @param val: An integer.
     * @return: The head of new linked list.
     */
    public ListNode insertNode(ListNode head, int val) {
        // write your code here
        ListNode node = new ListNode(val);
        if (head==null){
            return node;
        }
        ListNode cur = new ListNode(0);
        cur.next=head;
        head=cur;
        while (cur.next!=null&&cur.next.val<val){
            cur=cur.next;
        }
        node.next=cur.next;
        cur.next=node;
        return head.next;
        
    }
}