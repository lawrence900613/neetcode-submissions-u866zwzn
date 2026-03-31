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
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!stack.isEmpty()) {
            curr.next = stack.remove(0);
            curr = curr.next;
            if (!stack.isEmpty()) {
                curr.next = stack.pop();
                curr = curr.next;
            }
        }
        curr.next = null;
    }
}
