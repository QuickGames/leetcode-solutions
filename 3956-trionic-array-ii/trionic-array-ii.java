class Solution {

    public long maxSumTrionic(int[] nums) {
        long maxCost = Long.MIN_VALUE;
        List<Trionic> trionics = new ArrayList<>();
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (last < n) {
                trionics.add(new Trionic(last));
                Trionic trionicLast = trionics.getLast();
                for (int j = trionics.size() - 1; 0 <= j; j--) {
                    Trionic trionic = trionics.get(j);
                    if (trionic.getPhase() == 3) {
                        maxCost = Math.max(maxCost, trionic.getCost());
                    }
                    trionic.next(n);
                    if (!trionic.equals(trionicLast)) {
                        if (trionic.getPhase() == trionicLast.getPhase()) {
                            if (trionic.getCost(true) < trionicLast.getCost(true)) {
                                trionics.remove(trionic);
                            } else {
                                trionics.remove(trionicLast);
                                trionicLast = trionic;
                            }
                        } else {
                            trionicLast = trionic;
                        }
                    }
                }
            } else if (last > n) {
                for (Trionic trionic : trionics) trionic.next(n);
            } else { // if (last == n)
                for (Trionic trionic : trionics) trionic.abort();
            }
            last = n;
        }

        for (Trionic trionic : trionics) {
            maxCost = Math.max(maxCost, trionic.getCost());
        }
        return maxCost;
    }

    private static class Trionic {

        private int phase;
        private long cost;
        private int last;

        public Trionic(int last) {
            this.phase = 1;
            this.last = last;
            this.cost = last;
        }

        public int getPhase() {
            return phase;
        }

        public long getCost() {
            if (phase == 3 || phase == 4) return cost;
            else return Long.MIN_VALUE;
        }

        public long getCost(boolean ignoredPhase) {
            if (ignoredPhase) return cost;
            else return getCost();
        }

        public void next(int n) {
            switch (phase) {
                case 1 -> {
                    if (last > n) phase = 2;
                    cost += n;
                }
                case 2 -> {
                    if (last < n) phase = 3;
                    cost += n;
                }
                case 3 -> {
                    if (last > n) phase = 4;
                    else cost += n;
                }
            }
            last = n;
        }

        public void abort() {
            if (phase == 3) phase = 4;
            else {
                phase = -1;
                cost = Long.MIN_VALUE;
            }
        }

        @Override
        public String toString() {
            return "P: " + phase + " C: " + cost;
        }

    }

}