// Reverse Nodes in k-Group

// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

// Example:

// Given this linked list: 1->2->3->4->5

// For k = 2, you should return: 2->1->4->3->5

// For k = 3, you should return: 3->2->1->4->5

// Note:

// Only constant extra memory is allowed.
// You may not alter the values in the list's nodes, only nodes itself may be changed.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head; //Connect dummy with Linked List
        ListNode prev = dummy;
        while (prev != null){
            prev = reverseNextList(prev,k);
        }
        return dummy.next;
    }
    //origin: head->[n1->n2->...->nk-1->nk]->nk+1
    //reversed: head->[nk->nk-1->...->n2->n1]->nk+1
    private ListNode reverseNextList(ListNode head, int k){
        //Variables with effect: head, n1, nk, nk+1
        ListNode cur = head;
        ListNode n1 = head.next;
        for (int i=0;i<k;i++){
            cur = cur.next;
            if (cur==null){
                return null;
            }
        }
        ListNode nk = cur;
        ListNode nkNext = cur.next; //Or nk.next
        
        //Reverse a Linked List
        ListNode prev = head;
        cur = head.next;
        while (cur != nkNext){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        //current: head<->[nk->nk-1->...->n2->n1]->nk+1
        head.next = nk;
        n1.next = nkNext;
        return n1;
    }    
}