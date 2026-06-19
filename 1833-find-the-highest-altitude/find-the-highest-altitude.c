int largestAltitude(int* gain, int gainSize) {
    int current = 0;
    int result = 0;
    for (int i = 0; i < gainSize; i++) {
        current += gain[i];
        if (result < current) result = current;
    }
    return result;
}