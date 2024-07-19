class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] min = new int[m];
        int[] max = new int[n];
        for(int i=0;i<n;i++){
            max[i] = Integer.MIN_VALUE;
        }
        for(int i=0;i<m;i++){
             min[i]= Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                min[i] = Math.min(min[i],matrix[i][j]);
                max[j] = Math.max(max[j],matrix[i][j]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(min[i]==max[j]){
                    ans.add(min[i]);
                }
            }
        }
        return ans;
    }
}