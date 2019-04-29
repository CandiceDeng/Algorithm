// Reorder Log Files

// You have an array of logs.  Each log is a space delimited string of words.

// For each log, the first word in each log is an alphanumeric identifier.  Then, either:

// Each word after the identifier will consist only of lowercase letters, or;
// Each word after the identifier will consist only of digits.
// We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

// Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

// Return the final order of the logs.

 

// Example 1:

// Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
// Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 

// Note:

// 0 <= logs.length <= 100
// 3 <= logs[i].length <= 100
// logs[i] is guaranteed to have an identifier, and a word after the identifier.

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (String logA, String logB)->{
            String[] splitA=logA.split(" ",2);
            String[] splitB=logB.split(" ",2);
            boolean isDigitA=Character.isDigit(splitA[1].charAt(0));
            boolean isDigitB=Character.isDigit(splitB[1].charAt(0));
            if (!isDigitA&&!isDigitB){
                int cmp=splitA[1].compareTo(splitB[1]);
                if (cmp!=0){return cmp;}
                return splitA[0].compareTo(splitB[0]);
            }else if (isDigitA&&!isDigitB){
               return 1; 
            }else if (!isDigitA&&isDigitB){
                return -1;
            }else{
                return 0;
            }
        });
        return logs;
    }
}