package com.java.learn;

import java.util.Arrays;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int [] out = new int[2];
        for(int i=0; i<nums.length-1; i++){
//            if(nums[i] <= target)
                for(int j=i+1;j<nums.length;j++){
                    if((nums[i] + nums[j]) == target){
                        out[0] = i;
                        out[1] = j;
                        break;
                    }
                }

        }
        return out;
    }

    public static void main(String[] args) {
        int[] arr = { -1,-2,-3,-4,-5 };
        System.out.println("input: "+ Arrays.toString(arr));
        System.out.println("output: "+Arrays.toString(twoSum(arr, -8)));
    }
}
