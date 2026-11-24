class Solution {
    public boolean isValidSudoku(char[][] board) {
         Set<String> seen = new HashSet<String>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char val = board[i][j];
                if(val == '.'){
                    continue;
                }

                String row_key = "r" + i + val;
                String col_key = "c" + j + val;
                String box_key = "b" + (i / 3) + (j / 3) + val;

                if(seen.contains(row_key) || seen.contains(col_key) || seen.contains(box_key)){
                    return false;
                }
                seen.add(row_key);
                seen.add(col_key);
                seen.add(box_key);
            }
        }

        return true;
    }
}
