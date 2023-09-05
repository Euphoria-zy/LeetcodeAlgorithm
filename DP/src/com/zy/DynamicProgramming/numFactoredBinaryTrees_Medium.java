package com.zy.DynamicProgramming;
/*
 * code for class numFactoredBinaryTrees_Medium
 * @param null
 * @Description :823. 带因子的二叉树[动态规划]
 * 给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。用这些整数来构建二叉树，每个整数可以使用任意次数。
 * 其中：每个非叶结点的值应等于它的两个子结点的值的乘积。满足条件的二叉树一共有多少个？答案可能很大，返回 对 109 + 7 取余 的结果。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2023/8/29 20:27
 **/
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class numFactoredBinaryTrees_Medium
{
    public static void main(String[] args)
    {
        int[] arr = new int[] {2, 4};
        int result = Solution_35.numFactoredBinaryTrees(arr);
        System.out.println(result);
    }

}
class Solution_35 {
    public static int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        //只有一个结点
        if(n == 1) {
            return 1;
        }
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {

        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; arr[j] <= Math.sqrt(arr[i]); j++) {
                for (int k = 0; k < i; k++) {
                    if ((arr[i] % arr[j]) == 0 && (arr[i] / arr[j]) == arr[k] && arr[j] != arr[k]) {
                        dp[i] += 2*(1 + dp[j]-1 + dp[k]-1 + (dp[j]-1) * (dp[k]-1)); //2*（1+左子树+右子树+左右子树）：2,3-3,2两种不同的二叉树
                    }
                    if ((arr[i] % arr[j]) == 0 && (arr[i] / arr[j]) == arr[k] && arr[j] == arr[k]){
                        dp[i] += 1 + 2 * (dp[j]-1) + (dp[j]-1) * (dp[j]-1); //1+左子树+右子树+左右子树
                    }
                }
            }
        }
        long sum = 0;
        long a = (long) (Math.pow(10, 9) + 7);
        for (int i = 0; i < n; i++) {
            sum += dp[i];
        }
        return (int) (sum % a);
    }
}