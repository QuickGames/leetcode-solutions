class Solution {
public:
    bool checkOnesSegment(string s) {
        bool isE = false;
        for (int i = 1; i < s.size(); i++) {
            if (!isE && s.at(i) == '0') isE = true;
            else if (isE && s.at(i) == '1') return false;
        }
        return true;
    }
};