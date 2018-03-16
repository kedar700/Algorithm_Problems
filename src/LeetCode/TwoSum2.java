package LeetCode;

public class TwoSum2 {

    public static void main(String[] args) {
        int numbers[]={2, 7, 11, 15};
        int target=9;
        int result[] = twoSum(numbers,target);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {

        int result[] = new int[2];
        if (numbers == null || numbers.length < 2) {
            return result;
        }

        int leftIndex = 0;
        int rightIndex = numbers.length - 1;

        while (leftIndex < rightIndex) {
            int finalValue = numbers[leftIndex] + numbers[rightIndex];
            if (finalValue == target) {
                result[0] = leftIndex + 1;
                result[1] = rightIndex + 1;
                return result;
            } else if (finalValue > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        return result;
    }
}
