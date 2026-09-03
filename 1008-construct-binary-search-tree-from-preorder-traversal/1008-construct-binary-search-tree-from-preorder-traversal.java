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
    int indx;
    public TreeNode bstFromPreorder(int[] preorder) {

        return build(preorder,Integer.MAX_VALUE);
    }
        private TreeNode build(int []preorder,int bound)
        {
            if(indx == preorder.length || preorder[indx] > bound)
            {
                return null;
            }
   
            TreeNode root = new TreeNode(preorder[indx++]);

            root.left = build(preorder,root.val);
            root.right = build(preorder,bound);

            return root;
        }
}