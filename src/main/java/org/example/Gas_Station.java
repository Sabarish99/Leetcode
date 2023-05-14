package org.example;

import java.util.Arrays;

public class Gas_Station {
    public  int canCompleteCircuit(int[] gas, int[] cost)
    {
        Integer sumGas = Arrays.stream(gas).
                reduce(0,Integer::sum);
        Integer sumCost = Arrays.stream(cost)
                .reduce(0, Integer::sum);

        if(sumGas < sumCost) return -1;

        int total=0, startIndex = 0;

        for(int i=0;i< gas.length;i++)
        {
            total = total + gas[i] - cost[i];
            if(total < 0)
            {
                total = 0;
                startIndex= i+1;
            }
        }
        return  startIndex;
    }
}
