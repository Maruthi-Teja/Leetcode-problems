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
    public int diameterOfBinaryTree(TreeNode root) {
        Depth(root);
        return max;
    }
    public int max1 = 0,max=0;

    public int Depth(TreeNode root){
        if(root==null) return 0;
        int leftDepth = Depth(root.left);
        int rightDepth = Depth(root.right);
        max = Math.max(max,leftDepth+rightDepth);
        return Math.max(leftDepth,rightDepth)+1;
    }
    
}