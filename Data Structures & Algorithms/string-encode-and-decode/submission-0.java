class Solution {
    private String encode_helper(String str) {
        int n =  str.length();

        String prefix = String.valueOf(n) + '#';
        StringBuilder sb = new StringBuilder(str);

        sb.insert(0, prefix);

        return sb.toString();
    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(encode_helper(s));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while(i < str.length()) {
            int j = str.indexOf('#', i);

            int length = Integer.parseInt(str.substring(i, j));

            String word = str.substring(j + 1, j + length + 1);

            res.add(word);

            i = j + length + 1;
        }
        
        return res;
    }
}
