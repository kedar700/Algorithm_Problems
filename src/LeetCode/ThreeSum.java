package LeetCode;

import java.util.*;

@SuppressWarnings("Duplicates")
public class ThreeSum {
    public static void main(String[] args) {
        int S[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(S);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0 || nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;

            twoSum(nums, result, i);
        }
        System.out.println(result);
        return result;
    }

    private static void twoSum(int[] nums, List<List<Integer>> result, int i) {
        int leftIndex = i + 1;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            int finalValue = nums[i] + nums[leftIndex] + nums[rightIndex];
            if (finalValue == 0) {
                result.add(Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]));
                while (leftIndex + 1 < rightIndex && nums[leftIndex] == nums[leftIndex + 1])
                    leftIndex++;
                while (rightIndex - 1 > leftIndex && nums[rightIndex] == nums[rightIndex - 1])
                    rightIndex--;
                leftIndex++;
                rightIndex--;
            } else if (finalValue > 0) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
    }

}
