class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int low = 0;
        int high = numbers.length -1 ;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum < target) {
                low += 1;
            } else if (sum > target) {
                high -=1;
            } else {
                break;
            }
        }
        return new int[]{low + 1, high + 1};
    }
}
