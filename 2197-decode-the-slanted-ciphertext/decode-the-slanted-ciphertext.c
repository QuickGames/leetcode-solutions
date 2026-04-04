char* decodeCiphertext(char* encodedText, int rows) {
    int length = strlen(encodedText);
    char* preresult = malloc((length + 1) * sizeof(char));
    int resultLength = 0;
    int resultLengthLast = 0;

    int cols = length / rows;
    for (int i = 0; i < cols; i++) {
        int index = i * rows;
        bool isBreak = false;
        for (int row = 0; row < rows; row++) {
            int bigIndex = i + row * cols + row;
            if (length <= bigIndex){
                isBreak = true;
                break;
            }
            preresult[index + row] = encodedText[bigIndex];
            resultLength++;
            if (encodedText[bigIndex] != ' ') resultLengthLast = resultLength;
        }
        if (isBreak) break;
    }
    preresult[resultLengthLast] = '\0';

    return realloc(preresult, resultLengthLast + 1 * sizeof(char));
}