// Two Sum -Unique Pairs

// Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number. Please return the number of pairs.

// Example:

// Given nums = [1, 1, 2, 45, 46, 46], target = 47,
// return 2

// 1 + 46 = 47
// 2 + 45 = 47

class Solution {
    public int[] twoSumUniquePairs(int[] nums, int target) {
        if (nums==null||nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int result = 0;
        int small = 0, big = nums.length-1;
        while (small<big){
            if (nums[small]+nums[big]==target){
                result++;
                small++;
                big--;
                //Skip all dupilcates while comparing to guarantee unique
                while (small<big&&nums[small]==nums[small-1]){
                    small++;
                }
                while (small<big&&nums[big]==nums[big+1]){
                    big--;
                }
            }else if (nums[small]+nums[big]>target){
                big--;
            }else{
                small++;
            }
        }
        return result;
    }
}