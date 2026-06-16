char* processStr(char* s) {
    int sourceLength = strlen(s);
    int maxLength = sourceLength;
    char* result = malloc(sizeof(char) * (maxLength + 1));
    int length = 0;
    for (int i = 0; i < sourceLength; i++) {
        char c = s[i];
        switch (c) {
            case '*':
                length--;
                if (length < 0) length = 0;
                break;
            case '#':
                if (maxLength <= length << 1) {
                    maxLength = (maxLength << 1) + 1;
                    result = realloc(result, sizeof(char) * maxLength);
                }
                for (int j = 0; j < length; j++)
                    result[j + length] = result[j];
                length <<= 1;
                break;
            case '%':
                for (int j = 0; j < length >> 1; j++) {
                    char buf = result[j];
                    result[j] = result[length - 1 - j];
                    result[length - 1 - j] = buf;
                }
                break;
            default:
                result[length++] = c;
                if (length == maxLength) {
                    maxLength = (maxLength << 1) + 1;
                    result = realloc(result, sizeof(char) * maxLength);
                }
        }
    }
    result[length] = '\0';
    return result;
}