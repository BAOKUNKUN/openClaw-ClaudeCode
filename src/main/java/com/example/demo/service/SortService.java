package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * 排序服务
 */
@Service
public class SortService {

    /**
     * 冒泡排序
     *
     * @param arr 待排序数组
     * @return 排序后的数组
     */
    public int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        int n = arr.length;
        int[] result = Arrays.copyOf(arr, n);

        // 冒泡排序主循环
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // 每次将最大的元素冒泡到最后
            for (int j = 0; j < n - i - 1; j++) {
                if (result[j] > result[j + 1]) {
                    // 交换相邻元素
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                    swapped = true;
                }
            }

            // 如果这一轮没有交换，说明已经有序
            if (!swapped) {
                break;
            }
        }

        return result;
    }

    /**
     * 冒泡排序（优化版，记录已排序位置）
     *
     * @param arr 待排序数组
     * @return 排序后的数组
     */
    public int[] bubbleSortOptimized(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        int n = arr.length;
        int[] result = Arrays.copyOf(arr, n);

        int lastSwap = 0;
        int sortBorder = n - 1;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < sortBorder; j++) {
                if (result[j] > result[j + 1]) {
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                    swapped = true;
                    lastSwap = j;
                }
            }

            sortBorder = lastSwap;

            if (!swapped) {
                break;
            }
        }

        return result;
    }
}
