class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        
        int longestConsecutive = 0;
        
        for(int num : nums) {
            if(!set.contains(num - 1)) {
                int cnt = 1;
                int nextNum = num + 1;
                while(set.contains(nextNum)) {
                    cnt++;
                    nextNum++;
                }
                longestConsecutive = Math.max(longestConsecutive, cnt);
            }
        }
        return longestConsecutive;
    }
}
