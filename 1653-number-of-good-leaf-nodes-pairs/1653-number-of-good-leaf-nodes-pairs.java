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
    public int countPairs(TreeNode root, int distance) {
        countPairsHelper(root,distance);
        return ans;
    }
    public int ans  = 0;
    public int[] countPairsHelper(TreeNode root, int distance){
        if(root==null) return new int[distance+1];
        if(root.left == null && root.right == null){
            int res[] = new int[distance+1];
            res[1]++;
            return res;
        }
        int[] left = countPairsHelper(root.left,distance);
        int[] right = countPairsHelper(root.right,distance);
        for(int i=0;i<=distance;i++){
            for(int j=0;j<=distance;j++){
                if(i+j<=distance)
                ans+=left[i]*right[j];
            }
        }
        int res[] = new int[distance+1];
        for(int i=distance-2;i>=0;i--){
            res[i+1] = left[i]+right[i];
        }
        return res;
        
    }
}