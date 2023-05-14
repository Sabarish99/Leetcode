package org.example;

import java.util.Arrays;

public class MaxBagWithFullCapacity {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int result = 0;

        for(int i=0;i<capacity.length;i++)
            capacity[i] = capacity[i] - rocks[i];

        Arrays.sort(capacity);

        for(var item : capacity)
        {
            if(item <= additionalRocks)
            {
                additionalRocks -= item;
                result++;
            }
            else break;
        }
        return result;
    }
}
