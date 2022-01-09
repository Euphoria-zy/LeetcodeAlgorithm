package com.zy.GreedyAlgorithm;

/*
 * code for class del_RepeatedLetters
 * @param null
 * 316. 去除重复字母【贪心算法+单调栈】
    给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2022/1/9 11:46
 **/
import java.util.Stack;

public class del_RepeatedLetters
{
    public static void main(String[] args)
    {
        String str = "cbacdcbc";
        String answer = Solution_VII.removeDuplicateLetters(str);
        System.out.println(answer);
    }
}
class Solution_VII
{
    public static String removeDuplicateLetters(String s)
    {
        int[] count = new int[27];
        Stack<Character> stack = new Stack<>();
        String result = "";
        int i,a,b;
        a = b =0;
        char ch1,ch2;
        for(i=0;i<27;i++)
        {
            count[i] = 0;
        }
        for(i=0 ;i<s.length();i++)                  //统计各字母出现次数
        {
            a = s.charAt(i) - 'a'+1;
            count[a]++;
        }
        a = 0;
        for(i = 0 ;i < s.length(); i++)
        {
            ch2 = s.charAt(i);
            b = ch2 - 'a'+1;
            if(!stack.contains(ch2))                //如果栈不包含当前字符，就入栈，并判断栈顶元素是否满足最小序
            {
                if (!stack.empty())                 //取栈顶元素
                {
                    ch1 = stack.peek();
                    a = ch1 - 'a' + 1;
                }
                while (b < a && count[a] > 1)           //若栈顶元素序列小于当前元素且后续字符串还有该元素，则出栈，直到栈顶元素满足
                {
                    if (!stack.empty())
                    {
                        stack.pop();
                        count[a]--;
                    }
                    if (!stack.empty())
                    {
                        ch1 = stack.peek();
                        a = ch1 - 'a' + 1;
                    } else
                        break;
                }
                stack.push(ch2);                            //当前元素入栈
            }
            else
                count[b]--;                                 //若当前元素未入栈，则计数减一
        }
        while (!stack.empty())              //栈元素出栈
        {
            result = stack.pop()+result;
        }
        return result;
    }
}