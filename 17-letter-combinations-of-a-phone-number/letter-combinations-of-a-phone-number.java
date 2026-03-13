class Solution {
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        result.add("");

        for (int i = 0; i < digits.length(); i++) {

            char[] symbols = switch (digits.charAt(i)) {
                case '2' -> new char[]{'a', 'b', 'c'};
                case '3' -> new char[]{'d', 'e', 'f'};
                case '4' -> new char[]{'g', 'h', 'i'};
                case '5' -> new char[]{'j', 'k', 'l'};
                case '6' -> new char[]{'m', 'n', 'o'};
                case '7' -> new char[]{'p', 'q', 'r', 's'};
                case '8' -> new char[]{'t', 'u', 'v'};
                case '9' -> new char[]{'w', 'x', 'y', 'z'};
                default -> new char[0];
            };

            List<String> newList = new ArrayList<>();
            while (!result.isEmpty()) {
                String string = result.removeFirst();
                for (char symbol : symbols)
                    newList.add(string + symbol);
            }
            result.addAll(newList);
        }

        return result;
    }

}