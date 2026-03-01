class Solution {
public:
    int minPartitions(string n) {
        int result = 0;
        for (int i = 0; i < n.length(); i++) {
            int c = n.at(i);
            result = max(result, c - 48);
            if (result == 9) break;
        }
        return result;
    }
private:
    int max(int a, int b) {
        if (a < b) return b;
        else return a;
    }
};