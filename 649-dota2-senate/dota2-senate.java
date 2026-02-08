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
}