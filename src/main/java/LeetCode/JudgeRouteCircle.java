package LeetCode;

public class JudgeRouteCircle {

    public static void main(String[] args) {
        System.out.println(judgeCircle("UDUL"));
    }

    public static boolean judgeCircle(String moves) {
        if (moves.isEmpty()) {
            return false;
        }
        char move[] = moves.toCharArray();
        if (move.length < 2) {
            return false;
        }

        int x = 0, y = 0;

        for (char c : move) {
            x += (c == 'R' ? 1 : 0) + (c == 'L' ? -1 : 0);
            y += (c == 'U' ? 1 : 0) + (c == 'D' ? -1 : 0);
        }

        return x == 0 && y == 0;

        //Better solution than the current one.
//        long lCount = moves.chars().filter(ch -> ch == 'L').count();
//        long rCount = moves.chars().filter(ch -> ch == 'R').count();
//        long uCount = moves.chars().filter(ch -> ch == 'U').count();
//        long dCount = moves.chars().filter(ch -> ch == 'D').count();
//
//        return lCount == rCount && uCount == dCount;
    }
}
