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
    public void getList(ListNode head, ArrayList<Integer> li) {
        if( head == null ) return;

        li.add(head.val);
        getList(head.next, li);
    }
    public void makeList(ListNode head, ArrayList<Integer> li, int idx) {
        if( head == null || idx == li.size() ) {
            return;
        }
        head.val = li.get(idx);
        makeList(head.next, li, ++idx);
    }
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> li = new ArrayList<>();
        getList(head, li);
        Collections.sort(li);
        makeList(head, li, 0);
        return head;
    }
}