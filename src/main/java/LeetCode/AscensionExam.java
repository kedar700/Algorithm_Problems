package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AscensionExam {
    public static void main(String[] args) {
        List<Integer> exampleList = Arrays.asList(400, 1000, 68, 9, 32, 3, 36);
    }

    /**
     * 968400363321000
     * @param listOfNumbers
     * @return
     */
    public String largestNumber(List<Integer> listOfNumbers) {
        if (listOfNumbers.size() == 0)
            return "";
        String resultNumber  = "";
        List<String> listConvertedNumbers = listOfNumbers.stream().map(Object::toString).collect(Collectors.toList());
        return null;
    }

}
