package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestTime_After {

    public static void main(String[] args) {

        System.out.println(solution("23:59"));
    }

    public static String solution(String S) {

        List<Integer> numbersInClock = new ArrayList<>();


        String split[] = S.split("");

        for (String s : split) {
            if (!s.equals(":")) {
                numbersInClock.add(Integer.parseInt(s));
            }
        }

        int givenNumber = Integer.parseInt(S.replace(":", ""));
        int givenMinutes = (givenNumber / 100 * 60) + (givenNumber % 100);
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < numbersInClock.size(); i++) {
            int firstNumber = numbersInClock.get(i);
            if (firstNumber <= 2) {
                for (int j = 0; j < numbersInClock.size(); j++) {
                    if (j == i) {
                        continue;
                    }
                    int secondNumber = numbersInClock.get(j);
                    if ((firstNumber == 2 && secondNumber <= 4) || (firstNumber <= 1 && secondNumber <= 9)) {
                        for (int k = 0; k < numbersInClock.size(); k++) {
                            if (k == i || k == j) {
                                continue;
                            }
                            int thirdNumber = numbersInClock.get(k);
                            if (thirdNumber <= 5) {
                                for (int l = 0; l < numbersInClock.size(); l++) {
                                    if (l == i || l == j || l == k) {
                                        continue;
                                    }
                                    int fourthNumber = numbersInClock.get(l);
                                    int nextNumber = Integer.parseInt(String.format("%d%d%d%d", firstNumber, secondNumber, thirdNumber, fourthNumber));
                                    int nextNumberMinutes = (nextNumber / 100 * 60) + (nextNumber % 100);

                                    if (nextNumber != givenNumber) {
                                        map.putIfAbsent(nextNumber, (nextNumberMinutes - givenMinutes) % (24 * 60));
                                    }
                                }
                            }
                        }


                    }
                }
            }
        }


        int minKey = Integer.MAX_VALUE;
        if (map.size() == 0) {
            return S;
        } else {
            int minValue = Integer.MAX_VALUE;

            for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                if (integerIntegerEntry.getValue() <= minValue) {
                    minValue = integerIntegerEntry.getValue();
                    minKey = integerIntegerEntry.getKey();
                }
            }

        }

        String result[] = String.valueOf(minKey).split("");
        if (result.length == 1) {
            return String.format("00:0%s", result[0]);
        }
        if (result.length == 2) {
            return String.format("00:%s%s", result[0], result[1]);
        }
        if (result.length == 3) {
            return String.format("0%s:%s%s", result[0], result[1], result[2]);
        }
        return String.format("%s%s:%s%s", result[0], result[1], result[2], result[3]);
    }
}
