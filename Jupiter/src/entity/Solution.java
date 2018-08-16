package entity;

import java.util.*;

class Solution {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.contains(beginWord)) return 0;
        Queue<String> q = new LinkedList<>();
        boolean [] visit = new boolean [wordList.size()];
        int time = 0;
        q.offer(beginWord);
        System.out.println("222222222222");

        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    if (visit[j]) continue;
                    System.out.println("wordlist : " + time + "  " +  wordList.get(j));
                    if (match(str, wordList.get(j))) {
                        if (wordList.get(j).equals(endWord)) return time;
                        q.offer(wordList.get(j));
                        visit[j] = true;
                    } 
                }
            }
        }
        return 0;
    }
    public static boolean match(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int res = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) res++;
            if (res > 1) return false;
        }
        if (res == 1) return true;
        return false;
    }
    
//    "hit"
//    "cog"
//    ["hot","dot","dog","lot","log","cog"]
    public static void main(String[] args) {
    	String beginWord = "hit";
    	String endWord = "cog";
    	String [] List = {"hot","dot","dog","lot","log","cog"};
        System.out.println("111111111");
    	System.out.println(ladderLength(beginWord, endWord, Arrays.asList(List)));
    }
    
}