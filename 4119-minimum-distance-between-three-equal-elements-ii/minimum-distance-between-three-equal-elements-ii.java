class Solution {
    public int minimumDistance(int[] nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            List<Integer> list = map.getOrDefault(n, null);
            if (list == null) {
                list = new ArrayList<>();
                map.put(n, list);
            }
            list.add(i);
        }

        int result = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() < 3) continue;
            for (int i = 0; i <= list.size() - 3; i++) {
                int distance = Math.abs(list.get(i) - list.get(i + 1))
                               + Math.abs(list.get(i + 1) - list.get(i + 2))
                               + Math.abs(list.get(i + 2) - list.get(i));
                result = Math.min(result, distance);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

}