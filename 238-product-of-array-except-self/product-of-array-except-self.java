class Solution {
    
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int[] positives = new int[31];
        int[] negatives = new int[31];
        int positivesMax = -1;
        int negativesMax = -1;

        for (int num : nums) {
            if (num < 0) {
                negatives[-num]++;
                negativesMax = Math.max(negativesMax, -num);
            } else {
                positives[num]++;
                positivesMax = Math.max(positivesMax, num);
            }
        }

        if (1 < positives[0]) return result;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (0 < positives[0] && num != 0) continue;

            int numResult = 1;
            for (int j = 0; j <= positivesMax; j++) {
                int count = positives[j];
                if (count == 0) continue;
                if (num == j) count--;
                if (0 < count) numResult *= (int) Math.pow(j, count);
            }
            for (int j = 1; j <= negativesMax; j++) {
                int count = negatives[j];
                if (count == 0) continue;
                if (num == -j) count--;
                if (0 < count) numResult *= (int) Math.pow(-j, count);
            }
            result[i] = numResult;
        }

        return result;
    }

}