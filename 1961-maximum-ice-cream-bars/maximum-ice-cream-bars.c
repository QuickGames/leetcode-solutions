int maxIceCream(int* costs, int costsSize, int coins) {

    int allCosts[100001] = {0};
    for (int i = 0; i < costsSize; i++)
        allCosts[costs[i]]++;

    int result = 0;
    for (int i = 1; i < 100001 && 0 < coins && i <= coins;) {
        if (allCosts[i] == 0) {
            i++;
        } else {
            coins -= i;
            allCosts[i]--;
            result++;
        }
    }
    return result;
}