class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,  List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String sorted = new String(chars);
            map.put(sorted, new ArrayList<>());
        }
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String str_sorted =  new String(chars);

            map.get(str_sorted).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
