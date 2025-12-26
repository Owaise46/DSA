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
    public TreeNode buildTree(int il, int ih, int pl, int ph, int inorder[], int preorder[]){
        if(pl>ph) return null;
        int val=preorder[pl];
        TreeNode root=new TreeNode(val);
        int r=0;
        for(int i=il;i<=ih;i++){
            if(val==inorder[i]){
                r=i;
                break;
            }
        }
        int c=r-il;
        root.left=buildTree(il, r-1, pl+1, pl+c, inorder, preorder);
        root.right=buildTree(r+1, ih, pl+c+1, ph, inorder, preorder);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return buildTree(0, n-1, 0, n-1, inorder, preorder); 
    }
}
