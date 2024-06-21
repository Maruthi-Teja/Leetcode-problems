class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int i= 0;
        int sum =0;
        //int max = 0;
        if(minutes>=customers.length){
            for(int t:customers)sum+=t;
            return sum;
        }
        for(;i<minutes;i++){
            if(i<customers.length)
            sum=sum+customers[i]*(grumpy[i]);
        }
        
        int max = sum;
        int start = 0,end = minutes-1;
        for( ;i<customers.length;i++){
            sum = sum + customers[i]*(grumpy[i]);
            sum = sum - customers[i-minutes]*(grumpy[i-minutes]);
            if(sum>=max){
                start = i-minutes+1;
                end = i;
                max = sum;
            }
        }
        int ans = 0;
        for(int x=0;x<customers.length;x++){
            if(x>=start && x<=end){
                ans = ans+customers[x];
            }else{
                if(grumpy[x]==0)
                ans = ans + customers[x];
            }
        }
        return ans;
    }
}