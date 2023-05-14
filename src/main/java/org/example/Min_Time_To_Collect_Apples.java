package org.example;

import java.util.*;

public class Min_Time_To_Collect_Apples {

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple)
    {

        Map<Integer,List<Integer>> adjList = new HashMap<>();

        for(int i[]: edges)
        {
            int key = i[0];
            int value = i[1];

            adjList.putIfAbsent(key, new ArrayList<>());
            adjList.putIfAbsent(value,new ArrayList<>());

            adjList.get(key).add(value);
            adjList.get(value).add(key);
        }
        System.out.println(adjList);


        return dfs(0,-1,adjList,hasApple);


    }

    private static int dfs(int curr,int parent, Map<Integer, List<Integer>> adjList,List<Boolean> hasApples) {
        int time = 0;

        for(var child : adjList.getOrDefault(curr,new ArrayList<>()))
        {
            if(child == parent) continue;

            var childTime = dfs(child,curr,adjList,hasApples);


            if(childTime>0 || hasApples.get(child) )
                time = time+ childTime+2;
        }
        return time;
    }

    public static void main(String[] args) {
        int [][]edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> hasApples = new ArrayList<>(Arrays.asList(false, false, true, false, true, true, false));
       int ans =  minTime(7, edges ,hasApples);
        System.out.println(ans);
    }
}
