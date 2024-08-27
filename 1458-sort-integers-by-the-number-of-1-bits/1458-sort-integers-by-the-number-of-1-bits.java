class Solution {
    public int[] sortByBits(int[] arr) {
       HashMap<Integer,Integer> map = new HashMap<>();

       Integer[] arrInteger = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        //brute force 
        for(int i=0;i<arr.length;i++){
            
            int number =  arr[i];
            int noOfOnes = 0;
            while(number!=0){
                noOfOnes++;
                number = (number)&(number-1);
            }
            map.put(arr[i],noOfOnes);
        }
        Arrays.sort(arrInteger,(a,b)->(map.get(a)==map.get(b))?a-b:map.get(a)-map.get(b));

        return Arrays.stream(arrInteger).mapToInt(Integer::intValue).toArray();
    }
}