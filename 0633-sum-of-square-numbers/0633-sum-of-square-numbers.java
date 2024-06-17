class Solution {
    public boolean judgeSquareSum(int c) {
        //binary seach we need to do
        // approach will be search from 1 to c/2 
        // we need to take c2 combinations
        // use two pointer approach
        long left = 0;
        long right = (long)Math.sqrt(c);
        while(left<=right){
            long curr = left*left + right*right;
            if(curr<c){
                left++;
            }else if(curr >c){
                right--;
            }else{
                return true;
            }
        }
        return false;
    }
}