class Solution {
    
    public int[][] merge(int[][] intervals) {

        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {

            int start = interval[0];
            int end = interval[1];

            boolean isPut = true;
            while (isPut) {
                isPut = false;
                for (int[] ints : list) {
                    if (start <= ints[1] && ints[0] <= end) {
                        start = Math.min(ints[0], start);
                        end = Math.max(ints[1], end);
                        isPut = true;
                        list.remove(ints);
                        break;
                    }
                }
            }

            list.add(new int[]{start, end});
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);

        return result;
    }

}