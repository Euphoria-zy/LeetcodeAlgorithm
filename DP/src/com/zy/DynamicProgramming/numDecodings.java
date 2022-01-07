package com.zy.DynamicProgramming;

/*
 * code for class numDecodings
 * @param String s：传入一个数字字符串
 * 91. 解码方法【动态规划】——中等难度
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/1/7 20:52
 **/
public class numDecodings
{
    public static void main(String[] args)
    {
        String inital_code = "06";
        int result = Solution_V.numDecodings(inital_code);
        System.out.println(result);

    }
}
class Solution_V
{
    public static int numDecodings(String s)
    {
        int[] dp = new int[s.length()];
        int i,a,b,c;
        a = s.charAt(0) - '0';
        if(a>0)                           //第一位不是0，则为一组合
            dp[0] = 1;
        else                              //第一种是0
            dp[0] = 0;
        for(i=1; i<s.length() ;i++)
        {
            a = s.charAt(i) - '0';
            b = s.charAt(i-1) - '0';
            c = b*10+a;
            int sum1 ,sum2;
            sum1 = sum2 = 0;
            if(a>0)            //考察当前位置的组合,一位数字只会在0-9之间，则肯定满足情况
                sum1 = dp[i-1];
            if(b!=0 && c>0 && c<=26)   //考察当前位置和前一位的组合；且对于06这种组合，不予判断
            {
                if (i > 1)             //考察2,24这种组合
                    sum2 = dp[i - 2];
                if (i == 1)            //考察22这种组合
                    sum2 = 1;
            }
            dp[i] = sum1+sum2;         //两种情况相加
        }
        return dp[s.length()-1];
    }
}
