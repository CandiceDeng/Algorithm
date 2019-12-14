// Reverse Linked List II

// Reverse a linked list from position m to n. Do it in one-pass.

// Note: 1 ≤ m ≤ n ≤ length of list.

// Example:

// Input: 1->2->3->4->5->NULL, m = 2, n = 4
// Output: 1->4->3->2->5->NULL

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n){
            return head;
        }
        if (head==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode realHead = dummy;
//         ListNode cur = dummy;
//         ListNode n1 = null;
//         ListNode n2 = null;
        
//         for (int i=0;i<n;i++){
//             if (i<m-1){
//                 cur = cur.next;
//             }else if (i==m-1){
//                 n1 = cur.next;
//                 n2 = n1.next;
//             }else{
//                 n1.next = n2.next; //Move n1 after n2
//                 n2.next = cur.next; //Put n2 as new head
//                 cur.next = n2; //n2 as a new Node
//                 n2 = n1.next; //Reinitialize n2 to n1.next
//             }
//         } 
        for (int i=1;i<m;i++){
            realHead = realHead.next;
        }
        ListNode cur = realHead.next;
        ListNode prev = null;
        while (cur!=null&&m<=n){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            m++;          
        }
        realHead.next.next = cur;
        realHead.next = prev;
        
        return dummy.next;       
    }
}