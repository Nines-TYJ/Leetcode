package cn.nines.leetcode.topic.避免重复字母的最小删除成本;

/**
 * 1578. 避免重复字母的最小删除成本
 *给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
 * 返回使字符串任意相邻两个字母不相同的最小删除成本。
 * 请注意，删除一个字符后，删除其他字符的成本不会改变。

 * @author TYJ
 * @date 2021/1/26 15:46
 */
public class Solution {

    public static void main(String[] args) {
        String s = "cddcdcae";
        int[] cost = new int[]{4,8,8,4,4,5,4,2};
        System.out.println(minCost(s, cost));
    }

    public static int minCost(String s, int[] cost){
        // j永远比i大
        int i = 0, j = 1;
        int sum = 0;
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)){
                // 前后相等
                if (cost[i] < cost[j]){
                    // cost[i]值小，记录，i后移到j的位置，j后移1位
                    sum += cost[i];
                    // i，j同时向后移1位
                    i = j++;
                }else {
                    // cost[j]值小，记录，i不动，j后移1位
                    sum += cost[j++];
                }
            }else {
                // 前后不等，i，j同时向后移1位
                i = j++;
            }
        }
        return sum;
    }

}
