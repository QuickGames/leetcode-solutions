int numOfStrings(char** patterns, int patternsSize, char* word) {
    int result = 0;
    int wlen = strlen(word);
    int lastResult = 0; // REMOVE.
    for (int i = 0; i < patternsSize; i++) {
        char* pattern = patterns[i];
        int plen = strlen(pattern);
        int pi = 0;
        for (int w = 0; w < wlen; w++) {
            if (pattern[pi] == word[w]) {
                pi++;
                if (pi == plen) {
                    result++;
                    break;
                }
            } else {
                if (0 < pi) w -= pi;
                pi = 0;
            }
        }
        if (lastResult == result)
            printf("%d: %d - %s\n", i, result, pattern);
        lastResult = result;
    }
    return result;
}