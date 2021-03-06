package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class CreateGraph {
    public static void main(String[] args) {
        List<String> shortList = new ArrayList<>(6);
        shortList.addAll(Arrays.asList("house", "mouse", "bot", "bat","cat","rat","mat", "bait", "haft", "shaft"));
        List<String> words = shortList;
        showGraph(createGraph(words));
    }

    public static void showGraph(Map<String, List<String>> graph) {
        List<String> keys = new ArrayList<>(graph.keySet());
        Collections.sort(keys);
        System.out.println("{");
        for (String key : keys) {
            List<String> destinations = graph.get(key);
            Collections.sort(destinations);
            System.out.printf("   %-6s => %s\n", key, destinations.toString());
        }
        System.out.println("}");
    }

    public static Map<String, List<String>> createGraph(Collection<String> words) {
        Map<String, List<String>> graph = new HashMap<>();
        if (words.size() == 0)
            return graph;

        words.forEach(word -> {
            List<String> transformations = graph.getOrDefault(word, new ArrayList<>());
            HashSet<String> currentWords = new HashSet<>(words);
            currentWords.remove(word);
            int wordLength = word.length();
            for (int i = 0; i < wordLength; i++) {
                char[] chars = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String newWord = new String(chars);
                    if (currentWords.contains(newWord)) {
                        transformations.add(newWord);
                    }

                }
            }
            graph.put(word, transformations);

        });

        return graph;
    }

}
