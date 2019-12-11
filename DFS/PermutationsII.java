// Permutations II

// Given a collection of numbers that might contain duplicates, return all possible unique permutations.

// Example:

// Input: [1,1,2]
// Output:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums==null){
            return result;
        }
        if (nums.length==0){
            result.add(new ArrayList<>());
            return result;
        }
        Arrays.sort(nums);
        List<Integer> permutation = new ArrayList<>();
        boolean [] used = new boolean[nums.length];
        recursion(nums,permutation,used,result);
        return result; 
    }
    private void recursion(int[] nums,List<Integer> permutation,boolean [] used,List<List<Integer>> result){
        if (permutation.size()==nums.length){
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (i!=0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }
            if (!used[i]){
                used[i] = true;
                permutation.add(nums[i]);         
                recursion(nums,permutation,used,result);
                permutation.remove(permutation.size()-1);
                used[i] = false;
            }
        }
    }
}