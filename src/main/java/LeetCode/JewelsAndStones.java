package LeetCode;

public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    public static int numJewelsInStones(String J, String S) {

        int totalNumberOfJewels = 0;
        if (!J.isEmpty() || !S.isEmpty()) {
            char jewelStones[] = J.toCharArray();
            char stones[] = S.toCharArray();
            for (char jewelStone : jewelStones) {
                for (char stone : stones) {
                    if ((int)jewelStone == (int)stone) {
                        totalNumberOfJewels += 1;
                    }
                }
            }
        }
        return totalNumberOfJewels;
    }
}

