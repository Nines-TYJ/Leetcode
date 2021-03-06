package cn.nines.leetcode.topic.水位上升的泳池中游泳;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *
 * 778. 水位上升的泳池中游泳
 *
 * 在一个 N x N 的坐标方格grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
 *
 * 现在开始下雨了。当时间为t时，此时雨水导致水池中任意位置的水位为t。
 * 你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。
 * 假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
 * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台(N-1, N-1)？
 *
 * @author TYJ
 * @date 2021/1/30 15:50
 */
public class Solution {

    public static void main(String[] args) {

    }

    public int swimInWater(int[][] grid){
        int x = 0;
        int y = 0;
        int max = grid[x][y];
        String from = "";
        while (x == grid[0].length - 1 && y == grid.length - 1){
            Map<String, Integer> map = new HashMap<>();
            map.put("top", y - 1 >= 0 ? grid[x][y - 1] : -1);
            map.put("down", y + 1 < grid.length ? grid[x][y + 1] : -1);
            map.put("left", x - 1 >= 0 ? grid[x - 1][y] : -1);
            map.put("right", x + 1 < grid[0].length ? grid[x + 1][y] : -1);
            Optional<String> minKey = map.keySet().stream().filter(key -> !key.equals(from) && map.get(key) != -1).min(Comparator.comparing(map::get));
        }
        return 0;
    }

}
