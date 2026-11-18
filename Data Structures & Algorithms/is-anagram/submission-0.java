class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> s_counter = new HashMap<>();
        Map<Character, Integer> t_counter = new HashMap<>();
        for(char c : s.toCharArray()){
            s_counter.put(c, s_counter.getOrDefault(c, 0) + 1);
        }
        for(char c : t.toCharArray()){
            t_counter.put(c, t_counter.getOrDefault(c, 0) + 1);
        }
        if(s_counter.size() != t_counter.size()){
            return false;
        }
        for(Map.Entry<Character, Integer> entry : s_counter.entrySet()){
            if(!t_counter.containsKey(entry.getKey())){
                return false;
            }
            if(!entry.getValue().equals(t_counter.get(entry.getKey()))){
                return false;
            }
        }
        return true;
    }
}
