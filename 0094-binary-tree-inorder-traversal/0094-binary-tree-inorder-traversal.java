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

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {

            // Case 1: No left subtree
            if (curr.left == null) {

                ans.add(curr.val);
                curr = curr.right;
            }

            // Case 2: Left subtree exists
            else {

                // Find inorder predecessor
                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                // First time visiting curr
                if (pred.right == null) {

                    // Create thread
                    pred.right = curr;

                    // Move to left subtree
                    curr = curr.left;
                }

                // Left subtree already processed
                else {

                    // Remove thread
                    pred.right = null;

                    // Visit curr
                    ans.add(curr.val);

                    // Move to right subtree
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}