class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Arrays.stream(piles).max().getAsInt();
        int ret = max;
        while (min < max) {
            int mid = min + (max - min)/2;
            int usedHour = 0;
            for(int i = 0; i < piles.length; i++) {
                usedHour += Math.ceil((double)piles[i]/mid);
            }
            if (usedHour <= h) {
               ret = mid;
               max = mid; 
            } else {
                min = mid + 1;
            }
        }
        return ret;
    }
}
