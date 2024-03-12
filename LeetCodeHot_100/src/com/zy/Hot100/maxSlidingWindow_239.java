package com.zy.Hot100;

import java.util.*;

/*
239. 滑动窗口最大值[优先队列、单调队列]
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回 滑动窗口中的最大值 。
* */
public class maxSlidingWindow_239 {
    public static void main(String[] args) {

    }
}
class Solution_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1;
        int[] answer = new int[m];
        //优先队列思路：1、采用大根堆可维护窗口元素大小顺序；窗口右移：如果最大元素为窗口左部的元素，则需要移除，再取堆顶元素作为窗口最大元素
        //时间复杂度：优先队列元素入队时间复杂度为O(logn)，最坏情况下，nums单调增，则最终所有元素入队，没有元素移除，则时间复杂度为O(nlogn),空间复杂度为O(n)
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
            }
        });
        for (int i = 0; i < k; i++) {
            queue.add(new int[] {nums[i], i});
        }
        answer[0] = queue.peek()[0];
        for (int i = k; i < n; i++) {
            queue.offer(new int[] {nums[i], i});
            //如果堆顶元素索引大于窗口左端索引，既不在滑动窗口中，则弹出，否则堆顶元素则为窗口的最大元素
            while (queue.peek()[1] <= i-k) {
                queue.poll();
            }
            answer[i-k+1] = queue.peek()[0];
        }
        return answer;
    }

    //单调队列：由于需要判断队尾元素，和队首元素，采用双端队列实现
    //分析：维持一个单调递减队列。1、对于窗口元素下标为i和j（i在j左侧）,如果nums[i]<nums[j]，则nums[i]不可能成为窗口最大元素，移除i；
    // 同时借鉴优先队列思路，队手元素为窗口最大元素，但同时也存在队首元素在窗口左部，也需要移除不在窗口的元素下标
    //时间复杂度为O(n)，空间复杂度为O(k)
    public int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int m = n-k+1;
        int[] answer = new int[m];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.pollLast();
            deque.addLast(i);
        }
        answer[0] = deque.peekFirst();
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast())
                deque.pollLast();
            deque.addLast(i);
            while (!deque.isEmpty() && deque.peekFirst() <= i-k)
                deque.pollFirst();
            answer[i-k+1] = deque.peekFirst();
        }
        return answer;
    }

}