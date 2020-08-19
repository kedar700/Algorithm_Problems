package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public static void main(String[] args) {
        List<String> output = topKFrequent
                (new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        if (words.length <= 1) {
            return Arrays.asList(words);
        }
        Map<String, Integer> wordCount = new HashMap<>();
        List<String> topWords = new ArrayList<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> wordCount.get(w1).equals(wordCount.get(w2)) ? w2.compareTo(w1) : wordCount.get(w1) - wordCount.get(w2));

        for (String word : wordCount.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }
        while (!heap.isEmpty()) topWords.add(heap.poll());
        Collections.reverse(topWords);
        return topWords;
    }
}
