// 3Sum Closest

// Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

// Example:

// Given array nums = [-1, 2, 1, -4], and target = 1.

// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min_diff=Integer.MAX_VALUE;
        int result=0;
        if (nums.length<3){
            return min_diff;
        }
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++){
            int left=i+1, right=nums.length-1;
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                int diff=Math.abs(sum-target);
                if (diff==0){
                    return sum;
                }
                if (diff<min_diff){
                    min_diff=diff;
                    result=sum;
                }
                if (sum<=target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }
}