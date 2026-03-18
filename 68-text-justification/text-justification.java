class Solution {
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int currentSize = -1; // 1 for space.
        int worldsSize = 0; // 1 for space.
        int startIndex = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int nextSize = currentSize + 1 + word.length();
            if (maxWidth < nextSize) {

                int worldsCount = i - startIndex;
                if (worldsCount == 1)
                    result.add(words[startIndex] + " ".repeat(maxWidth - words[startIndex].length()));

                else {
                    int spacesCount = worldsCount - 1;
                    int spaces = maxWidth - worldsSize;
                    int tab = spaces / spacesCount;
                    int tabAdd = spaces % spacesCount;

                    StringBuilder sb = new StringBuilder(words[startIndex]);
                    for (int j = 1; j < worldsCount; j++) {
                        sb.append(" ".repeat(tab));
                        if (0 < tabAdd) {
                            sb.append(" ");
                            tabAdd--;
                        }
                        sb.append(words[startIndex + j]);
                    }
                    result.add(sb.toString());

                }
                startIndex = i;
                worldsSize = word.length();
                currentSize = word.length();
            } else {
                worldsSize += word.length();
                currentSize = nextSize;
            }
        }

        StringBuilder sb = new StringBuilder(words[startIndex]);
        for (int i = startIndex + 1; i < words.length; i++)
            sb.append(" ").append(words[i]);
        sb.append(" ".repeat(maxWidth - sb.length()));
        result.add(sb.toString());

        return result;
    }

}