class Solution {
public:
    int numSpecial(vector<vector<int>>& mat) {
        int result = 0;
        for (int i = 0; i < mat.size(); i++)
            for (int j = 0; j < mat[i].size(); j++)
                if (mat[i][j] == 1 && isOk(mat, i, j)) result++;
        return result;
    }
private:
    bool isOk(vector<vector<int>>& mat, int x, int y) {
        for (int i = 0; i < mat.size(); i++)
            if (i != x && mat[i][y] == 1) return false;
        for (int i = 0; i < mat[0].size(); i++)
            if (i != y && mat[x][i] == 1) return false;
        return true;
    }

};