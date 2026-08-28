class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rowMap = new int[9][10];
        int[][] colMap = new int[9][10];

        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] == '.')continue;
                int num = board[i][j] - '0';
                if(num > 9 || num < 1)return false;
                rowMap[i][num]++;
                colMap[j][num]++;
                if(rowMap[i][num] > 1 || colMap[j][num] > 1)return false;   
            }
        }

        int[] subMap = new int[10];
        int r = 0;
        int c = 0;
        int box = 0;
        while(box < 9)
        {
            for(int i = r; i < r + 3; i++)
            {
                for(int j = c; j < c + 3; j++)
                {
                    if(board[i][j] == '.')continue;
                    int num = board[i][j] - '0';
                    System.out.println("num: " + num);
                    subMap[num]++;
                    if(subMap[num] > 1)return false;

                }
            }
            c += 3;
            if(c == 9)
            {
                c = 0;
                r += 3;
            }
            Arrays.fill(subMap, 0);
            box++;
        }
        return true;

    }
}
