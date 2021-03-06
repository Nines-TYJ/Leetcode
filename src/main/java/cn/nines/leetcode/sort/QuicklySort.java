package cn.nines.leetcode.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author nines
 */
public class QuicklySort {

    public static void main(String[] args) {
        int[] array = new int[]{5,4,3,7,9,11,-5,2,-10};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array){
        if (array == null || array.length <= 1){
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int left, int right){
        if (left >= right){
            return;
        }
        int pivotIndex = left + new Random().nextInt(right - left + 1);
        swap(array, pivotIndex, right);
        int i = left;
        int j = right - 1;
        while (i <= j){
            if (array[i] <= array[right]){
                i++;
            }else {
                swap(array, i, j--);
            }
        }
        swap(array, i, right);

        // 递归 左边
        quickSort(array, left, i - 1);
        // 右边
        quickSort(array, i + 1, right);
    }

    /**
     * 交换
     */
    public static void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

}
