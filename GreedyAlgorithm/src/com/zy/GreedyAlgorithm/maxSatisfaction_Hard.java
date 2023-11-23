package com.zy.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class maxSatisfaction_Hard
{
    public static void main(String[] args)
    {
        int[] satisfaction = new int[] {
                -1,-8,0,5,-7
        };
        int result = Solution_56.maxSatisfaction(satisfaction);
        System.out.println(result);
    }
}

class Solution_56 {
    public static int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        ArrayList<Integer> negativeNum = new ArrayList<>();
        int activeSatisfaction = 0;
        int sumActiveNum = 0;
        int count = 1;
        for(int i = 0; i < satisfaction.length; i++) {
            if(satisfaction[i] < 0) {
                negativeNum.add(satisfaction[i]);
            } else {
                activeSatisfaction += satisfaction[i] * count; //10
                sumActiveNum += satisfaction[i];  //5
                count++;
            }
        }
        count = 1;
        int maxSatisfaction = activeSatisfaction;
        int sumNegativeNum = 0;
        int negativeSatisfaction = 0;
        for(int i = negativeNum.size()-1; i >= 0; i--) {
            int valueOfI = negativeNum.get(i);
            sumNegativeNum += valueOfI;
            if( negativeSatisfaction + sumNegativeNum + sumActiveNum * count + activeSatisfaction > maxSatisfaction) {
                maxSatisfaction = negativeSatisfaction + sumNegativeNum + sumActiveNum * count + activeSatisfaction;
                negativeSatisfaction += sumNegativeNum;
                count++;
            } else {
                sumNegativeNum -= valueOfI;
            }
        }
        return maxSatisfaction;

    }
}