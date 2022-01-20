package com.zy.BreadthFirstSearch;

/*
 * code for class islandPerimeter_Easy
 * @param null
 * 463. 岛屿的周长【DFS】
    给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
    计算这个岛屿的周长。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2022/1/20 13:53
 **/
public class islandPerimeter_Easy
{
    public static void main(String[] args)
    {
        int[][] grid = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        Solution_19 solution_19 = new Solution_19();
        int result = solution_19.islandPerimeter(grid);
        System.out.println(result);
    }
}
class Solution_19
{
    public int islandPerimeter(int[][] grid)
    {
        int sum = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] != 0)
                {
                    if (i-1>=0 && grid[i-1][j] == 0)
                        sum += 1;
                    if (i+1<grid.length && grid[i+1][j] == 0)
                        sum += 1;
                    if (j+1<grid[0].length && grid[i][j+1] == 0)
                        sum += 1;
                    if (j-1>=0 && grid[i][j-1] == 0)
                        sum += 1;
                    if (i == 0 )
                        sum += 1;
                    if( i == grid.length-1)
                        sum += 1;
                    if (j == 0 )
                        sum += 1;
                    if( j == grid[0].length-1)
                        sum += 1;
                }
            }
        }
        return sum;
    }
}