package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumBullet {

    public static int findMinArrowShot(int[][] points)
    {
        List<Integer[]> result = new ArrayList<>();

        Arrays.sort(points, (a,b) -> Integer.compare(a[1],b[1]));

        int start = points[0][0];
        int end = points[0][1];

        int minBallons = 1;
       // System.out.println(points[1][1]);
        for(int i=1;i<points.length;i++)
        {
            if(points[i][0] <= end)
            {
                end = Math.min(end,points[i][1]);
            }
            else {
                minBallons++;
                start = points[i][0];
                end = points[i][1];
            }
        }


        return minBallons;
    }

    public static void main(String[] args) {
        int points[][] = {
                {10,16}, {2,8},{0,1},{7,12}
        };

        System.out.println(findMinArrowShot(points));
    }
}
