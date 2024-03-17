package com.zy.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
406. 根据身高重建队列
假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
//对身高进行降序排列，对同等身高，按排名进行升序排序。排序完成后，在对排序后的数组按名次排序
* */
public class reconstructQueue_406 {
    public static void main(String[] args) {

    }
}

class Solution_406 {
    public int[][] reconstructQueue(int[][] people) {
        int m,n;
        m=people.length;
        n=people[0].length;
        int[][] result=new int[m][n];
        Comparator<int[]> comparator=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if(o1[0]==o2[0] && o1[1]>o2[1])
                    return 1;
                else if(o1[0]==o2[0] && o1[1]<o2[1])
                    return -1;
                else if(o1[0]<o2[0])
                    return 1;
                else
                    return -1;
            }
        };
        Arrays.sort(people,comparator);
        List<int[]> answer=new ArrayList<int[]>();
        for(int[] value:people)
        {
            answer.add(value[1],value);
        }
        for(int i=0;i<result.length;i++)
        {
            result[i]=answer.get(i);
        }
        return result;
    }
}