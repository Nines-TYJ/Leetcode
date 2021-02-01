package cn.nines.leetcode.寻找两个正序数组的中位数;

import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * 给定两个大小为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 * @author TYJ
 * @date 2021/1/26 11:51
 */
public class Solution {

    public static void main(String[] args) {
        int [] nums1 = new int[]{1,3};
        int [] nums2 = new int[]{2,4};
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }


    /**
     * 归并排序法
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int i, j, k = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 == 0){
            if (l2 % 2 == 0){
                return (nums2[l2 / 2] + nums2[l2 / 2 - 1]) / 2.0;
            }
            return nums2[l2 / 2];
        }
        if (l2 == 0){
            if (l1 % 2 == 0){
                return (nums1[l1 / 2] + nums1[l1 / 2 - 1]) / 2.0;
            }
            return nums1[l1 / 2];
        }
        // 归并排序
        int[] num = new int[l1 + l2];
        for (i = 0, j = 0; i < l1 && j < l2;) {
            if (nums1[i] < nums2[j]){
                num[k++] = nums1[i++];
            }else {
                num[k++] = nums2[j++];
            }
        }
        while (i < l1){
            num[k++] = nums1[i++];
        }
        while (j < l2){
            num[k++] = nums2[j++];
        }
        System.out.println(Arrays.toString(num));
        int ln = num.length;
        if (ln % 2 == 0){
            return (num[ln / 2] + num[ln / 2 - 1]) / 2.0;
        }
        return num[ln / 2];
    }

}
