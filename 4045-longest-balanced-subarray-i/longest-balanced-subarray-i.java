class Solution {

    public int longestBalanced(int[] nums) {

        List<SubArray> subArrays = new ArrayList<>();

        for (int n : nums) {
            for (SubArray subArray : subArrays) subArray.next(n);
            subArrays.add(new SubArray(n));
        }

        int result = 0;
        for (SubArray subArray : subArrays) result = max(result, subArray.getResult());
        return result;
    }

    private int max(int a, int b) {
        return a < b ? b : a;
    }

    private static class SubArray {

        private final HashMap<Integer, Integer> evenNumbers;
        private final HashMap<Integer, Integer> oddNumbers;

        private int result = 0;
        private int currentCount = 0;

        public SubArray(int n) {
            evenNumbers = new HashMap<>();
            oddNumbers = new HashMap<>();
            next(n);
        }

        public void next(int n) {
            currentCount++;
            if (isEven(n)) {
                int value = evenNumbers.getOrDefault(n, 0);
                if (value == 0) evenNumbers.put(n, 1);
            } else {
                int value = oddNumbers.getOrDefault(n, 0);
                if (value == 0) oddNumbers.put(n, 1);
            }
            if (evenNumbers.size() == oddNumbers.size()) {
                result = currentCount;
            }
        }

        public int getResult() {
            return result;
        }

        private boolean isEven(int n) {
            return n >> 1 << 1 == n;
        }

    }

}