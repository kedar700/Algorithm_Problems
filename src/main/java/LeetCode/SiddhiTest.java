package LeetCode;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result {
    /*
     * Complete the 'stockPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY stocksProfit
     *  2. LONG_INTEGER target
     */
    public static int stockPairs(List<Integer> stocksProfit, long target) {
        if (stocksProfit == null || stocksProfit.size() < 2)
            return 0;
        Map<Long, Long> resultMap = new HashMap<>();
        for (int i = 0; i < stocksProfit.size(); i++) {
            if (!resultMap.containsKey(Long.valueOf(stocksProfit.get(i))))
                resultMap.put(Long.valueOf(stocksProfit.get(i)), 0L);

            resultMap.put(Long.valueOf(stocksProfit.get(i)), resultMap.get(Long.valueOf(stocksProfit.get(i))) + 1);
        }
        int double_final_count = 0;
        for (Long mapKey : resultMap.keySet()) {
            if (resultMap.get(target - mapKey) != null)
                double_final_count += 1;

            if (target - mapKey == mapKey)
                double_final_count--;
        }
        return double_final_count / 2;
    }

    public static int getMaxOccurrences(String components, int minLength, int maxLength, int maxUnique) {

        Map<String, Integer> res = new HashMap<>();
        int n = components.length(), resCnt = 0;
        if(minLength > n) return 0;
        for(int i = 0; i < n; i++){
            Map<Character, Integer> map = new HashMap<>();
            for(int distNum = 0, j = 0; j < maxLength; j++){
                if(i + j >= n) break;
                map.put(components.charAt(i + j), map.getOrDefault(components.charAt(i + j), 0) + 1);
                if(map.get(components.charAt(i + j)) == 1) distNum++;
                if(distNum > maxUnique) break;
                if(j >= minLength - 1)
                    res.put(components.substring(i, i + j + 1), res.getOrDefault(components.substring(i, i + j + 1), 0) + 1);
            }
        }
        for(String str: res.keySet()){
            if(res.get(str) > resCnt)
                resCnt = res.get(str);
        }
        return resCnt;
    }
}

public class SiddhiTest {
    public static void main(String[] args) throws IOException {
        System.out.println(Result.stockPairs(Arrays.asList(407, 1152, 403, 1419, 689, 1029, 108, 128, 1307, 300, 775, 622, 730, 978, 526, 943, 127, 566, 869, 715, 983, 820, 1394, 901, 606, 497, 98, 1222, 843, 600, 1153, 302, 1450, 1457, 973, 1431, 217, 936, 958, 1258, 970, 1155, 1061, 1341, 657, 333, 1151, 790, 101, 588, 263, 101, 534, 747, 405, 585, 111, 849, 695, 1256, 1508, 139, 336, 1430, 615, 1295, 550, 783, 575, 992, 709, 828, 1447, 1457, 738, 1024, 529, 406, 164, 994, 1008, 50, 811, 564, 580, 952, 768, 863, 1225, 251, 1032, 1460), 1558));
//        System.out.println(Result.getMaxOccurrences("abcde", 2, 3, 3));
    }
}














