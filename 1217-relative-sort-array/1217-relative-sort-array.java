class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int index = 0;
        int ans[] = new int[arr1.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:arr1){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:arr2){
            if(map.containsKey(i)){
                int freq = map.get(i);
                while(freq-- >0){
                    ans[index++] = i;
                }
                map.remove(i);
            }
        }
        Map<Integer, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        for(Map.Entry<Integer,Integer> entry : sortedMap.entrySet()){
            int fre = entry.getValue();
            while(fre-- >0){
                    ans[index++] = entry.getKey();
            }
        }
        return ans;
    }
}