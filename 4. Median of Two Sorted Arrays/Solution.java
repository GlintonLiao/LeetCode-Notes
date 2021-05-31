class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int targetIndex = totalLength / 2;

        double[] sortedArr = new double[targetIndex + 1];
        int ptr1 = 0;
        int ptr2 = 0;

        for (int i = 0; i <= targetIndex; i += 1) {

            if (ptr1 < nums1.length && ptr2 < nums2.length) {

                if (nums1[ptr1] <= nums2[ptr2]) {
                    sortedArr[i] = nums1[ptr1];
                    ptr1 += 1;
                } else {
                    sortedArr[i] = nums2[ptr2];
                    ptr2 += 1;
                }

            } else if (ptr1 < nums1.length) {
                sortedArr[i] = num1[ptr1];
                ptr1 += 1;
            } else {
                sortedArr[i] = num2[ptr2];
                ptr2 += 1;
            }
        }

        if (totalLength % 2 == 0) {
            return (sortedArr[targetIndex] + sortedArr[targetIndex - 1]) / 2;
        } else {
            return sortedArr[targetIndex];
        }
    }
}