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
    public TreeNode constructTree(int[] nums, int left, int right) {
        if (left > right) return null;
        int maxValIdx = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxValIdx]) maxValIdx = i;
        }
        TreeNode root = new TreeNode(nums[maxValIdx]);
        root.left = constructTree(nums, left, maxValIdx - 1);
        root.right = constructTree(nums, maxValIdx + 1, right);
        return root;
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums, 0, nums.length - 1);
    }
}