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
    List<TreeNode> sortedArr = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorderTraversal(root);
        return constructTree(0,sortedArr.size()-1);
    }
    public void inorderTraversal(TreeNode root){
        if(root==null) return;
        inorderTraversal(root.left);
        sortedArr.add(root);
        inorderTraversal(root.right);
    }

     public TreeNode constructTree(int start,int end){
        if(start >end) return null;
        int mid = (start+end)/2;
        TreeNode root = sortedArr.get(mid);
        root.left = constructTree(start,mid-1);
        root.right = constructTree(mid+1,end);
        return root;
    }
}