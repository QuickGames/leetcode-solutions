int removeCoveredIntervals(int** intervals, int intervalsSize, int* intervalsColSize) {

    bool is[intervalsSize];
    for (int i = 0; i < intervalsSize; i++)
        is[i] = false;

    for (int i = 0; i < intervalsSize; i++) {
        int* intI = intervals[i];
        for (int j = 0; j < i; j++) {
            if (is[j]) continue;

            int* intJ = intervals[j];

            if (intI[0] <= intJ[0] && intJ[1] <= intI[1])
                is[j] = true;

            if (intJ[0] <= intI[0] && intI[1] <= intJ[1]) {
                is[i] = true;
                break;
            }

        }
    }

    int result = 0;
    for (int i = 0; i < intervalsSize; i++)
        if (!is[i]) result++;
    return result;
}