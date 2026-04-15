int closestTarget(char** words, int wordsSize, char* target, int startIndex) {
    int result = -1;
    for (int i = 0; i < wordsSize; i++) {
        int ri = (startIndex + i) % wordsSize;
        int li = (wordsSize + startIndex - i) % wordsSize;
        if (strcmp(words[ri], target) == 0 || strcmp(words[li], target) == 0) return i;
    }
    return result;
}