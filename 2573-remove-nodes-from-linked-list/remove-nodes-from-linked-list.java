/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while( curr != null ) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        if( head == null ) return null;
        
        head = reverseLL(head);
        
        ListNode temp = head;
        while( temp.next != null ) {
            if( temp.val > temp.next.val ) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return reverseLL(head);
    }
}