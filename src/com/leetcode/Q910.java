package com.leetcode;

import java.util.Arrays;

/***
 910. Smallest Range II

 You are given an integer array nums and an integer k.
 For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.
 The score of nums is the difference between the maximum and minimum elements in nums.
 Return the minimum score of nums after changing the values at each index.

 Example 1:
 Input: nums = [1], k = 0
 Output: 0
 Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.
 Example 2:

 Input: nums = [0,10], k = 2
 Output: 6
 Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.
 Example 3:

 Input: nums = [1,3,6], k = 3
 Output: 3
 Explanation: Change nums to be [4, 6, 3]. The score is max(nums) - min(nums) = 6 - 3 = 3.


 Constraints:
 1 <= nums.length <= 10^4
 0 <= nums[i] <= 10^4
 0 <= k <= 10^4
 */
public class Q910 extends QBase {

    public static void main(String[] args) {
        Q910 q = new Q910();
        log(q.smallestRangeII(new int[]{1}, 0)); // 0
        log(q.smallestRangeII(new int[]{0, 10}, 2)); // 6
        log(q.smallestRangeII(new int[]{7, 8, 8}, 5)); // 1
        log(q.smallestRangeII(new int[]{1, 3, 6}, 3)); // 3
        log(q.smallestRangeII(new int[]{0, 3, 4, 7}, 5)); // 7
        log(q.smallestRangeII(new int[]{2,5,7,8,8}, 4)); // 5

    }

    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);

        int result = nums[nums.length - 1] - nums[0];

        int firstAdd = nums[0] + k;
        int lastSub = nums[nums.length - 1] - k;

        for (int i = 0; i < nums.length - 1; i++) {
            int iMax = Math.max(nums[i] + k, lastSub);
            int iMin = Math.min(nums[i+1] - k, firstAdd);
            result = Math.min(result, iMax - iMin);
        }


        return result;

    }

}
