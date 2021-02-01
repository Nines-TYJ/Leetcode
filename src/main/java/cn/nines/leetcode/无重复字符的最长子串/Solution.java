package cn.nines.leetcode.无重复字符的最长子串;

import java.util.*;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author TYJ
 * @date 2021/1/26 9:38
 */
public class Solution {

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s){
        int n = s.length();
        if (n <= 1){
            return n;
        }
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < n;) {
            if (map.containsKey(s.charAt(end))){
                map.remove(s.charAt(start));
                start++;
            }else {
                map.put(s.charAt(end), end);
                end++;
                max = Math.max(max, end - start);
            }
            if (end == n){
                break;
            }
        }
        return max;
    }

}
