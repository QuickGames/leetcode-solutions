class Solution {

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> result = new ArrayList<>();

        List<Integer>[] frequency = new List[1_000_000];
        for (int i = 0; i < nums.length; i++) {
            List<Integer> freqN = frequency[nums[i]];
            if (freqN == null) {
                freqN = new ArrayList<>();
                frequency[nums[i]] = freqN;
            }
            freqN.add(i);
        }

        for (int startIndex : queries) {
            int resultQuery = -1;
            int value = nums[startIndex];
            List<Integer> list = frequency[value];
            if (list != null && 1 < list.size()) {
                resultQuery = Integer.MAX_VALUE;

                int left = 0;
                int right = list.size() - 1;
                int indexInList = (right + left) >> 1;
                while (left <= right) {
                    int listValue = list.get(indexInList);
                    if (listValue < startIndex)
                        left = indexInList + 1;
                    else if (listValue > startIndex)
                        right = indexInList - 1;
                    else break;
                    indexInList = (right + left) >> 1;
                }

                int[] indexes = new int[]{(list.size() + indexInList - 1) % list.size(), (indexInList + 1) % list.size()};
                for (int listIndex : indexes) {
                    int index = list.get(listIndex);
                    if (index == startIndex) continue;
                    int dist = Math.abs(startIndex - index);
                    int distDesc = nums.length + (startIndex < index ? startIndex - index : index - startIndex) % nums.length;
                    resultQuery = Math.min(resultQuery, Math.min(dist, distDesc));
                    if (resultQuery == 1) break;
                }
            }
            result.add(resultQuery);
        }

        return result;
    }

}
