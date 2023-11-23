package com.zy.normalproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class queensAttacktheKing_Medium
{
    public static void main(String[] args)
    {
        int[][] queens = new int[][] {
                {0,1},{1,0},{4,0},{0,4},{3,3},{2,4}
        };
        int[] kings = new int[] {0,0};
        List<List<Integer>> lists = Solution_50.queensAttacktheKing(queens, kings);
        for (int i = 0; i < lists.size(); i++)
        {
            System.out.print(lists.get(i).get(0) + " " + lists.get(i).get(1));
        }

    }
}
class Solution_50 {
    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();
        int x = king[0];
        int y = king[1];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < queens.length; i++) {
            map.put(queens[i][0] +""+ queens[i][1],queens[i][1]);
        }
        //往上
        for(int i = x, j = y-1; j >= 0; j--) {
            if(map.containsKey(i +""+ j)) {
                ArrayList<Integer> temp = new ArrayList<>();
                System.out.println(i+" "+j);
                temp.add(i);temp.add(j);
                result.add(temp);
                break;
            }
        }
        //往下
        for(int i = x, j = y+1; j < 8; j++) {
            if(map.containsKey(i +""+ j)) {
                ArrayList<Integer> temp = new ArrayList<>();
                System.out.println(i+" "+j);
                temp.add(i);temp.add(j);
                result.add(temp);
                break;
            }
        }
        //往左
        for(int i = x-1, j = y; i >= 0; i--) {
            if(map.containsKey(i +""+ j)) {
                ArrayList<Integer> temp = new ArrayList<>();
                System.out.println(i+" "+j);
                temp.add(i);temp.add(j);
                result.add(temp);
                break;
            }
        }
        //往右
        for(int i = x+1, j = y; i < 8; i++) {
            if(map.containsKey(i +""+ j)) {
                ArrayList<Integer> temp = new ArrayList<>();
                System.out.println(i+" "+j);
                temp.add(i);temp.add(j);
                result.add(temp);
                break;
            }
        }
        //左上
        for(int i = x-1, j = y-1; j >= 0 && i >= 0; j--, i--) {
            if(map.containsKey(i +""+ j)) {
                ArrayList<Integer> temp = new ArrayList<>();
                System.out.println(i+" "+j);
                temp.add(i);temp.add(j);
                result.add(temp);
                break;
            }
        }
        //右下
        for(int i = x+1, j = y+1; j < 8 && i < 8; j++,i++) {
            if(map.containsKey(i +""+ j)) {
                ArrayList<Integer> temp = new ArrayList<>();
                System.out.println(i+" "+j);
                temp.add(i);temp.add(j);
                result.add(temp);
                break;
            }
        }
        //右上
        for(int i = x-1, j = y+1; j < 8 && i >= 0; j++, i--) {
            if(map.containsKey(i +""+ j)) {
                ArrayList<Integer> temp = new ArrayList<>();
                System.out.println(i+" "+j);
                temp.add(i);temp.add(j);
                result.add(temp);
                break;
            }
        }
        //左下
        for(int i = x+1, j = y-1; j >= 0 && i < 8; j--,i++) {
            if(map.containsKey(i +""+ j)) {
                ArrayList<Integer> temp = new ArrayList<>();
                System.out.println(i+" "+j);
                temp.add(i);temp.add(j);
                result.add(temp);
                break;
            }
        }
        return result;
    }
}