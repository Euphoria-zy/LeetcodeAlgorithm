package com.zy.normalproblem;
/*
 * code for class filterRestaurants_Medium
 * @param null
 * @Description
    1333. 餐厅过滤器[数组，排序]
 * @version 1.0.0
 * @return 
 * @author Zhou Yun
 * @date 2023/9/27 17:17
 **/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class filterRestaurants_Medium
{
    public static void main(String[] args)
    {
        int[][] restaurants = new int[][] {
                {3664,99814,1,77091,21028},
                {47368,99814,1,88577,16986}
        };
        int veganFriendly = 1;
        int maxPrice = 89877;
        int maxDistance = 58259;
        List<Integer> integers = Solution_55.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance);
        for (Integer value : integers)
            System.out.print(value + " ");
    }
}
class Solution_55 {
    public static List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<List<Integer>> temp = new ArrayList<>();
        for(int i = 0; i < restaurants.length; i++) {
            if(!(restaurants[i][2] == 0 && veganFriendly == 1) && restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                List<Integer> ans = new ArrayList<>();
                ans.add(restaurants[i][0]);
                ans.add(restaurants[i][1]);
                temp.add(new ArrayList<>(ans));
            }
        }
        Collections.sort(temp, (a, b)-> {
            if(a.get(1).intValue() != b.get(1).intValue()) {
                return b.get(1) - a.get(1);
            } else {
                return b.get(0) - a.get(0);
            }
        });
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < temp.size(); i++) {
            result.add(temp.get(i).get(0));
        }
        return result;
    }
}