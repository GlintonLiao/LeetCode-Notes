/**
 * Merge two sorted arrays without creating a new array
 * @params m: numbers of the non-0 elements in the nums1
 */
public class Solution {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;

    while (i >= 0 && j >= 0) {
      nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
    }

    // in case the nums2 has more non-0 elements than the nums1
    while (j >= 0) {
      nums1[k--] = nums2[j--];
    } 
  }
}
