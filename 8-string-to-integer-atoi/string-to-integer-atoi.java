class Solution {
    public int myAtoi(String s) {
        boolean isPlus = false;
        boolean isN = false;
        String numbers = "1234567890";
        String result = "";
        for (int i = 0; i < s.length(); i ++) {
            char symbol = s.charAt(i);
            if (-1 < numbers.indexOf(symbol)) {
                result += symbol;
            } else if (symbol == ' ') {
                if (result.length() == 0 && !isPlus) continue;
                else break;
            } else if (symbol == '+') {
                if (isPlus) return 0;
                if (result.length() == 0) {
                    isPlus = true;
                    continue;
                }
                else break;
            } else if (symbol == '-') {
                if (isPlus) break;
                if (result.length() == 0) {
                    result = "-" + result;
                    isN = true;
                }
                else break;
            } else {
                break;
            }
        }
        if (result.length() == 0) return 0;
        if (result.equals("-")) return 0;
        try {return Integer.parseInt(result);}
        catch (Exception e) {return isN ? -2147483648: 2147483647;}
    }
}