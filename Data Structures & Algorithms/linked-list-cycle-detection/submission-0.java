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
    public boolean hasCycle(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            if (stack.contains(head)) {
                return true;
            } else {
                stack.add(head);
                head = head.next;
            }
        }        
        return false;
    }
}
