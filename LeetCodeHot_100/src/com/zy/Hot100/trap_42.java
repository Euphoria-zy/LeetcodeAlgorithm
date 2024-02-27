package com.zy.Hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/*
*42. 接雨水: 动态规划、单调栈
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
* */
public class trap_42 {
    public static void main(String[] args) {
        int[] height = new int[] {
                4,2,0,3,2,5
        };
        int result = Solution_42.trap(height);
        System.out.println(result);
    }
}

class Solution_42 {
    public static int trap(int[] height) {
        //分析：动态规划
        // 1、对于第i个位置，能接的雨水的多少等于i位置雨水能到的最大高度-height[i]
        // 2、对于第i个位置，雨水能到达的最大高度，等于向左和向右扫描的最大height
        // 3、对于第i个位置，向左的最大高度等于max(height[i],leftMax[i-1])
        // 4、对于第i个位置，向右的最大高度等于max(height[i],rightMax[i+1])
        //对数组正向和反向遍历可得到leftMax和rightMax
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int sum = 0;
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        for (int i = 0; i < n; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        //return sum;

        //单调栈:
        //1、维持一个单调栈，栈中单调减，即栈底为left，栈顶为top,则当栈在height[i]开始递增时，即height[i]>height[top]，可计算一次栈中的接水量.只有top位置可存水
        //2、雨水量计算：宽度：i-left-1，高度min(height[left], height[i])-height[top]，只有top位置可存水
        //3、计算一次后，弹出top，left称为新的top，重复2的计算直到栈为空

        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int left = stack.peek();
                int width = i - left - 1;
                int high = Math.min(height[left], height[i]) - height[top];
                ans += width * high;
            }
            stack.push(i);
        }
        return ans;
    }
}
