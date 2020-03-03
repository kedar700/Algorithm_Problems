package LeetCode;

public class MergeTwoArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0) {
            if (nums2.length != 0) {
                nums1 = nums2;
            }
        }
        int p2 = n - 1;
        int p1 = m - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
