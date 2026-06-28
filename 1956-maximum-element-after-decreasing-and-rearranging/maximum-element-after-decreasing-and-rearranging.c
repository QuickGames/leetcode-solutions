int cmp(const void *a, const void *b) {
    return (*(const int*)a - *(const int*)b);
}

int maximumElementAfterDecrementingAndRearranging(int* arr, int arrSize) {
    qsort(arr, arrSize, sizeof(int), cmp);
    arr[0] = 1;

    int max = arrSize;

    int result = arr[arrSize - 1];
    int hp = 0;
    int last = result;
    for (int i = arrSize - 1; 0 <= i; i--) {
        int n = arr[i];
        int currentMax = max - (arrSize - i) + 1;
        if (n < currentMax)
            max -= currentMax - n;
    }
    return max;
}
