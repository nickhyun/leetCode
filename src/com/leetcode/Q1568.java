package com.leetcode;

/***
 1568. Minimum Number of Days to Disconnect Island

 You are given an m x n binary grid grid where 1 represents land and 0 represents water. An island is a maximal 4-directionally (horizontal or vertical) connected group of 1's.
 The grid is said to be connected if we have exactly one island, otherwise is said disconnected.
 In one day, we are allowed to change any single land cell (1) into a water cell (0).
 Return the minimum number of days to disconnect the grid.
 */
public class Q1568 extends QBase{

    public static void main(String[] args){
        Q1568 q = new Q1568();
        log(q.minDays(new int[][]{
                {0,1,1,0},
                {0,1,1,0},
                {0,0,0,0}
        })); // 2

        log(q.minDays(new int[][]{
                {1, 1}
        })); // 2

    }

    public int minDays(int[][] grid) {



        return -1;
    }

    public boolean isIsland(int[][] grid, int x, int y){
        if(grid[x][y] == 1) {
            if(x-1 >= 0             && grid[x-1][y] == 1) return true;
            if(x+1 < grid.length    && grid[x+1][y] == 1) return true;
            if(y-1 >= 0             && grid[x][y-1] == 1) return true;
            if(y+1 < grid[0].length && grid[x][y+1] == 1) return true;
        }
        return false;
    }


}
