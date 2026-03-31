bool checkStrings(char* s1, char* s2) {
    int length = strlen(s1);

    int frequency1[26];
    int frequency2[26];

    for (int i = 0; i < length; i += 2) {
        frequency2[s1[i] - 'a']++;
        frequency2[s2[i] - 'a']--;
    }
    
    for (int i = 1; i < length; i += 2) {
        frequency1[s1[i] - 'a']++;
        frequency1[s2[i] - 'a']--;
    }

    for (int i = 0; i < 26; i++)
        if (frequency1[i] != 0 || frequency2[i] != 0) return false;

    return true;
}