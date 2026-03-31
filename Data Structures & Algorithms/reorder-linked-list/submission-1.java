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
        ListNode fast = head;
        // Get to the medimum
        while(fast.next != null) {
            slow = slow.next;
            if (fast.next.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
        }
        
        //reverse from the medimum
        ListNode prev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode pointer1 = head;
        ListNode pointer2 = prev;
        while(pointer2 != null) {
            ListNode temp = pointer1.next;
            ListNode temp2 = pointer2.next;
            curr.next = pointer1;
            curr = curr.next;
            curr.next = pointer2;
            curr = curr.next;
            curr.next = null;
            pointer1 = temp;
            pointer2 = temp2;
        }
        // 
    }
}


// 0, 1, 2, 3, 4, 5

// 0, 5, 1, 4, 2, 3