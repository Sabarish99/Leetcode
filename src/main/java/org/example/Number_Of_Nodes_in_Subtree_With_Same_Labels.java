package org.example;

import java.util.*;

public class Number_Of_Nodes_in_Subtree_With_Same_Labels {

    public static int[] countSubTrees(int n, int[][] edges, String labels)
    {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] result = new int[n];

        for(int i[]: edges)
        {
            int parent = i[0];
            int child = i[1];

            adjList.putIfAbsent(parent,new ArrayList<>());
            adjList.putIfAbsent(child,new ArrayList<>());

            adjList.get(parent).add(child);
            adjList.get(child).add(parent);
        }
        System.out.println(adjList);

        List<Integer> x = adjList.getOrDefault(-1,new ArrayList<>());
        for(var i:x)
            System.out.println(i);

        dfs(0,-1,result,labels,adjList);
        return  result;



    }

    private static int[] dfs(int curr, int parent, int[] result, String labels, Map<Integer, List<Integer>> adjList)
    {
        int[] count = new int[26];
        char letter = labels.charAt(curr);
        count[letter-'a'] = 1;

        System.out.println("Curr "+ curr+" Parent "+parent);
//        if(!adjList.containsKey(curr))
//        {
//            System.out.println("base condition");
//            return count;
//        }


        for(int child: adjList.getOrDefault(curr,new ArrayList<>())) {
            System.out.println("Child " + child);
            if (child == parent) continue;

            int[] childCount = dfs(child, curr, result, labels, adjList);
            for (int i = 0; i < 26; i++) {
                count[i] += childCount[i];
            }
        }
            result[curr] = count[letter-'a'];

        return count;

    }

    public static void main(String[] args) {
        int[][] edges = { {0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        var list = countSubTrees(7,edges,"abaedcd");
        Arrays.stream(list).forEach(System.out::print);
    }
}
