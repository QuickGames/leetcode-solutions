char processStr(char* s, long long k) {
    int sSize = strlen(s);
    long long endSize = 0;
    int newStart = 0;
    for (int i = 0; i < sSize; i++) {
        switch (s[i]) {
            case '*':
                endSize--;
                if (endSize < 0) endSize = 0;
                break;
            case '#':
                endSize <<= 1;
                break;
            case '%':
                break;
            default:
                endSize++;
        }
        if (endSize == 0) newStart = i;
    }
    if (endSize <= k) return '.';

    for (int i = sSize - 1; newStart <= i; i--) {
        switch (s[i]) {
            case '*':
                endSize++;
                break;
            case '#':
                endSize >>= 1;
                if (endSize <= k) k -= endSize;
                break;
            case '%':
                k = endSize - k - 1;
                break;
            default:
                endSize--;
                if (endSize <= k) return s[i];
        }
    }
    return '.';
}