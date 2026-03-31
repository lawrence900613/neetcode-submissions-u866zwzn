/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node root = new Node(node.val);
        Map<Integer, Node> visited = new HashMap<Integer, Node>();
        visited.put(root.val, root);
        dfs(root, node, visited);
        return root;
    }

    public void dfs(Node nodeCopy, Node node, Map<Integer, Node> visited) {
        for (Node oldNode: node.neighbors) {
            if (visited.containsKey(oldNode.val)) {
                nodeCopy.neighbors.add(visited.get(oldNode.val));
            } else {
                Node newNode = new Node(oldNode.val);
                visited.put(newNode.val, newNode);
                dfs(newNode, oldNode, visited);
                nodeCopy.neighbors.add(newNode);
            }
        }
    }
}