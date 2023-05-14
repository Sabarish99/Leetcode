package org.example;

import java.util.Arrays;

public class Maximum_IceCream_Bars {
    public static int maxIceCream(int[] costs, int coins)
    {
        int iceCreams = 0;
        Arrays.sort(costs);

        for(var cost: costs)
        {
           if(cost <= coins)
           {
               coins-=cost;
               iceCreams++;
           }
        }
        return iceCreams;
    }
}
