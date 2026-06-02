int earliestFinishTime(int* landStartTime, int landStartTimeSize, int* landDuration, int landDurationSize, int* waterStartTime, int waterStartTimeSize, int* waterDuration, int waterDurationSize) {
    int result = 4002;

    int landLength = landStartTimeSize;
    int waterLength = waterStartTimeSize;

    int earliestLand = 2001;
    for (int i = 0; i < landLength; i++) {
        int time = landStartTime[i] + landDuration[i];
        earliestLand = fmin(earliestLand, time);
    }
    int earliestWater = 2001;
    for (int i = 0; i < waterLength; i++) {
        int time = waterStartTime[i] + waterDuration[i];
        earliestWater = fmin(earliestWater, time);

        int startTime = fmax(earliestLand, waterStartTime[i]);
        int entTime = startTime + waterDuration[i];
        result = fmin(result, entTime);
    }
    for (int i = 0; i < landLength; i++) {
        int startTime = fmax(earliestWater, landStartTime[i]);
        int entTime = startTime + landDuration[i];
        result = fmin(result, entTime);
    }
    return result;
}