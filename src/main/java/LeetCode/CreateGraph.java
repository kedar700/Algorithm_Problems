package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateGraph {
    public static void main(String[] args) {
        List<String> shortList = new ArrayList<>(6);
        shortList.addAll(Arrays.asList("house", "mouse", "bat", "bait", "haft", "shaft"));
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
        return graph;
    }
}
