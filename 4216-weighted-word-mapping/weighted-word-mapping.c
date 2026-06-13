char* mapWordWeights(char** words, int wordsSize, int* weights, int weightsSize) {
    char* result = malloc(sizeof(char) * (wordsSize + 1));
    result[wordsSize] = '\0';
    for(int i = 0; i < wordsSize; i++) {
        char* word = words[i];
        int len = strlen(word);
        int sum = 0;
        for (int j = 0; j < len; j++) {
            char c = word[j];
            sum += weights[c - 'a'];
        }
        sum %= 26;
        result[i] = 'z' - sum;
    }
    return result;
}