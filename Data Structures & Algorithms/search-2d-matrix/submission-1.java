class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = n - 1;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(target >= matrix[mid][0] && target <= matrix[mid][m-1])
            {
                int left1 = 0;
                int right1 = m - 1;
                while(left1 <= right1)
                {
                    int mid1 = left1 + (right1 - left1) / 2;
                    if(target == matrix[mid][mid1])return true;
                    else if(target < matrix[mid][mid1])right1 = mid1 - 1;
                    else left1 = mid1 + 1;
                }
                return false;
            }
            else if(target < matrix[mid][0])right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
// do the inner binary search as soon as you get the correct row