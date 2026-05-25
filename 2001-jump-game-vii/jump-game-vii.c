bool canReach(char* s, int minJump, int maxJump) {
    
    int length = strlen(s);
    int finish = length - 1;

    if (s[finish] == '1') return false;

    bool is[length];
    for (int i = 0; i < length; i++) is[i] = false;

    int jumps[length];
    jumps[0] = 0;
    int jumpIndex = 0;
    int jumpLength = 1;

    int minIndex = minJump;

    int mj1 = maxJump + 1;
    while (jumpIndex < jumpLength) {
        int index = jumps[jumpIndex];
        int maxIndex = fmin(index + mj1, length);
        int limit = index + minJump;
        for (int i = maxIndex - 1; limit <= i; i--) {
            if (i < minIndex) break;
            if (s[i] == '0' && !is[i]) {
                if (i == finish) return true;
                is[i] = true;
                jumps[jumpLength] = i;
                jumpLength++;
                minIndex = fmax(minIndex, i - minJump);
            }
        }
        jumpIndex++;
    }

    return false;
}