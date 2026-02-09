package java_problems.medium.p0649_dota2_senate;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 649
 * Title: Dota2 Senate
 * Language: Java
 * Topic: Principal, String, Greedy, Queue
 */
class Solution {

    public String predictPartyVictory(String senate) {
        StringBuilder sb = new StringBuilder();

        char r = 'R';
        char d = 'D';

        int cr = 0;
        int cd = 0;

        boolean onlyR = true;
        boolean onlyD = true;

        for (int i = 0; i < senate.length() - 1; i++) {

            char c = senate.charAt(i);
            if (c == r) {
                if (0 < cd) {
                    cd--;
                    continue;
                }
                cr++;
                sb.append(c);
                onlyD = false;
            } else { // (c == d)
                if (0 < cr) {
                    cr--;
                    continue;
                }
                cd++;
                sb.append(c);
                onlyR = false;
            }

        }

        char last = senate.charAt(senate.length() - 1);
        char first = senate.charAt(0);
        if (last == r && cd == 0) {
            cr++;
            String s = sb.toString();
            sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == r) sb.append(r);
                else {
                    if (cr == 0) sb.append(d);
                    else cr--;
                }
            }
            sb.append(last);
            onlyD = false;
        } else if (last == d && cr == 0) {
            cd++;
            String s = sb.toString();
            sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == d) sb.append(d);
                else {
                    if (cd == 0) sb.append(r);
                    else cd--;
                }
            }
            sb.append(last);
            onlyR = false;
        }

        if (onlyD) return "Dire";
        else if (onlyR) return "Radiant";

        return predictPartyVictory(sb.toString());
    }

//    public String predictPartyVictory(String senate) {
//        StringBuilder sb = new StringBuilder();
//
//        char r = 'R';
//        char d = 'D';
//
//        boolean isBlock = false;
//
//        boolean onlyR = true;
//        boolean onlyD = true;
//
//        for (int i = 0; i < senate.length() - 1; i++) {
//            if (isBlock) {
//                isBlock = false;
//                continue;
//            }
//
//            char l = senate.charAt(i);
//            char c = senate.charAt(i + 1);
//            if (l == r && c == r) {
//                sb.append(r);
//                onlyD = false;
//            } else if (l == d && c == d) {
//                sb.append(d);
//                onlyR = false;
//            } else if (l == r && c == d) {
//                sb.append(r);
//                isBlock = true;
//                onlyD = false;
//            } else if (l == d && c == r) {
//                sb.append(d);
//                isBlock = true;
//                onlyR = false;
//            }
//
//        }
//
//        if (!isBlock) {
//            char l = senate.charAt(senate.length() - 1);
//            char c = senate.charAt(0);
//            if (l == r && c == r) {
//                sb.insert(0, r);
//                onlyD = false;
//            } else if (l == d && c == d) {
//                sb.insert(0, d);
//                onlyR = false;
//            } else if (l == r && c == d) {
//                sb.insert(0, r);
//                onlyD = false;
//            } else if (l == d && c == r) {
//                sb.insert(0, d);
//                onlyR = false;
//            }
//        }
//
//        if (onlyD) return "Dire";
//        if (onlyR) return "Radiant";
//
//        return predictPartyVictory(sb.toString());
//
//    }

}
