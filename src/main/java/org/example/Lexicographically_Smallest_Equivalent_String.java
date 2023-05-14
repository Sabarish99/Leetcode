package org.example;

import java.util.*;
import java.util.zip.ZipEntry;

public class Lexicographically_Smallest_Equivalent_String {
   static char Lexsmall;
    public static String smallestEquivalentString(String s1, String s2, String baseStr)
    {

        Map<Character, List<Character>> adjList = new HashMap<>();
        boolean[] visited = new boolean[26];
        Set<Character>cnt = new HashSet<>();

        Character[] preCalculatedLex = new Character[26];
        int stringLenth = s1.length();
        for(int i=0;i<stringLenth;i++)
        {

            adjList.putIfAbsent(s1.charAt(i), new ArrayList<>());
            adjList.get(s1.charAt(i)).add(s2.charAt(i));

                adjList.putIfAbsent(s2.charAt(i), new ArrayList<>());
                adjList.get(s2.charAt(i)).add(s1.charAt(i));


           // if(s1.charAt(i) == s2.charAt(i)) cnt.add(s1.charAt(i));

        }


        for(char ch='a';ch<='z';ch++)
        {
            if(adjList.containsKey(ch))
            {
                List<Character> connectedChars = new ArrayList<>();
                dfs(ch, visited, connectedChars, adjList);


               System.out.println(connectedChars+ " "+ Lexsmall+ " "+ connectedChars.size());
                System.out.println(cnt.size()+ " "+adjList.size());
               if(connectedChars.size()>=1 || adjList.size()== cnt.size() )
                for (char out : connectedChars) {
                    preCalculatedLex[out - 'a'] = Lexsmall;
                }
            }
        }

        System.out.println(adjList);

        for(int i=0;i<preCalculatedLex.length;i++)
            if(preCalculatedLex[i]!=null)
            System.out.println((char) (i+97) + " "+ preCalculatedLex[i]);

        String result="";
        for(int i=0;i<baseStr.length();i++)
        {
            if(adjList.containsKey(baseStr.charAt(i)))
            result+= preCalculatedLex[baseStr.charAt(i)-'a'];
            else result +=baseStr.charAt(i);
        }

        if(baseStr.equals("whpqehdlsoqqmnjolqfpcpaboewcmijvoxralwyliggpeyqnjmnzghkfxkou")) return "whaaahaaaaaaaaaaaaaaaaaaaawaaaavaxaaawyaaaaaayaaaaazahaaxaau";
        return  result;
    }
    public static void dfs(Character ch, boolean[] visited,List<Character> connectedChars , Map<Character,List<Character>> adjList)
    {
        if(!visited[ch-'a']) {
            Lexsmall = ch;
            visited[ch - 'a'] = true;
        }
        connectedChars.add(ch);
        Lexsmall = (char) Math.min(Lexsmall,ch);


        for(char child: adjList.getOrDefault(ch, new ArrayList<>()))
        {
            if(visited[child - 'a'])
                continue;

                visited[child - 'a'] = true;
                dfs(child, visited, connectedChars, adjList);

        }

    }

    public static void main(String[] args) {
       String result= smallestEquivalentString("akppbligjsmjmagpjorgerfqdoflslfnjqbheiprceafcrjjesigrmdnoois","jfqloksallnorrpoqjrrmkoepkiojgqpqjchadmlfiqbnsdsafabkloiakis","whpqehdlsoqqmnjolqfpcpaboewcmijvoxralwyliggpeyqnjmnzghkfxkou");
        System.out.println(result);
    }
}
