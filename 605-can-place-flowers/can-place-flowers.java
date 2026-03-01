class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int free = 1;
        for (int can : flowerbed) {
            if (can == 0) free++;
            else free = 0;
            if (2 < free) {
                n--;
                free -= 2;
            }
            if (n == 0) return true;
        }
        if (free == 2 && n == 1) return true;
        return false;
    }
}