// Word Ladder

// Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

// Only one letter can be changed at a time.
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
// Note:

// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.
// Example 1:

// Input:
// beginWord = "hit",
// endWord = "cog",
// wordList = ["hot","dot","dog","lot","log","cog"]

// Output: 5

// Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.
// Example 2:

// Input:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log"]

// Output: 0

// Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        for (String word : wordList){
            words.add(word);
        }
        int result = 1;
        if (words==null||words.size()==0){
            return 0;
        }
        if (beginWord==endWord){
            return 1;
        }
        wordList.add(beginWord);
        wordList.add(endWord);
        Queue<String> queue = new LinkedList<>();
        Set<String> hash = new HashSet<>();
        queue.offer(beginWord);
        hash.add(beginWord);
        
        while (!queue.isEmpty()){
            result++;
            int curSize = queue.size();
            for (int i=0;i<curSize;i++){
                String word = queue.poll();
                for (String nextword : nextWords(word,words)){
                    if (hash.contains(nextword)){
                        continue;
                    }
                    if (nextword.equals(endWord)){
                        return result;
                    }
                    queue.offer(nextword);
                    hash.add(nextword);
                }
            }
        }
        return 0;
    }
    private List<String> nextWords(String word,Set<String> words){
        List<String> nextWords = new ArrayList<>();
        //Replace each letter with other 25 letters then check whether the replaced word is in wordList, T(n) for one word is O(25*L*L) instead of O(L*N)
        for (char letter='a';letter<='z';letter++){
            for (int i=0;i<word.length();i++){
                if (word.charAt(i)==letter){
                    continue;
                }
                String nextword = replace(word,i,letter);
                if (words.contains(nextword)){
                    nextWords.add(nextword);
                }
            }
        }
        return nextWords;
    }
    private String replace(String word,int i,char letter){
        char[] wordToChar = word.toCharArray();
        wordToChar[i] = letter;
        return new String(wordToChar);
    }
}