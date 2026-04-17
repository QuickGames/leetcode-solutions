class Solution {
    
    public int minMirrorPairDistance(int[] nums) {
        int result = Integer.MAX_VALUE;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], null);
            if (list == null) {
                list = new ArrayList<>();
                map.put(nums[i], list);
            }
            list.add(i);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int reverseValue = reverse(nums[i]);

            List<Integer> list = map.getOrDefault(reverseValue, null);
            if (list != null) {
                for (int index : list) {
                    if (index <= i) continue;
                    result = Math.min(result, index - i);
                    break;
                }
            }
            if (result == 1) break;
        }

        return (result == Integer.MAX_VALUE ? -1 : result);
    }

    private int reverse(int source) {
        int result = 0;
        while (0 < source) {
            result *= 10;
            result += source % 10;
            source /= 10;
        }
        return result;
    }

}