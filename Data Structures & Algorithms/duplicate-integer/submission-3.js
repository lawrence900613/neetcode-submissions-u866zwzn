class Solution {
    /**
     * @param {number[]} nums
     * @return {boolean}
     */
    hasDuplicate(nums) {
        let map = []
        for(let i = 0; i < nums.length; i++) {
            if(map.includes(nums[i])) {
                return true;
            } else {
                map.push(nums[i]);
            }
        }
        return false;
    }
}
