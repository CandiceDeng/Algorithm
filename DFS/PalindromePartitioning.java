// Palindrome Partitioning

// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return all possible palindrome partitioning of s.

// Example:

// Input: "aab"
// Output:
// [
//   ["aa","b"],
//   ["a","a","b"]
// ]

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s==null||s.length()==0){
            return result;
        }
        List<String> partition = new ArrayList<>();
        dfs(s,0,partition,result);
        return result;
    }
    private void dfs(String s,int startIndex,List<String> partition,List<List<String>> result){
        if (startIndex==s.length()){
            result.add(new ArrayList<>(partition));
            return;
        }
        for (int i=startIndex;i<s.length();i++){
            String subString = s.substring(startIndex,i+1);
            if (!isPalindrome(subString)){
                continue;
            }
            partition.add(subString);
            dfs(s,i+1,partition,result);
            partition.remove(partition.size()-1);
        }
    }
    private boolean isPalindrome(String s){
        int len = s.length();
        for (int i=0;i<len/2;i++){
            if (s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
}