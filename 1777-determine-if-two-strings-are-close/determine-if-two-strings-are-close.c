bool closeStrings(char* word1, char* word2) {

    int length = strlen(word1);
    int length2 = strlen(word2);
    if (length != length2) return false;

    int freq1[26];
    int freq2[26];
    for (int i = 0; i < 26; i++) {
        freq1[i] = 0;
        freq2[i] = 0;
    }

    for (int i = 0; i < length; i++) {
        freq1[word1[i] - 'a']++;
        freq2[word2[i] - 'a']++;
    }

    int ff1[length + 1];
    int ff2[length + 1];
    for (int i = 0; i < length + 1; i++) {
        ff1[i] = 0;
        ff2[i] = 0;
    }

    for (int i = 0; i < 26; i++) {
        if (freq1[i] == 0 && 0 < freq2[i] || 0 < freq1[i] && freq2[i] == 0) return false;
        ff1[freq1[i]]++;
        ff2[freq2[i]]++;
    }

    for (int i = 0; i < length + 1; i++)
        if (ff1[i] != ff2[i]) return false;

    return true;
}