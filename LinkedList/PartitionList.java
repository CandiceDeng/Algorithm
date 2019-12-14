// Partition List

// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.

// Example
// Example 1:

// Input:  list = null, x = 0
// Output: null	
// Explanation: The empty list Satisfy the conditions by itself.
// Example 2:

// Input:  list = 1->4->3->2->5->2->null, x = 3
// Output: 1->2->2->4->3->5->null	
// Explanation:  keep the original relative order of the nodes in each of the two partitions.

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
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head==null||head.next==null){
            return head;
        }
        ListNode smallDummy = new ListNode(0);
        ListNode bigDummy = new ListNode(0); //Change of curSmall and curBig will not impact smallDummy.next and bigDummy.next
        ListNode curSmall = smallDummy;
        ListNode curBig = bigDummy;
        
        ListNode cur = head;
        
        while (cur!=null){
            if (cur.val<x){
                curSmall.next = cur;
                curSmall = curSmall.next;
            }else{
                curBig.next = cur;
                curBig = curBig.next;
            }
            cur = cur.next;
        }
        
        curBig.next = null;
        curSmall.next = bigDummy.next;
        
        return smallDummy.next;
    }
}