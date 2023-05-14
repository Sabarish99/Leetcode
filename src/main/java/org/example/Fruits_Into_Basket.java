package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Fruits_Into_Basket {
    public static int totalFruits(int[] fruits)
    {
        //define set to hold only unique fruit count
        Set<Integer> uniqueFruits = new HashSet<>();

        // define a Map for holding count of each fruit type
        Map<Integer,Integer> fruitsCount = new HashMap<>();

        //set maxWindow to 0 and initialise the left and right ptrs denoting the window size
        int maxWindow = 0 , left=0, right=0;

        //move rightPtr until we reach end
        while(right<fruits.length)
        {
            //push the fruits one by one to set and map
            uniqueFruits.add(fruits[right]);

            fruitsCount.put(fruits[right],
                    fruitsCount.getOrDefault(fruits[right],0)+1);

            //check if unique fruits count is exceeding 2
            while(uniqueFruits.size()>2)
            {
                //remove the left elements
                fruitsCount.put(fruits[left],
                        fruitsCount.getOrDefault(fruits[left],0)-1);

                if(fruitsCount.get(fruits[left]) == 0)
                    uniqueFruits.remove(fruits[left]);
                left++;
            }
            maxWindow = Math.max(right-left+1, maxWindow);
            right++;
        }

        //return maxWindow size
        return maxWindow;
    }

    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruits(fruits));
    }
}
/*

0,1,2,2,3,3,2,0
0
set - 0,
map -> 0 - 1
maxWindow = 1
right=1

1
set- 0,1
0->1, 1->1
maxWindow = 2
right =2

2
set - 0,1,2
0->1, 1->1, 2->1
0->0, 1->1, 2->1
left=1
maxWindow=2
right=3

2





 */