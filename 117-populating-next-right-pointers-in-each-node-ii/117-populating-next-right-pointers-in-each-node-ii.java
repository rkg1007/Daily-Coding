/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    
    public void connect(LinkedList<Node> nextLevel, Node nextNode) {
        if (nextLevel.size() > 0) {
            Node prevNode = nextLevel.getLast();
            prevNode.next = nextNode;
        }
    }
    
    public Node connect(Node root) {
        if (root == null) return root;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            LinkedList<Node> nextLevel = new LinkedList<>();
            while (queue.size() != 0) {
                Node currNode = queue.poll();
                if (currNode.left != null) {
                    connect(nextLevel, currNode.left);
                    nextLevel.add(currNode.left);
                }
                if (currNode.right != null) {
                    connect(nextLevel, currNode.right);
                    nextLevel.add(currNode.right);
                }
            }
            queue = nextLevel;
        }
        return root;
    }
}