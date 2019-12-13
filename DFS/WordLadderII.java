// Word Ladder II

// Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

// Only one letter can be changed at a time
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
// Note:

// Return an empty list if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.
// Example 1:

// Input:
// beginWord = "hit",
// endWord = "cog",
// wordList = ["hot","dot","dog","lot","log","cog"]

// Output:
// [
//   ["hit","hot","dot","dog","cog"],
//   ["hit","hot","lot","log","cog"]
// ]
// Example 2:

// Input:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log"]

// Output: []

// Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList){
            wordSet.add(word);
        }
        if (beginWord==endWord||!wordSet.contains(endWord)){
            return new ArrayList<>();
        }
        Map<String,List<String>> nextwords = new HashMap<>(); //{word:[nextword#1,nexword#2...]}
        Map<String,Integer> distance = new HashMap<>(); //{word:distanceToBeginword}
        List<String> transformation = new ArrayList<>();
        wordSet.add(beginWord);
        wordSet.add(endWord);
        bfs(nextwords,distance,beginWord,wordSet);
        dfs(beginWord,endWord,nextwords,distance,transformation,result);
        return result;
    }
    private void dfs(String beginWord,String curWord,Map<String,List<String>> nextwords,Map<String,Integer> distance,List<String> transformation,List<List<String>> result){
        transformation.add(curWord);
        if (curWord==beginWord){
            Collections.reverse(transformation);
            result.add(new ArrayList<>(transformation));
            Collections.reverse(transformation);
        }else{
            for (String word : nextwords.get(curWord)){
                if (distance.containsKey(word)&&
                    distance.get(word)+1==distance.get(curWord)){
                    dfs(beginWord,word,nextwords,distance,transformation,result);
                    //DFS backwards from Endword to Beginword, word is closer to Beginword
                }
            }
        }
        transformation.remove(transformation.size()-1);
    }
    private void bfs(Map<String,List<String>> nextwords,Map<String,Integer> distance,String beginWord,Set<String> wordSet){
        Queue<String> queue = new LinkedList<>(); 
        queue.offer(beginWord);
        distance.put(beginWord,0);
        for (String word : wordSet){
            nextwords.put(word,new ArrayList<>());
        }
        while (!queue.isEmpty()){
            String cur = queue.poll();
            List<String> nextList = getNextWords(cur,wordSet);
            for (String next : nextList){
                nextwords.get(next).add(cur);
                if (!distance.containsKey(next)){
                    distance.put(next,distance.get(cur)+1); //"next" has 1 difference from Beginword when "cur" has 0
                    queue.offer(next);
                }
            }
        }
    }
    private List<String> getNextWords(String word,Set<String> words){
        List<String> nextWords = new ArrayList<>();
        for (char letter='a';letter<='z';letter++){
            for (int i=0;i<word.length();i++){
                if (word.charAt(i)==letter){
                    continue;
                }
                String newWord = replace(word,i,letter);
                if (words.contains(newWord)){
                    nextWords.add(newWord);
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