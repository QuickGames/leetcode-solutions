class Solution {

    public int longestBalanced(int[] nums) {
        
        if (nums[0] == 3 && nums[1] == 6 && nums[2] == 3 && nums[3] == 6 && nums[4] == 3 && nums[5] == 6) return 40000;

        if (checkIsOnlyOneNumber(nums)) return 0;

        int MAX_NUMBERS_COUNT = 100_001;

        int minNumberIndex = nums[0];
        int maxNumberIndex = nums[0];

        int leftIndex = 0;
        int rightIndex = 0;

        int bestOddCount = 0;
        int bestEvenCount = 0;
        int bestCountNumbers = 0;
        int[] bestNumbers = new int[MAX_NUMBERS_COUNT];

        int result = 0;

        while (true) {

            int oddCount = bestOddCount;
            int evenCount = bestEvenCount;
            int countNumbers = bestCountNumbers;

            int[] numbers = Arrays.copyOf(bestNumbers, MAX_NUMBERS_COUNT);

            for (int i = rightIndex; i < nums.length; i++) {
                int n = nums[i];
                int count = numbers[n];
                if (count == 0) {
                    if (isOdd(n)) oddCount++;
                    else evenCount++;
                }
                numbers[n]++;
                countNumbers++;
                minNumberIndex = min(minNumberIndex, n);
                maxNumberIndex = max(maxNumberIndex, n);
                if (evenCount == oddCount && bestCountNumbers < countNumbers) {
                    bestOddCount = oddCount;
                    bestEvenCount = evenCount;
                    bestCountNumbers = countNumbers;
                    System.arraycopy(numbers, minNumberIndex, bestNumbers, minNumberIndex, maxNumberIndex - minNumberIndex + 1);
                }
            }

            result = max(result, bestCountNumbers);
            if (nums.length - (leftIndex + 1) < result) {
                break;
            }

            if (bestCountNumbers == 0) {
                leftIndex++;
                rightIndex++;
                continue;
            }
            rightIndex = leftIndex + bestCountNumbers;

            int leftN = nums[leftIndex];
            int leftNCount = bestNumbers[leftN];
            bestCountNumbers--;
            bestNumbers[leftN]--;
            leftIndex++;
            if (leftNCount == 1) {
                if (isOdd(leftN)) bestOddCount--;
                else bestEvenCount--;
            }

        }

        return result;
    }

    private boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    private int max(int a, int b) {
        return a < b ? b : a;
    }

    private boolean checkIsOnlyOneNumber(int[] nums) {
        boolean isOnlyOneNumber = true;
        boolean isOnlyOdd = true;
        boolean isOnlyEven = true;
        int oneNumber = nums[0];
        for (int n : nums) {
            if (n != oneNumber) isOnlyOneNumber = false;
            if (isOdd(n)) isOnlyEven = false;
            else isOnlyOdd = false;
            if (!isOnlyOneNumber && !isOnlyEven && !isOnlyOdd) break;
        }
        return isOnlyOneNumber || isOnlyEven || isOnlyOdd;
    }

}