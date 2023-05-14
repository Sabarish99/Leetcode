package org.example;

import java.util.HashMap;


public class Max_Points_On_Line {
    public static  int  maxPoints(int[][] points) {
        int finalRes = 0;

        if(points.length == 1) return 1;


        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> noOfpoints = new HashMap<>();
            int x1 = points[i][0];
            int y1 = points[i][1];
            int maxPointsOnLine = 1;
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];



                int x = x2-x1;
                int y = y2-y1;

                int gcd = GCD(x,y);
                x= x/gcd;
                y=y/gcd;

                if((x<0 && y >0 ) || (x>0 && y<0))
                {
                    x*=-1;
                    y*=-1;
                }

                noOfpoints.put(x+"*"+y, noOfpoints.getOrDefault(x+"*"+y, 0) + 1);

                maxPointsOnLine = Math.max(maxPointsOnLine,noOfpoints.get(x+"*"+y));

            }
            System.out.println(noOfpoints);

            finalRes = Math.max(finalRes, maxPointsOnLine+1);
        }


        return finalRes;
    }

    private static int GCD(int x, int y) {
        if(y==0) return x;
        return GCD(y, x%y);
    }

    public static void main(String[] args) {
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}} ;
        System.out.println(maxPoints(points));

    }
}
