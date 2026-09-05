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

    class Info {
        int min;
        int max;
        int sum;
        boolean isBST;

        Info(int min, int max, int sum, boolean isBST) {
            this.min = min;
            this.max = max;
            this.sum = sum;
            this.isBST = isBST;
        }
    }

    int maxSum = 0;

    Info helper(TreeNode root) {

        // Empty tree is a BST
        if (root == null) {
            return new Info(
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                0,
                true
            );
        }

        Info left = helper(root.left);
        Info right = helper(root.right);

        // Current subtree is BST if:
        // left subtree is BST
        // right subtree is BST
        // root > maximum of left
        // root < minimum of right
        if (left.isBST && right.isBST &&
            root.val > left.max &&
            root.val < right.min) {

            int currMin = Math.min(root.val, left.min);
            int currMax = Math.max(root.val, right.max);

            int currSum = left.sum + right.sum + root.val;

            // Update global maximum
            maxSum = Math.max(maxSum, currSum);

            return new Info(
                currMin,
                currMax,
                currSum,
                true
            );
        }

        // Not a BST
        return new Info(
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            0,
            false
        );
    }

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }
}