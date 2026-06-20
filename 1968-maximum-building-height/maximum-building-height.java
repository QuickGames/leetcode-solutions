class Solution {

    public int maxBuilding(int n, int[][] restrictions) {

        if (restrictions.length == 0)
            return n - 1;

        Arrays.parallelSort(restrictions, Comparator.comparingInt(o -> o[0]));

        int[][] heights = new int[restrictions.length + 2][3];
        heights[0][0] = 1;  // index
        heights[0][1] = 0;  // height
        heights[0][2] = 0;  // result
        int heightIndex = 0;
        for (int[] restriction : restrictions) {
            int restIndex = restriction[0];
            int restHeight = restriction[1];

            boolean isContinue = false;
            int difIndex = 0;
            int difHeight = 1;
            while (difIndex < difHeight) {
                difIndex = restIndex - heights[heightIndex][0];
                int maxPointHeight = heights[heightIndex][1] + difIndex;
                if (maxPointHeight < restHeight) {
                    isContinue = true;
                    break;
                }

                difHeight = Math.abs(restHeight - heights[heightIndex][1]);

                if (difIndex < difHeight)
                    heightIndex--;
            }
            if (isContinue) continue;

            int dif = difIndex - difHeight;
            int addHeight = dif / 2;
            int maxHeight = Math.max(heights[heightIndex][1], restHeight);
            int result = maxHeight + addHeight;
            heightIndex++;
            heights[heightIndex][0] = restIndex;
            heights[heightIndex][1] = restHeight;
            heights[heightIndex][2] = result;
        }

        int result = 0;
        int difIndex = n - heights[heightIndex][0];
        if (0 < difIndex)
            result = heights[heightIndex][1] + difIndex;

        for (int i = 0; i <= heightIndex; i++)
            if (result < heights[i][2]) result = heights[i][2];
        return result;
    }

}