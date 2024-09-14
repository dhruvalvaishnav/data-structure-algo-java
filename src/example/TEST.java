package example;

import java.util.Arrays;

/**
 * @author Dhruval Vaishnav Created on 21-02-2024
 */
public class TEST {
    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 2, 0, 0, 0, 0};
        int zeroEleFromNums1 = (int) Arrays.stream(nums1).filter(x -> x == 0).count();
        int[] nums2 = new int[]{3, 5, 6, 8};

        merge(nums1, zeroEleFromNums1, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[index] = nums1[m - 1];
                m--;
            } else {
                nums1[index] = nums2[n - 1];
                n--;
            }
            index--;
        }
        //Arrays.sort(nums1);
    }
}
