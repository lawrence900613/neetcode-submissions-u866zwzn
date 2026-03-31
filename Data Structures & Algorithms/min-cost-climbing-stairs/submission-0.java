class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }
        int[] arr = new int[cost.length];
        arr[0] = cost[0];
        arr[1] = cost[1];
        for(int i = 2; i < cost.length; i++) {
            arr[i] = cost[i] + Math.min(arr[i - 1], arr[i - 2]);
        }
        return Math.min(arr[cost.length -1], arr[cost.length - 2]);
    }
}
