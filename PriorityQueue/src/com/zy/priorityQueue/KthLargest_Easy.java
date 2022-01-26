package com.zy.priorityQueue;
/*
 * code for class KthLargest_Easy
 * @param null
 * 703. 数据流中的第 K 大元素 【优先队列】
    设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2022/1/26 15:19
 **/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest_Easy
{
    public static void main(String[] args)
    {
        int k = 3;
        int[] num = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k,num);
        int ob1 = kthLargest.add(3);
        System.out.println(ob1);

        int ob2 = kthLargest.add(5);
        System.out.println(ob2);

        int ob3 = kthLargest.add(10);
        System.out.println(ob3);

        int ob4 = kthLargest.add(9);
        System.out.println(ob4);

        int ob5 = kthLargest.add(4);
        System.out.println(ob5);
    }
}

//优先队列
class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
/*
class KthLargest
{
    public int target;
    public ArrayList<Integer> answer = new ArrayList<>();
    public KthLargest(int k, int[] nums)
    {
        this.target = k;
        for (int i = 0; i < nums.length; i--)
        {
            answer.add(nums[i]);
        }
    }

    public int add(int val)
    {
        answer.add(val);
        int[] num = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++)
        {
            num[i] = answer.get(i);
        }
        Arrays.sort(num);
        answer.clear();
        for (int i = num.length-1; i>= 0; i--)
        {
            answer.add(num[i]);
        }
        return answer.get(target-1);
    }
}*/
