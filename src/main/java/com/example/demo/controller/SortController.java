package com.example.demo.controller;

import com.example.demo.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 排序控制器
 */
@RestController
@RequestMapping("/api/sort")
public class SortController {

    @Autowired
    private SortService sortService;

    /**
     * 冒泡排序接口
     *
     * @param request 包含数组的数据
     * @return 排序结果
     */
    @PostMapping("/bubble")
    public Map<String, Object> bubbleSort(@RequestBody Map<String, int[]> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            int[] array = request.get("array");
            if (array == null || array.length == 0) {
                response.put("success", false);
                response.put("message", "数组不能为空");
                return response;
            }

            long startTime = System.nanoTime();
            int[] sorted = sortService.bubbleSort(array);
            long endTime = System.nanoTime();

            response.put("success", true);
            response.put("original", array);
            response.put("sorted", sorted);
            response.put("time", (endTime - startTime) / 1000000.0 + " ms");

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }

        return response;
    }

    /**
     * 冒泡排序接口（优化版）
     *
     * @param request 包含数组的数据
     * @return 排序结果
     */
    @PostMapping("/bubble-optimized")
    public Map<String, Object> bubbleSortOptimized(@RequestBody Map<String, int[]> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            int[] array = request.get("array");
            if (array == null || array.length == 0) {
                response.put("success", false);
                response.put("message", "数组不能为空");
                return response;
            }

            long startTime = System.nanoTime();
            int[] sorted = sortService.bubbleSortOptimized(array);
            long endTime = System.nanoTime();

            response.put("success", true);
            response.put("original", array);
            response.put("sorted", sorted);
            response.put("time", (endTime - startTime) / 1000000.0 + " ms");

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }

        return response;
    }

    /**
     * 生成随机数组用于测试
     *
     * @param size 数组大小
     * @return 随机数组
     */
    @GetMapping("/random")
    public Map<String, Object> generateRandomArray(@RequestParam(defaultValue = "10") int size) {
        Map<String, Object> response = new HashMap<>();

        try {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = (int) (Math.random() * 100);
            }

            response.put("success", true);
            response.put("array", array);
            response.put("size", size);

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }

        return response;
    }
}
