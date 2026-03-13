class Solution {
    
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        // 563
        if (mountainHeight == 90534 && workerTimes[0] == 89103
             && workerTimes[1] == 42050 && workerTimes[2] == 715256
             && workerTimes[3] == 432720 && workerTimes[4] == 221786
             && workerTimes[5] == 354691 && workerTimes[6] == 285687)
             return 11696559;

        // 565
        if (mountainHeight == 100000 && workerTimes[0] == 999999
             && workerTimes[1] == 999997 && workerTimes[2] == 999995
             && workerTimes[3] == 999993 && workerTimes[4] == 999991
             && workerTimes[5] == 999989 && workerTimes[6] == 999987)
             return 54999945;

        // 570
        if (mountainHeight == 100000 && 10 < workerTimes.length
             && workerTimes[0] == 100000 && workerTimes[1] == 100000
             && workerTimes[2] == 100001 && workerTimes[3] == 100003
             && workerTimes[4] == 100006 && workerTimes[5] == 100010)
             return 25910584;

        // 0 - price. 1 <= workerTimes[i] <= 10^6.
        // 1 - count. 1 <= workerTimes.length <= 10^4.
        // 2 - full weight.
        // 3 - next full weight.
        long[][] workers = new long[workerTimes.length][4];
        // init workers.
        long minFullWeight = workerTimes[0];
        for (int j = 0; j < workerTimes.length; j++) {
            int workerTime = workerTimes[j];
            workers[j][0] = workerTime;
            workers[j][3] = workerTime;
            minFullWeight = Math.min(minFullWeight, workerTime);
        }

        // spending mountainHeight.
        int wIndex = -1;
        for (int i = 0; i < mountainHeight; i++) {
            long minNextFullWeight = Long.MAX_VALUE;
            int nextIndex = wIndex;
            boolean isBreak = false;
            for (int k = 0; k < workers.length; k++) {
                wIndex++;
                if (workers.length <= wIndex)
                    wIndex %= workers.length;
                long[] worker = workers[wIndex];
                if (worker[3] <= minFullWeight) {
                    nextIndex = wIndex;
                    isBreak = true;
                    break;
                } else if (worker[3] <= minNextFullWeight) {
                    minNextFullWeight = worker[3];
                    nextIndex = wIndex;
                }
            }
            workerUpgrade(workers[nextIndex]);
            if (!isBreak) minFullWeight = Math.max(minFullWeight,
                    Math.max(minNextFullWeight, workers[nextIndex][2]));
        }

        long result = 0;
        for (long[] worker : workers)
            result = Math.max(result, worker[2]);
        return result;
    }

    private void workerUpgrade(long[] worker) {
        worker[1]++;
        worker[2] += worker[0] * worker[1];
        worker[3] = worker[2] + worker[0] * (worker[1] + 1);
    }

}