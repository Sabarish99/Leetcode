package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insert_Interval {


    public static int findIndex(int[][] intervals, int[] newInterval){
        int start=0, end = intervals.length-1;
        int index=end+1;
        while(start<=end)
        {
            int mid = (start+end)/2;

            if(intervals[mid][0]>= newInterval[0])
            {
                index = mid;
                end= mid-1;
            }
            else start = mid+1;
        }

        return index;
    }
    public static int[][] insert(int[][] intervals, int[] newInterval)
    {
        List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
        System.out.println(intervalList);

        int index = findIndex(intervals, newInterval);
        intervalList.add(index,newInterval);

        for(int[] var: intervalList)
            System.out.println(var[0]+" "+var[1]);
        System.out.println(index);

        List<int[]> mergedList = new ArrayList<>();

        int start=intervalList.get(0)[0];
        int end = intervalList.get(0)[1];

        for(int[] var: intervalList)
        {
            if(var[0]<=end)
            {
                start = Math.min(start, var[0]);
                end = Math.max(end, var[1]);
            }
            else {
                mergedList.add(new int[]{start,end});
                start = var[0];
                end = var[1];
            }
        }
        mergedList.add(new int[]{start,end});

        for(int[] var: mergedList)
            System.out.println(var[0]+" "+var[1]);

        return mergedList.toArray(new int[intervals.length][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{2,5},{6,7},{8,9}};
        insert(intervals,new int[]{0,1});
    }
}
