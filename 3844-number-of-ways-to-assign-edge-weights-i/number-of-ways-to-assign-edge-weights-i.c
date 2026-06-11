int assignEdgeWeights(int** edges, int edgesSize, int* edgesColSize) {

    for (int i = 0; i < edgesSize; i++) {
        int* edge = edges[i];
        if (edge[1] < edge[0]) {
            int n = edge[0];
            edge[0] = edge[1];
            edge[1] = n;
        }
    }

    int nodesSize = edgesSize + 2;

    int nodeCounters[nodesSize];
    memset(nodeCounters, 0, sizeof(nodeCounters));
    for (int i = 0; i < edgesSize; i++)
        nodeCounters[edges[i][0]]++;

    int dist[nodesSize];
    dist[0] = 0;
    for (int i = 1; i < nodesSize; i++)
        dist[i] = dist[i - 1] + nodeCounters[i - 1];
    
    int sortedEdges[edgesSize][2];
    for (int i = 0; i < edgesSize; i++) {
        int* edge = edges[i];
        int parent = edge[0];
        int index = dist[parent]++;
        sortedEdges[index][0] = edge[0];
        sortedEdges[index][1] = edge[1];
    }
    
    int depthes[nodesSize];
    memset(depthes, 0, sizeof(depthes));

    int maxDepth = 0;
    for (int i = 0; i < edgesSize; i++) {
        int* edge = sortedEdges[i];
        int parentDepth = depthes[edge[0]];
        int childDepth = parentDepth + 1;
        depthes[edge[1]] = childDepth;
        if (maxDepth < childDepth) maxDepth = childDepth;
    }

    int pow = maxDepth - 1;
    if (pow == 0) return 1;

    int modulo = 1000000007;
    long long result = 2;
    long long factor = 1;
    while (1 < pow) {
        if (pow & 1) {
            factor *= result;
            if (modulo < factor) factor %= modulo;
            pow--;
        } else {
            result *= result;
            if (modulo < result) result %= modulo;
            pow >>= 1;
        }
    }
    result *= factor;
    if (modulo < result) result %= modulo;

    return (int)result;
}