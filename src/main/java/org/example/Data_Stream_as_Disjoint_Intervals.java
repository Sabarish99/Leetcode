package org.example;

import java.util.*;

public class Data_Stream_as_Disjoint_Intervals {
    Set<Integer> setData;

    public Data_Stream_as_Disjoint_Intervals()
    {
        setData = new TreeSet<>();
    }
    public void addNum(int value)
    {
        setData.add(value);
    }
    public int[][] getIntervals(){


        List<int[]> res = new ArrayList<>();
        int start=-1,end=-1;
        if(setData.size()==0)
            return new int[0][2];


        for(Integer val: setData){
            if(start<0)
            {
                start = val;
                end = val;
            }
            else if(val==end+1)
            {
                end= val;
            }
            else {
                res.add(new int[]{start,end});
                start = val;
                end = val;
            }

        }
        res.add(new int[]{start,end});
        return res.toArray(new int[res.size()][]);
    }

}
