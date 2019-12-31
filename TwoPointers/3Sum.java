// 3Sum

// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note:

// The solution set must not contain duplicate triplets.

// Example:

// Given array nums = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums==null||nums.length==0){
            return result;
        }
        //HashMap
        // Arrays.sort(nums);
        // Map<Integer,Integer> map = new HashMap<>();
        // for (int i=0;i<nums.length;i++){
        //     map.put(nums[i],i);
        // }
        //i<nums.length-2 and j<nums.length-1 to guarantee target is on the right side of nums[i] and nums[j]
        // for (int i=0;i<nums.length-2;i++){
        //     if (i>0&&nums[i]==nums[i-1]){
        //         continue;
        //     }
        //     for (int j=i+1;j<nums.length-1;j++){
        //         if (j>i+1&&nums[j]==nums[j-1]){
        //             continue;
        //         }
        //         int target = (nums[i]+nums[j])*(-1);
        //         if (map.containsKey(target)&&map.get(target)>j){
        //             List<Integer> triplet = new ArrayList<>();
        //             triplet.add(nums[i]);
        //             triplet.add(nums[j]);
        //             triplet.add(target);
        //             result.add(triplet);  
        //         }
        //     }
        // }
        // return result;
        
        //Two pointers
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            if (i>0&&nums[i]==nums[i-1]){
                continue; //Remove duplicates
            }
            int small = i+1, big = nums.length-1;
            while (small<big){
                int sum = nums[i]+nums[small]+nums[big];
                if (sum==0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[small]);
                    triplet.add(nums[big]);
                    result.add(triplet);
                    small++;
                    big--;
                    while (small<big&&nums[small]==nums[small-1]){
                        small++;
                    }
                    while (small<big&&nums[big]==nums[big+1]){
                        big--;
                    }
                }else if (sum>0){
                    big--;
                }else{
                    small++;
                }
            }
        }
        return result;        
    }
}