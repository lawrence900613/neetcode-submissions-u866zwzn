/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<Node, Node>(); 
        if (head == null) {
            return null;
        } 
        Node dummy = new Node(0);
        Node current = new Node(head.val);
        dummy.next = current;
        map.put(head, current);
        Node head2 = head;
        head2 = head2.next;

        while(head2 != null) {
            Node copy = new Node(head2.val);
            current.next = copy;
            current = current.next;
            map.put(head2, current);
            head2 = head2.next;
        }

        current = dummy.next;
        while(head != null) {
            if (head.random != null) {
                current.random = map.get(head.random);
            } 
            current = current.next;
            head = head.next;
        }
        return dummy.next;

    }
}
