package org.example;


import java.util.Arrays;
import java.util.function.BiFunction;


public class Product_of_Array_Except_Self_238 {
    public static int[] productExceptSelf(int[] nums)
    {
        int[] leftProducts = new int[nums.length];
        int[] rightProducts = new int[nums.length];

        leftProducts[0] = 1;
        rightProducts[nums.length-1] = 1;

        for(int i=1;i<nums.length;i++)
        {
            leftProducts[i] = leftProducts[i-1]*nums[i-1];
        }
      Arrays.stream(leftProducts).forEach(System.out::print);


        for(int i= nums.length-2; i>=0 ;i--)
        {
            rightProducts[i] = rightProducts[i+1]*nums[i+1];
        }
        System.out.println( );
     Arrays.stream(rightProducts).forEach(System.out::println);


        BiFunction<int[],int[],int[]> mul = (x,y) -> {
            int res[] = new int[x.length];
           for(int i=0; i<x.length;i++) res[i] = x[i]*y[i];

           return  res;

        };
        return  mul.apply(leftProducts,rightProducts);
        };



    public static void main(String[] args) {
        int arr[]= {1,2,3,4};

      //  productExceptSelf(arr);
        Arrays.stream(productExceptSelf(arr)).forEach(System.out::println);
    }
}
