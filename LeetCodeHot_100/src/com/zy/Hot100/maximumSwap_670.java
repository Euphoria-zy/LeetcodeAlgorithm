package com.zy.Hot100;

import java.util.ArrayList;

/**
 * @Description: 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 */
public class maximumSwap_670 {
    public static void main(String[] args) {
        int result = Solution_670.maximumSwap(98368);
        System.out.println(result);
    }
}
class Solution_670 {
    public static int maximumSwap(int num) {
        //得到最大的数字
        int m = num;
        int i = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        //取每一位的数字
        while (m > 0) {
            int n = m % 10;
            m = m / 10;
            numbers.add(n);
            i++;
        }
        //只有一位数
        if (numbers.size() == 1)
            return num;
        int[] intNumber = new int[numbers.size()];
        for (int j = 0; j < numbers.size(); j++) {
            intNumber[j] = numbers.get(j);
        }
        //寻找要交换的数字
        for (int j = intNumber.length-1; j >=1 ; j--) {
            int maxValue = -1;
            int maxIndex = -1;
            for (int k = j-1; k >= 0; k--) {
                //相同的数字，优先交换小的位置
                if (maxValue <= intNumber[k]) {
                    maxIndex = k;
                    maxValue = intNumber[k];
                }
            }
            if (intNumber[j] < maxValue) {
                int temp = intNumber[j];
                intNumber[j] = intNumber[maxIndex];
                intNumber[maxIndex] = temp;
                break;
            }
        }
        int sum = 0;
        i = 0;
        for(int value : intNumber) {
            sum += (int) (value * Math.pow(10, i));
            i++;
        }
        return sum;
    }

}