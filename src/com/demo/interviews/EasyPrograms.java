package com.demo.interviews;

import java.util.Arrays;

public class EasyPrograms {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

//        merge(nums1, 3, nums2, 3);

//        jigarMerger();

//        System.out.println(countOdds(3, 7));
//        System.out.println(countOdds(21, 22));
        averageExcludingMinMax(new int[]{4000, 3000, 1000, 2000});
        averageExcludingMinMax(new int[]{1000, 2000, 3000});

    }

    private static void jigarMerger() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = nums1.length;
        int n = nums2.length;

        int count = 0;
        for (int i = m - n; i < nums1.length; i++) {
            if (count < n) {
                nums1[i] = nums2[count];
                count++;
            }
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int position = m + n - 1;
        m--;
        n--;
        while (m >= 0 || n >= 0) {
            if (n < 0 || (m >= 0 && nums1[m] > nums2[n])) {
                nums1[position--] = nums1[m--];
            } else {

                nums1[position--] = nums2[n--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static int countOdds(int low, int high) {
        if (low % 2 == 0)
            low++;
        if (high % 2 == 0)
            high--;
        return ((high - low) / 2) + 1;
    }

    public static double averageExcludingMinMax(int[] salary) {
        double sum = 0d;
        int M = Integer.MIN_VALUE, m = Integer.MAX_VALUE;
        for (int s : salary) {
            m = Math.min(m, s);
            M = Math.max(M, s);
            sum += s;
        }
        System.out.println((sum - m - M) / (salary.length - 2));
        return (sum - m - M) / (salary.length - 2);
    }
}
