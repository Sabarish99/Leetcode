package org.example;

import java.util.Arrays;

public class MaxCircularSubArraySum {
    public static int maxSubarraySumCircular(int[] nums)
    {
        int maxSum = nums[0];
        int totalSum = Arrays.stream(nums).reduce(0, Integer::sum);
        int currSum=0;
        int currminSum=0;
        int minSum=maxSum;

        for(int num:nums)
        {
            currSum = Math.max(currSum+num, num);
            maxSum = Math.max(maxSum,currSum);

            currminSum = Math.min(currminSum+num, num);
            minSum = Math.min(currminSum,minSum);
        }
        return Math.max(maxSum, totalSum - minSum);
    }
}
