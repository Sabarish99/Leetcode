package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Concatenated_Words {
    public static boolean dfs(String word , Set<String> wordsSet) {

        for(int i=1;i<word.length();i++)
        {
            String prefix = word.substring(0,i);
            String suffix = word.substring(i);

            System.out.println(prefix+"  "+suffix);

            if((wordsSet.contains(prefix) && wordsSet.contains(suffix) )|| (wordsSet.contains(prefix) && dfs(suffix, wordsSet))) {
                return Boolean.TRUE;
            }
        }
        return false;

    };
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {

        Set<String> wordsSet = Arrays.stream(words).collect(Collectors.toSet());
        System.out.println(wordsSet);

        List<String> result = new ArrayList<>();



        for(var word: words)
        {
            if(dfs(word,wordsSet))
                result.add(word);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(findAllConcatenatedWordsInADict(words));
    }
}
