int maxNumberOfBalloons(char* text) {
    int textSize = strlen(text);
    int symbols[26] = {0};
    for (int i = 0; i < textSize; i++)
        symbols[text[i] - 'a']++;
    symbols['l' - 'a'] >>= 1;
    symbols['o' - 'a'] >>= 1;
    char* balloon = "balon";
    int minCount = textSize;
    for (int i = 0; i < 5; i++) {
        int count = symbols[balloon[i] - 'a'];
        if (count < minCount) minCount = count;
    }
    return minCount;
}