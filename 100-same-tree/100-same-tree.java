/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if ((p == null) != (q == null)) return false;
        
        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();
        
        stk1.push(p);
        stk2.push(q);
        
        while (!stk1.empty() && !stk2.empty()) {
            TreeNode node1 = stk1.pop();
            TreeNode node2 = stk2.pop();
            
            if (node1.val != node2.val) return false;
            
            if ((node1.left == null) != (node2.left == null)) return false;
            if (node1.left != null) {
                stk1.push(node1.left);
                stk2.push(node2.left);
            }
            
            if ((node1.right == null) != (node2.right == null)) return false;
            if (node1.right != null) {
                stk1.push(node1.right);
                stk2.push(node2.right);
            }
        }
        
        return true;
    }
}