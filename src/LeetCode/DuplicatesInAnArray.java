package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesInAnArray {
    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 7, 8, 2, 3, 1};
        findDuplicates(arr).forEach(i -> System.out.println(i));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if (nums.length == 0 || nums == null) {
            return result;
        }

        Set<Integer> resultSet = new HashSet<>();

        for (int num : nums) {
            if (resultSet.contains(num)) {
                result.add(num);
            } else {
                resultSet.add(num);
            }
        }

        return result;
    }
}

