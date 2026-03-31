package java_problems.hard.p3474;

/**
 * @author QuickGames
 * @Difficulty: Hard
 * @Number: 3474
 * @Title: Lexicographically Smallest Generated String
 * @Language: Java
 * @Topic: Principal, String, Greedy, String Matching, Weekly Contest 439
 */
class Solution {

    public String generateString(String str1, String str2) {
        char[] result = new char[str1.length() + str2.length() - 1];
        boolean[] isFinal = new boolean[result.length];
        char[] s2 = str2.toCharArray();

        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (c == 'T') {
                for (int j = 0; j < s2.length; j++) {
                    int ij = i + j;
                    if (result[ij] == '\0' || result[ij] == s2[j])
                        result[ij] = s2[j];
                    else return "";
                    isFinal[ij] = true;
                }
            } else {
                if (result[i] == '\0') result[i] = 'a';
            }
        }
        for (int i = str1.length(); i < result.length; i++)
            if (result[i] == '\0') result[i] = 'a';

        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (c == 'F') {
                int maxNotFinal = -1;
                boolean isEquals = true;
                for (int j = 0; j < s2.length; j++) {
                    int ij = i + j;
                    if (!isFinal[ij]) maxNotFinal = ij;
                    if (result[ij] != s2[j]){
                        isEquals = false;
                        break;
                    }
                }
                if (isEquals){
                    if (maxNotFinal == -1) return "";
                    else result[maxNotFinal]++;
                }
            }
        }

        return new String(result);
    }

}
