bool judgeCircle(char* moves) {

    int length = strlen(moves);
    
    int R = 0;
    int L = 0;
    int U = 0;
    int D = 0;

    for (int i = 0; i < length; i++) {
        char c = moves[i];
        switch (c) {
            case 'R':
                R++;
                break;
            case 'L':
                L++;
                break;
            case 'U':
                U++;
                break;
            case 'D':
                D++;
                break;
        }
    }

    return R == L && U == D;
}