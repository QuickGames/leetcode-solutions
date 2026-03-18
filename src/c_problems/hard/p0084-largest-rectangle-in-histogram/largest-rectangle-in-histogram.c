int largestRectangleArea(int* heights, int heightsSize) {
    int result = 0;

    int stack[heightsSize + 1][2];
    stack[0][0] = 0;
    stack[0][1] = heights[0];
    int stackCount = 1;

    for (int i = 1; i < heightsSize; i++) {
        if (stack[stackCount - 1][1] < heights[i]) {
            stack[stackCount][0] = i;
            stack[stackCount][1] = heights[i];
            stackCount++;
        } else {
            int lastIndex = stack[stackCount - 1][0];
            for (int j = stackCount - 1; 0 <= j; j--) {
                if (heights[i] <= stack[j][1]) {
                    int s = (i - stack[j][0]) * stack[j][1];
                    if (result < s) result = s;
                    lastIndex = stack[j][0];
                    stackCount--;
                }
            }
            if (heights[i] == 0) stackCount = 0;
            else {
                stack[stackCount][0] = lastIndex;
                stack[stackCount][1] = heights[i];
                stackCount++;
            }
            stack[stackCount][0] = i;
            stack[stackCount][1] = heights[i];
            stackCount++;
        }
    }

    for (int i = 0; i < stackCount; i++) {
        int s = (heightsSize - stack[i][0]) * stack[i][1];
        if (result < s) result = s;
    }

    return result;
}