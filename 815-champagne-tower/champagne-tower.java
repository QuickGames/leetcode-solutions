class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        if (query_row == 0 && query_glass == 0){
            if (1d < poured) return 1d;
            return poured;
        }

        double[][] glasses = new double[100][100];

        glasses[0][0] += poured;
        for (int gRow = 1; gRow < 100; gRow++) {
            for (int gCol = 0; gCol <= gRow; gCol++) {
                double weight = 0d;
                if (0 <= gCol - 1d && 1d < glasses[gRow - 1][gCol - 1]) {
                    weight += glasses[gRow - 1][gCol - 1] - 1d;
                    glasses[gRow - 1][gCol - 1] = 1d;
                }
                if (1d < glasses[gRow - 1][gCol]) {
                    double w2 = (glasses[gRow - 1][gCol] - 1d) / 2d;
                    weight += w2;
                    glasses[gRow - 1][gCol] = 1d + w2;
                }
                glasses[gRow][gCol] += weight;
                if (gRow == query_row && gCol == query_glass) {
                    if (1d < glasses[gRow][gCol]) glasses[gRow][gCol] = 1d;
                    return glasses[gRow][gCol];
                }
            }
        }

        return poured;
    }
}