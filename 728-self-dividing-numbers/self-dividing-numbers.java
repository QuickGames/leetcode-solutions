class Solution {
    
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int n = left; n <= right; n++) {
            int[] digits = getDigits(n);
            boolean isAdd = true;
            for (int digit : digits) {
                if (digit == 0 || 0 < n % digit) {
                    isAdd = false;
                    break;
                }
            }
            if (isAdd) result.add(n);
        }
        return result;
    }

    private int[] getDigits(int value) {
        int[] digits = new int[5];
        int digitsLength = 0;
        while (0 < value) {
            digits[digitsLength++] = value % 10;
            value /= 10;
        }
        return Arrays.copyOf(digits, digitsLength);
    }

}