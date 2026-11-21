class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[n + 1];
        for(int i = 0; i <= n; i++) {
            bucket[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;

        outerLoop:
        for(int i = bucket.length - 1; i >= 0; i--) {
            if(!bucket[i].isEmpty()) {
                for(int num : bucket[i]) {
                    res[index++] = num;
                    if(index == k) break outerLoop;
                }
            }
        }
        return res;
    }
}
