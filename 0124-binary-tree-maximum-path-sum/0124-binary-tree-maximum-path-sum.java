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

    int maxSum = Integer.MIN_VALUE;

    int helper(TreeNode root) {

        // Base case
        if (root == null) {
            return 0;
        }

        // Maximum contribution from left subtree
        int left = Math.max(0, helper(root.left));

        // Maximum contribution from right subtree
        int right = Math.max(0, helper(root.right));

        // Path passing through current node
        int currSum = root.val + left + right;

        // Update global maximum
        maxSum = Math.max(maxSum, currSum);

        // Return maximum path contribution to parent
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
}