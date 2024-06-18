class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) {
        // O(n)

        PriorityQueue<diffProf> pq = new PriorityQueue<>(profit.length,(a,b)->a.diff-b.diff);
        for(int i=0;i<difficulty.length;i++){
            pq.add(new diffProf(difficulty[i],profit[i]));
        }
        Arrays.sort(workers);
        int ans = 0;
        int max = 0;
        int index = 0;
        for(int worker : workers){
         while(pq.size()>0 && worker>=pq.peek().diff){
            max  = Math.max(pq.peek().prof,max);
            pq.remove();
         }
         ans = ans+max;
        }
        return ans;
        
    }

    
}
class diffProf {
    int diff;
    int prof;
    public diffProf(int diff,int prof){
        this.diff = diff;
        this.prof = prof;
    }
}