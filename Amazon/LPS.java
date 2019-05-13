// Longest Palindromic Substring

// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

// Example 1:

// Input: "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
// Example 2:

// Input: "cbbd"
// Output: "bb"

class Solution {
    public String longestPalindrome(String s) {
        if (s.length()<2){
            return s;
        }
        
        int maxLength=1;
        int low=0,high=0;
        int slen=s.length(),start=0;
        for (int i=1;i<slen;i++){
        	//Check all even palindrome
            low=i-1;
            high=i;
            while (low>=0&&high<slen&&s.charAt(low)==s.charAt(high)){
                if (maxLength<high-low+1){
                    start=low;
                    maxLength=high-low+1;
                }
                low--;
                high++;
            }
            //Check all odd palindrome
            low=i-1;
            high=i+1;
            while (low>=0&&high<slen&&s.charAt(low)==s.charAt(high)){
                if (maxLength<high-low+1){
                    start=low;
                    maxLength=high-low+1;
                }
                low--;
                high++;
            }
        }
        return s.substring(start,start+maxLength);
    }
}