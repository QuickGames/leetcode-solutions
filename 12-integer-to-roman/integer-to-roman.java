class Solution {

    public String intToRoman(int num) {
        String result = "";

     //   int[] keys = {1000, 500, 100, 50, 10, 5, 1};
        int[] keys = {1000, 100, 10, 1};
        for (int i = 0; i < keys.length; i++){
            int key = keys[i];
            int count = num / key;
            num -= (count * key);
            if (key != 1000 && (count == 9)) {
                result += getRomanSymbol(key);
                result += getRomanSymbol(key * 10);
            } else if (key != 1000 && (count == 4)) {
                result += getRomanSymbol(key);
                result += getRomanSymbol(key * 5);
            } else {
                if (4 < count) {
                    count -= 5;
                    result += getRomanSymbol(key * 5);
                    if (count == 0) continue;
                }
                result += getRomanSymbols(key, count);
            }
        }
        return result;
    }

    private String getRomanSymbols(int symbol, int count){
        String result = "";
        for (int i = 0; i < count; i++){
            result += getRomanSymbol(symbol);
        }
        return result;
    }
    private String getRomanSymbol(int symbol){
        switch (symbol) {
            case 1: return "I";
            case 5: return "V";
            case 10: return "X";
            case 50: return "L";
            case 100: return "C";
            case 500: return "D";
            case 1000: return "M";
            default: return "";
        }
    }

}