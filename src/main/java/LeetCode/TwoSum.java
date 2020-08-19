package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

        String message = "Hello World!";
        String newM= message.substring(6,12) + message.substring(12,6);
        System.out.println(newM);

    }


    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length < 2) {
            return result;
        }
        Map<Integer, Integer> resultSet = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (resultSet.containsKey(target - numbers[i])) {
                result[1] = i ;
                result[0] = resultSet.get(target - numbers[i]);
                return result;
            }
            resultSet.put(numbers[i], i);
        }

        return result;
    }
}
