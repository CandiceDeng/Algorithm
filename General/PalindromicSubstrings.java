// Palindromic Substrings

// Given a string, your task is to count how many palindromic substrings in this string.

// The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

// Example 1:

// Input: "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".
 

// Example 2:

// Input: "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n=s.length();
        if (n<2){
            return n;
        }
        for (int i=0;i<n;i++){
            for (int j=i+1;j<=n;j++){
                if (isPalindrome(s.substring(i,j))){
                    count+=1;
                }
            }
        }
       return count; 
    }
    private boolean isPalindrome(String subString){
      int n = subString.length();
      for (int i = 0;i<(n/2);++i) {
         if (subString.charAt(i)!=subString.charAt(n-i-1)) {
             return false;
         }
      }
      return true;
    }
}