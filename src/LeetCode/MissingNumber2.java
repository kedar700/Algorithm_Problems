package LeetCode;

public class MissingNumber2 {
    public static void main(String[] args) {

    }

    public static int[] missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;


        int repeatedNumber = Math.abs(((nums.length * (nums.length + 1)) - 2 * sum) / 2);
        int missingNumber = Math.abs(((nums.length * (nums.length + 1)) - (2 * sum) - (2 * repeatedNumber)) / 2);
        int result[] = {repeatedNumber, missingNumber};
        return result;
    }
}
