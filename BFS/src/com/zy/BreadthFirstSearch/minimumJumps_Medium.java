package com.zy.BreadthFirstSearch;
/*
 * code for class minimumJumps
 * @param null
 * @Description: 1654. 到家的最少跳跃次数
    有一只跳蚤的家在数轴上的位置 x 处。请你帮助它从位置 0 出发，到达它的家。跳蚤跳跃的规则如下：
        它可以 往前 跳恰好 a 个位置（即往右跳）。
        它可以 往后 跳恰好 b 个位置（即往左跳）。
        它不能 连续 往后跳 2 次。
        它不能跳到任何 forbidden 数组中的位置。
        跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2023/8/30 16:00
 **/
import java.util.*;

public class minimumJumps_Medium
{
    public static void main(String[] args)
    {
        int[] forbidden = new int[] {1,6,2,14,5,17,4};
        int a = 16;
        int b = 9;
        int x = 7;
        int result = Solution_36.minimumJumps(forbidden, a, b, x);
        System.out.println(result);
    }
}
class Solution_36
{
    public static int minimumJumps(int[] forbidden, int a, int b, int x)  //a往右，b往左
    {
        Arrays.sort(forbidden);
        int lower = 0;
        int upper = Math.max(forbidden[forbidden.length-1]+a, x) +b;
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int i = 0; i < forbidden.length; i++){
            forbiddenSet.add(forbidden[i]);
        }
        Set<Integer> visitable = new HashSet<>();
        visitable.add(0);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 1, 0}); //{position, direction, step}
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int position = arr[0]; int direction = arr[1]; int step = arr[2];
            if (position == x)
                return step;
            //往右走
            int nextPosition = position + a; int nextDirection = 1; int nextStep = step + 1;
            if (lower <= nextPosition && nextPosition <= upper &&
                    !visitable.contains(nextPosition * nextDirection) && !forbiddenSet.contains(nextPosition)) {
                visitable.add(nextPosition * nextDirection);
                queue.offer(new int[] { nextPosition, nextDirection, nextStep});
            }
            //往左走
            if (direction == 1) {
                nextPosition = position - b; nextDirection = -1; nextStep = step + 1;
                if (lower <= nextPosition && nextPosition <= upper &&
                        !visitable.contains(nextPosition * nextDirection) && !forbiddenSet.contains(nextPosition)) {
                    visitable.add(nextPosition * nextDirection);
                    queue.offer(new int[] { nextPosition, nextDirection, nextStep});
                }
            }
        }
        return -1;
    }
}