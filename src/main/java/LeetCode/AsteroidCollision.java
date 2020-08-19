package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length == 0)
            return asteroids;
        int[] result = new int[asteroids.length];
        int top = -1;
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                result[++top] = asteroid;
            } else {
                while (top > -1 && result[top] > 0 && result[top] < -asteroid)
                    top--;
                if (top == -1 || result[top] < 0)
                    result[++top] = asteroid;
                else if (result[top] == -asteroid)
                    top--;
            }
        }
        return Arrays.copyOf(result, top + 1);
    }
}
