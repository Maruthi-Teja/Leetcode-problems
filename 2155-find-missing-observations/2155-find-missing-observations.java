class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        

        int requiredSumOfN = mean*(n+rolls.length) - Arrays.stream(rolls).sum();
        int quot  = requiredSumOfN / n ;
        int rem =  requiredSumOfN  % n;
        if( quot> 6 || quot==6 && rem>0  || requiredSumOfN < 0 || requiredSumOfN < n){
            return new int[0];
        } 
        int[] ans = new int[n];
        Arrays.fill(ans,quot);
        for(int i=0;i<ans.length && rem>0;i++){
            ans[i]++;
            rem--;
        }
        return ans;
    }
}