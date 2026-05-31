bool asteroidsDestroyed(int mass, int* asteroids, int asteroidsSize) {
    int is[100001] = {0};
    long planet = mass;
    for (int i = 0; i < asteroidsSize; i++)
        is[asteroids[i]]++;
    for (int i = 1; i < 100001; i++) {
        for (int j = 0; j < is[i]; j++) {
            if (planet < i) return false;
            else planet += i;
        }
    }
    return true;
}