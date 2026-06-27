int cmp(const void *a, const void *b) {
    return (*(const int*)a - *(const int*)b);
}

int maximumLength(int* nums, int numsSize) {
    qsort(nums, numsSize, sizeof(int), cmp);
    // 0 - number, 1 - count.
    int pairs[numsSize][2];
    int pairsSize = 0;
    int last = nums[0] - 1;
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] == last) {
            pairs[pairsSize - 1][1]++;
        } else {
            pairs[pairsSize][0] = nums[i];
            pairs[pairsSize][1] = 1;
            pairsSize++;
        }
        last = nums[i];
    }

    int result = 1;

    // 0 - find number, 1 - yet count, 2 - is ending onсe.
    long long cache[pairsSize][3];
    int cacheSize = 0;
    int i = 0;
    if (pairs[0][0] == 1) {
        i = 1;
        result = pairs[0][1] + ((pairs[0][1] & 1) == 1 ? 0 : -1);
    }
    for (; i < pairsSize; i++) {
        long long n = pairs[i][0];
        if (pairs[i][1] == 1) {
            if (cacheSize == 0) continue;
            else {
                for (int c = 0; c < cacheSize; c++) {
                    if (cache[c][0] == n)
                        cache[c][2] = 1;
                }
            }
        } else {
            for (int c = 0; c < cacheSize; c++) {
                if (cache[c][0] == n) {
                    cache[c][0] *= cache[c][0];
                    cache[c][1]++;
                    cache[c][2] = 0;
                }
            }
            cache[cacheSize][0] = n * n;
            cache[cacheSize][1] = 1;
            cache[cacheSize][2] = 0;
            cacheSize++;
        }
    }

    for (int i = 0; i < cacheSize; i++) {
        int count = cache[i][1] + (cache[i][2] == 0 ? -1 : 0);
        count <<= 1;
        count++;
        if (result < count)
            result = count;
    }
    return result;
}