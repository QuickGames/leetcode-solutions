package java_problems.medium.p1520_number_of_steps_to_reduce_a_number_in_binary_representation_to_one;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 1404
 * Title: Number of Steps to Reduce a Number in Binary Representation to One
 * Language: Java
 * Topic: Senior, String, Bit Manipulation, Simulation, Weekly Contest 183
 */
class Solution {

    public int numSteps(String s) {
        int result = 0;

        int add = 0;
        for (int i = s.length() - 1; 0 <= i; i--) {
            char c = s.charAt(i);
            if (i == 0 && c == '1' && add == 0) break;
            int a = (c == '1' ? 1 : 0) + add;
            add = 0;
            if (2 <= a) {
                add = 1;
                a -= 2;
            }
            if (a == 1) {
                add++;
                result++;
            }
            result++;
        }

        return result;
    }

}
