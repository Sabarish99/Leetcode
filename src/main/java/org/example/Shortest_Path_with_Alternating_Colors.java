package org.example;

import java.util.*;
public class Shortest_Path_with_Alternating_Colors {
    public enum Color{
        red,
        blue,
        none
    }

    class Node{
        int nodeNum;
        int length;
        Color color;

        public Node(int nodeNum, int length, Color color) {
            this.nodeNum = nodeNum;
            this.length = length;
            this.color = color;
        }
        public Node(int nodeNum, Color color) {
            this.nodeNum = nodeNum;
            this.color = color;
        }

        public int getNodeNum() {
            return nodeNum;
        }

        public int getLength() {
            return length;
        }

        public Color getColor() {
            return color;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        int[] answer = new int[n];
        Arrays.fill(answer,-1);

        //define ADJList for both red and blue edges
        Map<Integer, List<Integer>> redAdjList = new HashMap<>();
        Map<Integer, List<Integer>> blueAdjList = new HashMap<>();

        if(redEdges.length ==0) redAdjList.put(0,new ArrayList<>(Arrays.asList(-1)));
        if(blueEdges.length ==0) blueAdjList.put(0,new ArrayList<>(Arrays.asList(-1)));

        //create adjList for red Nodes
        for(int[] edge:redEdges)
        {
            int src = edge[0];
            int dest = edge[1];

            redAdjList.putIfAbsent(src, new ArrayList<>());
            redAdjList.get(src).add(dest);
        }
        System.out.println(redAdjList);

        //create adjList for blue Nodes
        for(int[] edge:blueEdges) {
            int src = edge[0];
            int dest = edge[1];

                blueAdjList.putIfAbsent(src, new ArrayList<>());
                blueAdjList.get(src).add(dest);

        }
        System.out.println(blueAdjList);

        //push the first Node ie Node 0 in the queue to start BFS inorder to find the shortest path
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0,0,Color.none));

        //create a visited set with Pair of Node and color.
       int[][] visited = new int[2][n];
        visited[0][0] = 1;
        visited[1][0] = 1;
        System.out.println(visited);

        //perform BFS
        while(!queue.isEmpty()) {
            var queueOut = queue.poll();
            int node = queueOut.getNodeNum();
            Color color = queueOut.getColor();
            int length = queueOut.getLength();
            //if ans[node] is -1 , update with the first value as it is min dist
            if (answer[node] == -1)
                answer[node] = length + 1;

            //check with redNeighbours
            if (color != Color.red) {
                for (var neighbours : redAdjList.get(node)) {
                    if (visited[0][neighbours] == 0) {
                        visited[0][neighbours] = 1;
                        queue.add(new Node(neighbours, length + 1, Color.red));
                    }
                }
            }
            if (color != Color.blue) {
                for (var neighbours : blueAdjList.get(node)) {
                    if (visited[1][neighbours] == 0) {
                        visited[1][neighbours] = 1;
                        queue.add(new Node(neighbours, length + 1, Color.red));
                    }
                }
            }
        }

        return  answer;
    }

}
