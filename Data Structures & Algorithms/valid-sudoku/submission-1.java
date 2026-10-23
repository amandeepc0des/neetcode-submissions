class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int row = 0 ; row < 9; row++)
        {
            for(int col = 0; col < 9; col++)
            {
                char elm = board[row][col];
                if(elm  != '.')
                {
                    if(!seen.add(elm + "in row" + row)
                    || !seen.add(elm + "in col" + col)
                    || !seen.add(elm + "in box" + row/3 + "-" + col/3)) return false;
                }
            }
        }
        return true;
    }
}


// why we divided by 3, to make indecies of box.(we divided the row in 3 set(0,1,2) similarly col(0,1,2))
// so there will be combination like this ((0,1), (0,2)....)these indicates boxes.