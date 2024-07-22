class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[1]-a[1]));
        for(int i=0;i<heights.length;i++){
            pq.add(new int[]{i,heights[i]});
        }
        String ans[] = new String[names.length];
        int index=0;

        while(!pq.isEmpty()){
            int[] ele = pq.poll();
            ans[index++] = names[ele[0]];
        }
        return ans;
    }
}