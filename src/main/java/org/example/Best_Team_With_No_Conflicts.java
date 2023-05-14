package org.example;

import java.util.*;

public class Best_Team_With_No_Conflicts {
    public static  int bestTeamScore(int[] scores, int[] ages) {
        int[][] pairs = new int[scores.length][2];
        for(int i=0;i<scores.length;i++)
        {
            pairs[i][0] = scores[i];
            pairs[i][1] = ages[i];
        }
      Arrays.stream(pairs).forEach(ints -> {
           System.out.println(ints[0]+" "+ints[1]);
       });
        System.out.println("#####################");
        Arrays.sort(pairs, (a,b)-> a[0]-b[0]);


        Arrays.stream(pairs).forEach(ints -> {
            System.out.println(ints[0]+" "+ints[1]);
        });


      int[] dp = new int[scores.length];
        //List<Integer> dp = new ArrayList<>();
            int count=0;
        for(int[] i: pairs)
            dp[count++] = i[0];
        System.out.println("#######");
       Arrays.stream(dp).forEach(System.out::println);


        for(int i=0;i< pairs.length;i++)
        {
            int maxScore = pairs[i][0];
            int maxAge = pairs[i][1];

            for(int j=0;j<i;j++)
            {
                int score = pairs[j][0];
                int age = pairs[j][1];

                if(maxAge>=age)
                {
                    dp[i] = Math.max(maxScore, maxScore+dp[j]);
                }
            }
        }

        return Arrays.stream(dp).reduce(-1,Integer::max);
    }


    public static void main(String[] args) {
        int[] scores = {1,15,20,10,15};
        int[] ages = {1,2,5,4,3};

        int res = bestTeamScore(scores,ages);
        System.out.println(res);
    }
}
