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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> currLevelNodes = new ArrayDeque<>();
        if (root != null) currLevelNodes.offer(root);
        while (!currLevelNodes.isEmpty()) {
            List<Integer> currLevelVals = new ArrayList<>();
            Queue<TreeNode> nextLevelNodes = new ArrayDeque<>();
            while (!currLevelNodes.isEmpty()) {
                TreeNode currNode = currLevelNodes.poll();
                currLevelVals.add(currNode.val);
                if (currNode.left != null) nextLevelNodes.offer(currNode.left);
                if (currNode.right != null) nextLevelNodes.offer(currNode.right);
            }
            res.add(currLevelVals);
            currLevelNodes = nextLevelNodes;
        }
        return res;
    }
}