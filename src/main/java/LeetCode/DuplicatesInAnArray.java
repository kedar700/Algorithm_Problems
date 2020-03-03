package LeetCode;

import java.util.*;

public class DuplicatesInAnArray {
    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 7, 8, 2, 3, 1};
        findDuplicates(arr).forEach(i -> System.out.println(i));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }
        int[] map = new int[nums.length + 1];
        for (int i : nums) {
            if (map[i] == 1) result.add(i);
            else map[i] = 1;
        }

        //old solution better than 5% people
//        Set<Integer> resultSet = new HashSet<>();
//
//        for (int num : nums) {
//            if (resultSet.contains(num)) {
//                result.add(num);
//            } else {
//                resultSet.add(num);
//            }
//        }

        return result;
    }
}

