class Solution {

    TreeNode getInorderSuccessor(TreeNode root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        // Key not found
        if (root == null) {
            return null;
        }

        // Search in left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // Search in right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // Found the node
        else {

            // Case 1: No left child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: No right child
            else if (root.right == null) {
                return root.left;
            }

            // Case 3: Both children exist
            else {

                // Find inorder successor
                TreeNode IS = getInorderSuccessor(root.right);

                // Copy successor value
                root.val = IS.val;

                // Delete successor from right subtree
                root.right = deleteNode(root.right, IS.val);
            }
        }

        return root;
    }
}