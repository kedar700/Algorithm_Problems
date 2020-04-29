package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

public class popularFeatures {
    public ArrayList<String> popularNFeatures2(int numFeatures,
                                               int topFeatures,
                                               List<String> possibleFeatures,
                                               int numFeatureRequests,
                                               List<String> featureRequests) {
        if (numFeatures == 0 || numFeatureRequests == 0) {
            return new ArrayList<String>();
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (String words : featureRequests) {

            Set<String> added = new HashSet<String>();

            for (String str : words.split("\\s+")) {

                str = str.toLowerCase();
                if (possibleFeatures.contains(str) && !added.contains(str)) {

                    map.put(str, map.getOrDefault(str, 0) + 1);
                    added.add(str);
                }
            }
        }

        List<String> ls = new ArrayList<>(map.keySet());

        ls.sort((a, b) -> (map.get(a)).equals(map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a));

        return new ArrayList<>(ls.subList(0, topFeatures));
    }

    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests) {
        if (numFeatures == 0 || numFeatureRequests == 0) {
            return new ArrayList<String>();
        }
        HashMap<String, Integer> possibleFeatureMap = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        for (String key : possibleFeatures) {
            key = key.toLowerCase();
            possibleFeatureMap.put(key, 0);
        }
        for (String rev : featureRequests) {
            if (rev.length() != 0) {
                rev = rev.toLowerCase();
                String[] splitFeatureRequest = rev.split("\\s+");
                for (String split : splitFeatureRequest) {
                    if (possibleFeatureMap.containsKey(split.toLowerCase()))
                        possibleFeatureMap.put(split, possibleFeatureMap.get(split) + 1);
                }
            }
        }
        try {
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : b.getValue() - a.getValue());
            pq.addAll(possibleFeatureMap.entrySet());
            while (result.size() < topFeatures)
                result.add(Objects.requireNonNull(pq.poll()).getKey());
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }
}
