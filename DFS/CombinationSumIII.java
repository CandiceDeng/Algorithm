// Combination Sum III

// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

// Note:

// All numbers will be positive integers.
// The solution set must not contain duplicate combinations.
// Example 1:

// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Example 2:

// Input: k = 3, n = 9
// Output: [[1,2,6], [1,3,5], [2,3,4]]

class Solution {
    public int num = 9;
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        recursion(k,1,n,combination,result);
        return result; 
    }
    private void recursion(int k,int startIndex,int remainTarget,
                           List<Integer> combination,List<List<Integer>> result){
        if (k==0){
            if (remainTarget==0){
                result.add(new ArrayList<>(combination));
                return;
            }
        }
        for (int i=startIndex;i<=num;i++){
            combination.add(i);
            recursion(k-1,i+1,remainTarget-i,combination,result);
            combination.remove(combination.size()-1);
        }
    }
}