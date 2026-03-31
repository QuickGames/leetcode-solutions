class StreamChecker {

    private static class Graph {

        private final HashMap<Character, Graph> graphs;
        private final List<Character> ends;

        public Graph() {
            graphs = new HashMap<>();
            ends = new ArrayList<>();
        }

    }

    private final Graph root;
    private final StringBuilder allQueries;

    public StreamChecker(String[] words) {
        this.root = new Graph();
        for (String word : words) {
            Graph current = root;
            for (int i = 0; i < word.length() - 1; i++) {
                char c = word.charAt(word.length() - i - 1);
                Graph graph = current.graphs.getOrDefault(c, null);
                if (graph == null) {
                    graph = new Graph();
                    current.graphs.put(c, graph);
                }
                current = graph;
            }
            current.ends.add(word.charAt(0));
        }
        this.allQueries = new StringBuilder();
    }

    public boolean query(char letter) {
        allQueries.append(letter);
        Graph current = root;
        for (int i = 0; i < allQueries.length(); i++) {

            int index = allQueries.length() - i - 1;
            char c = allQueries.charAt(index);

            if (current.ends.contains(c)) return true;

            Graph graph = current.graphs.getOrDefault(c, null);
            if (graph == null) return false;

            current = graph;
        }
        return false;
    }

}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */