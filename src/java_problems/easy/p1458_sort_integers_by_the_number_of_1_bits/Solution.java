package java_problems.easy.p1458_sort_integers_by_the_number_of_1_bits;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 1356
 * Title: Sort Integers by The Number of 1 Bits
 * Language: Java
 * Topic: Mid Level, Array, Bit Manipulation, Sorting, Counting, Biweekly Contest 20
 */
class Solution {

    private static class IntBinary {

        private final int value;
        private final int binaryCount1;

        public IntBinary(int value) {
            this.value = value;
            int k = value;
            int count = 0;
            while (0 < k) {
                if ((k & 1) == 1) count++;
                k >>= 1;
            }
            binaryCount1 = count;
        }

        public int getValue() {
            return value;
        }

        public int getBinaryCount1() {
            return binaryCount1;
        }

    }

    public int[] sortByBits(int[] arr) {
        int[] result = new int[arr.length];

        IntBinary[][] groups = new IntBinary[15][arr.length];
        for (int a : arr) {
            IntBinary ib = new IntBinary(a);
            IntBinary[] group = groups[ib.getBinaryCount1()];
            addIbToGroup(group, ib);
        }

        int index = 0;
        for (IntBinary[] group : groups)
            for (IntBinary intBinary : group) {
                if (intBinary == null) break;
                result[index] = intBinary.getValue();
                index++;
            }

        return result;
    }

    private void addIbToGroup(IntBinary[] group, IntBinary ib) {
        int ibValue = ib.getValue();
        IntBinary ibCatch = null;
        for (int i = 0; i < group.length; i++) {
            if (ibCatch != null) {
                IntBinary ibTemp = group[i];
                group[i] = ibCatch;
                ibCatch = ibTemp;
                if (ibCatch == null) break;
            } else if (group[i] == null) {
                group[i] = ib;
                break;
            } else {
                if (ibValue < group[i].getValue()) {
                    ibCatch = group[i];
                    group[i] = ib;
                }
            }
        }
    }

}
