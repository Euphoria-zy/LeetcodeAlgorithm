package com.zy.GreedyAlgorithm;

/*
 * code for class longestPalindrome_Easy
 * @param null
 * 409. 最长回文串【贪心算法】。给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
    在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2022/1/8 10:08
 **/
public class longestPalindrome_Easy
{
    public static void main(String[] args)
    {
        String str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        int result = Solution_VI.longestPalindrome(str);
        System.out.println(result);
    }
}
class Solution_VI
{
    public static int longestPalindrome(String s)
    {
        int[] count = new int[53];
        int i,a;
        int length,maxOdd;
        length = maxOdd = 0;
        for(i=0;i<53;i++)
            count[i] = 0;
        for(i=0;i<s.length();i++)                 //基于计数排序思想，统计字符出现次数
        {
            if(Character.isLowerCase(s.charAt(i)))
                a = (s.charAt(i) - 'a')+1;
            else
                a = (s.charAt(i) - 'A')+27;
            count[a]++;
        }
        boolean flag = false;
        for (i=1; i<53;i++)
        {
            if(count[i]%2 == 0)            //如果出现次数为偶数，则直接加上
                length += count[i];
            else                           //如果为计数，则加上本身次数减一，同时说明最后的最长回文串肯定有一个字符出现奇数次，结果长度再加一
            {
                flag = true;
                length += count[i] - 1;
            }
        }
        if (flag)
            length++;
        return length;
    }
}