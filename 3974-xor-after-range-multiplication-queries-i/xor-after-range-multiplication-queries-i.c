int xorAfterQueries(int* nums, int numsSize, int** queries, int queriesSize, int* queriesColSize) {
    int mod = 1000000007;
    for (int i = 0; i < queriesSize; i++) {
        int* query = queries[i];
        for (int j = query[0]; j <= query[1]; j += query[2])
            nums[j] = (int)(((long long)nums[j] * query[3]) % mod);
    }
    int result = nums[0];
    for (int i = 1; i < numsSize; i++)
        result ^= nums[i];
    return result;
}