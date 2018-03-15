package LeetCode;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
     int nums1[] = {1,2,2,1};
     int nums2[] = {2,2};
     int result[] = intersection(nums1, nums2);
        for (int i : result) {
            System.out.println(i);
        };
    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> result = new ArrayList<>();
        int NullArray[] = new int[0];
        Map<Integer, Integer> resultMap = new HashMap<>();

        if (nums1.length == 0 || nums2.length == 0) {
            return NullArray;
        }

        if (nums1.length > nums2.length) {
            for (int i = 0; i < nums1.length; i++) {
                resultMap.put(i, nums1[i]);
            }
        } else if (nums1.length < nums2.length) {
            for (int i = 0; i < nums2.length; i++) {
                resultMap.put(i, nums2[i]);
            }
        } else {
            for (int i = 0; i < nums1.length; i++) {
                resultMap.put(i, nums1[i]);
            }
        }

        int count = 0;
        for (int secondValue : nums2) {
            if (resultMap.containsKey(count) && resultMap.get(count) == secondValue) {
                result.add(secondValue);
            }
            count++;
        }

        int returnedResult[] = result.stream().mapToInt(i -> i).toArray();
        return returnedResult;
    }
}
