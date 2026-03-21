package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * SortService 测试类
 */
public class SortServiceTest {

    private final SortService sortService = new SortService();

    @Test
    @DisplayName("测试空数组")
    public void testEmptyArray() {
        int[] arr = {};
        int[] result = sortService.bubbleSort(arr);
        assertArrayEquals(arr, result);
    }

    @Test
    @DisplayName("测试null数组")
    public void testNullArray() {
        int[] arr = null;
        int[] result = sortService.bubbleSort(arr);
        assertNull(result);
    }

    @Test
    @DisplayName("测试单元素数组")
    public void testSingleElement() {
        int[] arr = {5};
        int[] result = sortService.bubbleSort(arr);
        assertArrayEquals(new int[]{5}, result);
    }

    @Test
    @DisplayName("测试已排序数组")
    public void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = sortService.bubbleSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result);
    }

    @Test
    @DisplayName("测试逆序数组")
    public void testReverseOrder() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] result = sortService.bubbleSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result);
    }

    @Test
    @DisplayName("测试随机数组")
    public void testRandomArray() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] result = sortService.bubbleSort(arr);
        assertArrayEquals(new int[]{11, 12, 22, 25, 34, 64, 90}, result);
    }

    @Test
    @DisplayName("测试重复元素数组")
    public void testDuplicateElements() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        int[] result = sortService.bubbleSort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3, 4, 5, 5, 6, 9}, result);
    }

    @Test
    @DisplayName("测试负数数组")
    public void testNegativeNumbers() {
        int[] arr = {3, -1, 4, -5, 2};
        int[] result = sortService.bubbleSort(arr);
        assertArrayEquals(new int[]{-5, -1, 2, 3, 4}, result);
    }

    @Test
    @DisplayName("测试优化版冒泡排序")
    public void testOptimizedBubbleSort() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] result = sortService.bubbleSortOptimized(arr);
        assertArrayEquals(new int[]{11, 12, 22, 25, 34, 64, 90}, result);
    }

    @Test
    @DisplayName("验证原始数组不被修改")
    public void testOriginalArrayUnchanged() {
        int[] original = {5, 4, 3, 2, 1};
        int[] arr = original.clone();

        sortService.bubbleSort(arr);

        // 原始数组应该保持不变
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, original);
    }
}
