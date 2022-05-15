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
    int level;
    int sum;
    
    public void deepestLeavesSum(TreeNode root, int currLevel) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (currLevel == this.level) {
                sum += root.val;
            } else if (currLevel > this.level) {
                this.level = currLevel;
                this.sum = root.val;
            }
            return;
        }
        deepestLeavesSum(root.left, currLevel + 1);
        deepestLeavesSum(root.right, currLevel + 1);
    }
    
    public int deepestLeavesSum(TreeNode root) {
        this.level = -1;
        this.sum = 0;
        deepestLeavesSum(root, 0);
        return this.sum;
    }
}