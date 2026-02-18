package java_problems.medium.p2470_removing_stars_from_a_string;

class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int stars = 0;
        for (int i = s.length() - 1; 0 <= i; i--) {
            char c = s.charAt(i);
            if (c == '*') stars++;
            else if (0 < stars) stars--;
            else sb.insert(0, c);
        }
        return sb.toString();
    }
}