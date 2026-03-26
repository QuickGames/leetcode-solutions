package java_problems.hard.p0135;

/**
 * @author QuickGames
 * @Difficulty: Hard
 * @Number: 135
 * @Title: Candy
 * @Language: Java
 * @Topic: Array, Greedy
 */
class Solution {

    public int candy(int[] ratings) {
        int result = 0;

        int left = 0;
        int lastCandy = 1;
        int last = ratings[0];
        int lastRob = 0;

        for (int i = 0; i < ratings.length; i++) {
            int current = ratings[i];
            if (last > current) {
                if (left == i) {
                    left = i - 1;
                    result -= lastCandy;
                    lastRob = lastCandy;
                    lastCandy = 1;
                }
            } else {
                lastCandy = (last == current ? 1 : lastCandy + 1);
                result += lastCandy;
                if (left < i) {
                    int step = 1;
                    for (; left < i - 1; left++) {
                        result += step;
                        step++;
                    }
                    result += Math.max(step, lastRob);
                }
                left = i + 1;
            }
            last = current;
        }

        if (left < ratings.length) {
            int step = 1;
            for (; left < ratings.length - 1; left++) {
                result += step;
                step++;
            }
            result += Math.max(step, lastRob);
        }

        return result;
    }

}
