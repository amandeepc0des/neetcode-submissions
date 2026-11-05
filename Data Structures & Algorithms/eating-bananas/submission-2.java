class Solution {
    boolean isAnswer(int mid, int[] piles, int h)
    {
        double cnt = 0;
        for(int item : piles)
        {
            cnt += (item + mid - 1) / mid;
        }
        return cnt <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = 1;
        while(!isAnswer(right, piles, h))right *= 2;
        while(left + 1 <  right)
        {
            int mid = left + (right - left)/2;
            if(isAnswer(mid, piles, h))right = mid;
            else left = mid;
        }

        return right;
    }
}

/*
// Universal binary Search

left  = definitely NOT an answer
right = definitely an answer

//left and right can be interchagned based on the questoin.

while (left + 1 < right):
    mid = ...
    if mid is answer:
        right = mid
    else:
        left = mid

return right

*/
