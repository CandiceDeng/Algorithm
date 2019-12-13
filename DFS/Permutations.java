// Permutations

// Given a collection of distinct integers, return all possible permutations.

// Example:

// Input: [1,2,3]
// Output:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums==null){
            return result;
        }
        if (nums.length==0){
            result.add(new ArrayList<>());
            return result;
        }
        List<Integer> permutation = new ArrayList<>();
        Set<Integer> hash = new HashSet<>();
        recursion(nums,permutation,hash,result);
        return result;
    }
    private void recursion(int[] nums,List<Integer> permutation,Set<Integer> hash,List<List<Integer>> result){
        if (permutation.size()==nums.length){
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (hash.contains(nums[i])){
                continue;
            }
            permutation.add(nums[i]);
            hash.add(nums[i]);
            recursion(nums,permutation,hash,result);
            hash.remove(nums[i]);
            permutation.remove(permutation.size()-1);
        }
        
    }
} 