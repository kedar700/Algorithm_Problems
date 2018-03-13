package LeetCode;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int inputarray[] = {1, 0, -1, 0, -2, 2};
        fourSum(inputarray,0);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<List<Integer>>> resultset = new HashSet<List<List<Integer>>>();

        List<Integer> resultList = new ArrayList<>();
        for (int i =0 ; i< nums.length;  i ++){
           int firstNumber = nums[i];
            for (int j=0;j<nums.length; j++) {
                int secondNumber = nums[j];

            }
        }

        return null;
    }
}
