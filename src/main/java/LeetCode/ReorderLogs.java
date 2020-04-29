package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReorderLogs {
    public static void main(String[] args) {
        ReorderLogs reorderLogs = new ReorderLogs();
    }
    public List<String> reorderLines(int logFileSize,List<String> logLines) {
        if (logFileSize < 2) return logLines;
        List<String> letterLogs = new ArrayList<>(), digitLogs = new ArrayList<>();
        separateLetterLogsDigitsLogs(logLines, letterLogs, digitLogs);
        sortLetterLogs(letterLogs);
        return generateOutputFromDifferentLogs(letterLogs, digitLogs);
    }

    public void separateLetterLogsDigitsLogs(
            List<String> logLines,
            List<String> letterLogs,
            List<String> integerLogs
    ) {
        for (String log : logLines) {
            if (Character.isDigit(log.charAt(log.length() - 1))) {
                integerLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }
    }

    public void sortLetterLogs(
            List<String> letterLogs
    ) {
        letterLogs.sort((x,y)-> {
            String s1 = x.substring(x.indexOf(" ") + 1);
            String s2 = y.substring(y.indexOf(" ") + 1);
            return s1.equals(s2) ? x.compareTo(y) : s1.compareTo(s2);
        });
    }

    public List<String> generateOutputFromDifferentLogs(
            List<String> letterLogs,
            List<String> integerLogs
    ) {
        String[] output = new String[letterLogs.size() + integerLogs.size()];
        for (int i = 0; i < letterLogs.size(); i++) {
            output[i] = letterLogs.get(i);
        }
        for (int i = letterLogs.size(); i < output.length; i++) {
            output[i] = integerLogs.get(i - letterLogs.size());
        }
        return Arrays.asList(output);
    }
}
