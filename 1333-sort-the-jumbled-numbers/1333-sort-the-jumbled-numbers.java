class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {

        //brute force 
        HashMap<Integer,Integer> map = new HashMap<>();
        IntStream.range(0,nums.length).forEach(x->{
            
            String str = String.valueOf(nums[x]);
            String ans = "";
            for(int i=0;i<str.length();i++){
                ans+= mapping[str.charAt(i)-48];
            }
            map.put(x,Integer.parseInt(ans));
        });
    return    IntStream.range(0,nums.length).boxed()
            .sorted((a,b)->map.get(a)!=map.get(b)?map.get(a)-map.get(b):a-b)
            .mapToInt(n ->nums[n])
            .toArray();
        
    }
}