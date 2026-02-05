package java_problems.easy.p0013_roman_to_integer;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 13
 * Title: Roman to Integer
 * Language: Java
 * Topic:Hash Table, Math, String
 */
class Solution {

    public int romanToInt(String s) {
        int result = 0;
        int buf = 0;
        int lastCost = 0;
        for (int i = 0; i < s.length(); i++) {
            int cost = getCost(s.substring(i, i + 1));
            if (cost == 1 || cost == 10 || cost == 100 || cost == 1000) {
                if (lastCost == 0 || lastCost == cost) {
                    buf += cost;
                } else {
                    if (cost < lastCost) {
                        result += buf;
                        buf = cost;
                    } else {
                        buf = cost - buf;
                    }
                }
                lastCost = cost;
            } else {
                if (buf < cost) {
                    result += (cost - buf);
                    buf = 0;
                } else {
                    result += buf + cost;
                    buf = 0;
                }
                lastCost = 0;
            }
        }
        return result + buf;
    }

    private int getCost(String symbol) {
        if (symbol.equals("I")) return 1;
        else if (symbol.equals("V")) return 5;
        else if (symbol.equals("X")) return 10;
        else if (symbol.equals("L")) return 50;
        else if (symbol.equals("C")) return 100;
        else if (symbol.equals("D")) return 500;
        else if (symbol.equals("M")) return 1000;
        return 0;
    }

}