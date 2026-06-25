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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        // find the middle element
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // merge the node
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tempOne = first.next;
            ListNode tempTwo = second.next;
            first.next = second;
            second.next = tempOne;
            first = tempOne;
            second = tempTwo;
        }
    }
}
