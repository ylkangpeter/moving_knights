package com.peter.mk;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MovingKnights {

    private static void knights(int num) {

        int[] arr = new int[num * 2 + 1];
        // init the array
        for (int i = 0; i < num; i++) {
            arr[i] = 1;
        }

        for (int i = num + 1; i <= 2 * num; i++) {
            arr[i] = 2;
        }

        final int TOTAL_STEPS = num * num + 2 * num;

        int cur = num;
        boolean t_right = true;

        // there is a pattern:
        // mjmjjmjjjmjjmjjmj for 3 knights
        // mjmjjmjm for 2 knights
        int[] pattern = new int[TOTAL_STEPS];

        int k = 0;
        int group = 1;

        pattern[k] = 1;
        while (k < TOTAL_STEPS - 1) {
            int repeat = num - Math.abs(num - group);
            for (int j = 0; j < repeat; j++) {
                pattern[++k] = 2;
            }
            pattern[++k] = 1;
            group++;
        }

        printArr(arr, 0);

        for (int i = 0; i < pattern.length; i++) {
            if (t_right) {
                if (pattern[i] == 1) {
                    if (cur + pattern[i] < arr.length && (arr[cur + pattern[i]] == 2)) {
                        arr[cur] = arr[cur + 1];
                        arr[cur + 1] = 0;
                        cur = cur + 1;
                    } else {
                        t_right = false;
                        arr[cur] = arr[cur - 1];
                        arr[cur - 1] = 0;
                        cur = cur - 1;
                    }
                } else {
                    if (cur + pattern[i] < arr.length && (arr[cur + 1] == 1)) {
                        arr[cur] = arr[cur + 2];
                        arr[cur + 2] = 0;
                        cur = cur + 2;
                    } else {
                        t_right = false;
                        arr[cur] = arr[cur - 2];
                        arr[cur - 2] = 0;
                        cur = cur - 2;
                    }
                }
            } else {
                if (pattern[i] == 1) {
                    if (cur - pattern[i] >= 0 && (arr[cur - pattern[i]] == 1)) {
                        arr[cur] = arr[cur - 1];
                        arr[cur - 1] = 0;
                        cur = cur - 1;
                    } else {
                        t_right = true;
                        arr[cur] = arr[cur + 1];
                        arr[cur + 1] = 0;
                        cur = cur + 1;
                    }
                } else {
                    if (cur - pattern[i] >= 0 && (arr[cur - 1] == 2)) {
                        arr[cur] = arr[cur - 2];
                        arr[cur - 2] = 0;
                        cur = cur - 2;
                    } else {
                        t_right = true;
                        arr[cur] = arr[cur + 2];
                        arr[cur + 2] = 0;
                        cur = cur + 2;
                    }
                }
            }

            printArr(arr, i + 1);
        }

    }

    private static void printArr(int[] arr, int steps) {
        System.out.print("\n" + steps + "\t");
        Arrays.stream(arr)
                .forEach(System.out::print);
    }

    public static void main(String[] args) {
        knights(2);
        knights(3);
        knights(4);
        knights(5);

    }
}