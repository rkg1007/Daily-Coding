/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode targetCopy;
    
    public boolean getTarget(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null) return false;
        if (original == target) {
            this.targetCopy = cloned;
            return true;
        }
        
        if (getTarget(original.left, cloned.left, target)) return true;
        if (getTarget(original.right, cloned.right, target)) return true;
        return false;
    }
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.targetCopy = null;
        getTarget(original, cloned, target);
        return this.targetCopy;
    }
}