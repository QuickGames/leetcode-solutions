package java_problems.medium.p1415;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 1415
 * Title: The k-th Lexicographical String of All Happy Strings of Length n
 * Language: Java
 * Topic: Staff, String, Backtracking, Biweekly Contest 24
 */
class Solution {

    public String getHappyString(int n, int k) {

        int n2 = pow2(n - 1);
        int maxK = 3 * n2;
        if (maxK < k) return "";

        k--;
        int nextChars = k / n2;
        char[][] chars = new char[][]{{'b', 'c'}, {'a', 'c'}, {'a', 'b'}};
        StringBuilder result = new StringBuilder(switch (nextChars) {
            case 0 -> "a";
            case 1 -> "b";
            default -> "c";
        });

        k %= n2;
        n2 >>= 1;
        for (int i = 1; i < n; i++) {
            int index = k / n2;
            char c = chars[nextChars][index];
            result.append(c);
            nextChars = switch (c) {
                case 'a' -> 0;
                case 'b' -> 1;
                default -> 2;
            };
            k -= n2 * index;
            n2 >>= 1;
        }

        return result.toString();
    }

    private int pow2(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++)
            result *= 2;
        return result;
    }

}
