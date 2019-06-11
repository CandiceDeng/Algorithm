// Longest Palindrome

// Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that CAN BE BUILT with those letters.

// This is case sensitive, for example "Aa" is not considered a palindrome here.

// Note:
// Assume the length of given string will not exceed 1,010.

// Example:

// Input:
// "abccccdd"

// Output:
// 7

// Explanation:
// One longest palindrome that can be built is "dccaccd", whose length is 7.

class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        for (int i=0;i<s.length();i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }
        int result=0;
        int singleChar=0;
        for (Character x : map.keySet()){
            if (map.get(x)%2==0){
                result+=map.get(x);
            }else{
                result+=map.get(x)-1;
                singleChar=1;
            }
        }
        return result+singleChar;
    }
}