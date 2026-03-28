int mySqrt(int x) {

    int left = 0;
    int right = 46341;

    while (1 < right - left) {
        int current = (right + left - 1) / 2 + 1;
        printf("cur: %d; left: %d; right: %d\n", current, left, right);
        int c2 = current * current;
        if (c2 < x) left = current;
        else if (x < c2) right = current;
        else return current;
    }
    
    return left;
}