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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while( fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow;
        ListNode prev = null;
        ListNode curr = mid;

        while( curr != null ) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        while( prev != null ) {
            if( head.val != prev.val ) {
                return false;
            } else {
                prev = prev.next;
                head = head.next;
            }
        }

        return true;
    }
}