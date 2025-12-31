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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        // If node value is smaller than low, discard left subtree
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        // If node value is greater than high, discard right subtree
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // Node is within range, trim both subtrees
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
