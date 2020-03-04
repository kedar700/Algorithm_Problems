package LeetCode;


import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int nums1[] = {1, 2, 2, 1};
        int nums2[] = {2, 2};
        int result[] = intersection(nums1, nums2);
        for (int i : result) {
            System.out.println(i);
        }
        ;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        for (int secondValue : nums2) {
            set1.add(secondValue);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (set1.contains(nums1[i])) {
                resultSet.add(nums1[i]);
            }
        }
        int[] intersection = new int[resultSet.size()];
        int j = 0;
        Iterator<Integer> it = resultSet.iterator();
        while (it.hasNext()) {
            intersection[j] = it.next();
            j++;
        }
        return intersection;
    }
}
