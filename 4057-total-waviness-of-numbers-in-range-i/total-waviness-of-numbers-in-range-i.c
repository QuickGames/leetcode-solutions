int totalWaviness(int num1, int num2) {
    if (num1 < 101) num1 = 101;
    int result = 0;
    int number[6] = {0};
    int numberSize = 0;
    int k = num1;
    while (0 < k) {
        number[numberSize++] = k % 10;
        k /= 10;
    }
    int numberSize1 = numberSize - 1;
    while (num1 <= num2) {
        for (int j = 1; j < numberSize1; j++) {
            if (number[j - 1] < number[j] && number[j + 1] < number[j]
                    || number[j] < number[j - 1] && number[j] < number[j + 1])
                result++;
        }

        int numberIndex = 0;
        num1++;
        number[numberIndex]++;
        while (10 <= number[numberIndex]) {
            number[numberIndex++] -= 10;
            number[numberIndex]++;
        }
        if (numberSize <= numberIndex) {
            numberSize = numberIndex + 1;
            numberSize1 = numberSize - 1;
        }
    }
    return result;
}