package algorithms;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Q4 {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        double median = 0;
        int[] nums3 = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            nums3[i] = nums1[i];
        }
        for (int i = 0; i < n2; i++) {
            nums3[n1 + i] = nums2[i];
        }
        Arrays.sort(nums3);
//        System.out.println(nums3);
//        for (int i = 0; i < nums3.length; i++) {
//            System.out.print(nums3[i] + " ");
//        }
        int n3 = nums3.length;
        if (n3 % 2 == 0) {
//            System.out.println(nums3[n3 / 2] + "," + nums3[n3 / 2 + 1]);
            median = (double) (nums3[n3 / 2 - 1] + nums3[n3 / 2]) / 2;

        } else {
            median = (double) (nums3[n3 / 2]);
        }
        return median;

    }

    public static void main(String[] args) {
        int[] nums1 = {2};
        int[] nums2 = {};
        Q4 q = new Q4();
        double median = q.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}


