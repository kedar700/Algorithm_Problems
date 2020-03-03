package LeetCode;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int inputarray[] = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(inputarray, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList();
        if (!(nums.length >= 0) || nums.length<4) {
            return result;
        }

        Set<List<Integer>> resultSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            int firtNumber = nums[i];
            for (int j = 0; j < nums.length; j++) {
                int secondNumber = nums[j];
                for (int k = 0; k < nums.length; k++) {
                    int thirdNumber = nums[k];

                    for (int l = 0; l < nums.length; l++) {
                        int fourthNumber = nums[l];
                        if ((firtNumber + secondNumber + thirdNumber + fourthNumber) == target) {
                            List<Integer> addToList = Arrays.asList(firtNumber, secondNumber, thirdNumber, fourthNumber);
                            if (resultSet.add(addToList)) {
                                result.add(addToList);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
