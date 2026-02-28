package java_problems.medium.p3579_maximum_possible_number_by_binary_concatenation;

import java.util.Arrays;

/**
 * @author QuickGames
 * Difficulty: Medium
 * Number: 3309
 * Title: Maximum Possible Number by Binary Concatenation
 * Language: Java
 * Topic: Senior, Array, Bit Manipulation, Enumeration, Weekly Contest 418
 */
class Solution {

    public int maxGoodNumber(int[] nums) {

        BitRep[] bits = new BitRep[nums.length];
        for (int i = 0; i < nums.length; i++) bits[i] = new BitRep(nums[i]);

        int[] order = orderBits(bits);
        int result = 0;
        for (int index : order) result = bits[index].concatResult(result);

        return result;
    }

    private int[] orderBits(BitRep[] bits) {

        int[] order = new int[3];
        if (bits[0].compare(bits[1]) == 1) order[1] = 1;
        else order[0] = 1;

        if (bits[order[0]].compare(bits[2]) == -1) {
            order[2] = order[1];
            order[1] = order[0];
            order[0] = 2;
            return order;
        }

        if (bits[order[1]].compare(bits[2]) == -1) {
            order[2] = order[1];
            order[1] = 2;
        } else order[2] = 2;

        return order;
    }

    private static class BitRep {

        private static final int BITS_LENGTH = 8;

        private boolean[] bits;

        BitRep(int source) {
            boolean[] buff = new boolean[BITS_LENGTH];
            int index = 0;
            while (0 < source) {
                buff[BITS_LENGTH - index - 1] = ((source & 1) == 1);
                source >>= 1;
                index++;
            }
            boolean isAdd = false;
            index = 0;
            for (int i = 0; i < BITS_LENGTH; i++) {
                boolean bit = buff[i];
                if (bit && !isAdd) {
                    isAdd = true;
                    bits = new boolean[BITS_LENGTH - i];
                }
                if (isAdd) {
                    bits[index] = bit;
                    index++;
                }
            }
        }

        int compare(BitRep b) {
            for (int i = 0; i < this.bits.length + b.bits.length; i++) {
                boolean thisBit = (this.bits.length <= i
                        ? b.bits[i - this.bits.length] : this.bits[i]);
                boolean bBit = (b.bits.length <= i
                        ? this.bits[i - b.bits.length] : b.bits[i]);
                if (thisBit && !bBit) return 1;
                else if (!thisBit && bBit) return -1;
            }
            if (this.bits.length < b.bits.length) return -1;
            else if (b.bits.length < this.bits.length) return 1;
            return 0;
        }

        int concatResult(int result) {
            for (boolean bit : bits) {
                result <<= 1;
                if (bit) result |= 1;
            }
            return result;
        }

        @Override
        public String toString() {
            return Arrays.toString(bits);
        }

    }

//    public int maxGoodNumber(int[] nums) {
//
//        boolean[][] bits = new boolean[3][BITS_LENGTH];
//
//        for (int i = 0; i < nums.length; i++) {
//
//            int k = nums[i];
//            int index = 0;
//            while (0 < k) {
//                bits[i][BITS_LENGTH - index - 1] = ((k & 1) == 1);
//                k >>= 1;
//                index++;
//            }
//
//        }
//
//        int[] order = orderBits(bits);
//
//        int result = 0;
//        for (int o : order) {
//            boolean isAdd = false;
//            for (int j = 0; j < BITS_LENGTH; j++) {
//                boolean bit = bits[o][j];
//                if (bit) isAdd = true;
//                if (isAdd) {
//                    result <<= 1;
//                    if (bit) result |= 1;
//                }
//            }
//        }
//
//        return result;
//    }
//
//    private int[] orderBits(boolean[][] bits) {
//
//        int[] order = new int[3];
//        int max01 = max(bits[0], bits[1]);
//        if (max01 == 1) {
//            order[0] = 0;
//            order[1] = 1;
//        } else {
//            order[0] = 1;
//            order[1] = 0;
//        }
//
//        int max02 = max(bits[order[0]], bits[2]);
//        if (max02 == -1) {
//            order[2] = order[1];
//            order[1] = order[0];
//            order[0] = 2;
//            return order;
//        }
//
//        int max12 = max(bits[order[1]], bits[2]);
//        if (max12 == 1) {
//            order[2] = order[1];
//            order[1] = 2;
//        } else order[2] = 2;
//
//        return order;
//    }
//
//    private int max(boolean[] a, boolean[] b) {
//        for (int i = 0; i < BITS_LENGTH; i++) {
//            if (a[i] && !b[i]) return 1;
//            if (!a[i] && b[i]) return -1;
//        }
//        return 0;
//    }

}
