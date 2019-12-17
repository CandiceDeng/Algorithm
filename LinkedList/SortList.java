// Sort List

// Sort a linked list in O(n log n) time using constant space complexity.

// Example 1:

// Input: 4->2->1->3
// Output: 1->2->3->4
// Example 2:

// Input: -1->5->3->4->0
// Output: -1->0->3->4->5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        //MergeSort O(nlogn)
        if (head==null||head.next==null){
            return head;
        }
        ListNode mid = divideList(head);
        ListNode rightSide = sortList(mid.next);
        mid.next = null; //To fully guarantee leftSide and rightSide are two different Linked Lists
        ListNode leftSide = sortList(head);
        return mergeSort(leftSide,rightSide); 
    }
    private ListNode divideList(ListNode head){
        ListNode fast = head.next, slow = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode mergeSort(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode sortedList = dummy;
        while (head1!=null&&head2!=null){
            if (head1.val<head2.val){
                sortedList.next = head1;
                head1 = head1.next;
            }else{
                sortedList.next = head2;
                head2 = head2.next;
            }
            sortedList = sortedList.next;
        }
        if (head1!=null){
            sortedList.next = head1;
        }else{
            sortedList.next = head2;
        }
        return dummy.next;
    }
}