package java_problems.easy.p0401_binary_watch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author QuickGames
 * Difficulty: Easy
 * Number: 401
 * Title: Binary Watch
 * Language: Java
 * Topic: Junior, Backtracking, Bit Manipulation
 */
class Solution {

    private static class Watch {

        boolean isH8;
        boolean isH4;
        boolean isH2;
        boolean isH1;
        boolean isM32;
        boolean isM16;
        boolean isM8;
        boolean isM4;
        boolean isM2;
        boolean isM1;

        private Watch(Watch watch) {
            this.isH8 = watch.isH8;
            this.isH4 = watch.isH4;
            this.isH2 = watch.isH2;
            this.isH1 = watch.isH1;
            this.isM32 = watch.isM32;
            this.isM16 = watch.isM16;
            this.isM8 = watch.isM8;
            this.isM4 = watch.isM4;
            this.isM2 = watch.isM2;
            this.isM1 = watch.isM1;
        }

        public Watch(int b) {
            switch (b) {
                case 1 -> isH1 = true;
                case 2 -> isH2 = true;
                case 3 -> isH4 = true;
                case 4 -> isH8 = true;
                case 5 -> isM1 = true;
                case 6 -> isM2 = true;
                case 7 -> isM4 = true;
                case 8 -> isM8 = true;
                case 9 -> isM16 = true;
                case 10 -> isM32 = true;
            }
        }

        public boolean add(int b) {
            switch (b) {
                case 1 -> {
                    if (isH1) return false;
                    isH1 = true;
                }
                case 2 -> {
                    if (isH2) return false;
                    isH2 = true;
                }
                case 3 -> {
                    if (isH4) return false;
                    isH4 = true;
                }
                case 4 -> {
                    if (isH8) return false;
                    isH8 = true;
                }
                case 5 -> {
                    if (isM1) return false;
                    isM1 = true;
                }
                case 6 -> {
                    if (isM2) return false;
                    isM2 = true;
                }
                case 7 -> {
                    if (isM4) return false;
                    isM4 = true;
                }
                case 8 -> {
                    if (isM8) return false;
                    isM8 = true;
                }
                case 9 -> {
                    if (isM16) return false;
                    isM16 = true;
                }
                case 10 -> {
                    if (isM32) return false;
                    isM32 = true;
                }
            }
            return !(12 <= getHours() || 60 <= getMinutes());
        }

        public Watch copy() {
            return new Watch(this);
        }

        @Override
        public String toString() {
            String hm = "0" + getMinutes();
            return getHours() + ":" + hm.substring(hm.length() - 2);
        }

        private int is1(boolean b) {
            return b ? 1 : 0;
        }

        private int getHours() {
            return is1(isH8) * 8 + is1(isH4) * 4 + is1(isH2) * 2 + is1(isH1);
        }

        private int getMinutes() {
            return is1(isM32) * 32 + is1(isM16) * 16 + is1(isM8) * 8
                    + is1(isM4) * 4 + is1(isM2) * 2 + is1(isM1);
        }

    }

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn == 0) {
            List<String> result = new ArrayList<>();
            result.add("0:00");
            return result;
        }
        if (9 <= turnedOn) return new ArrayList<>();

        List<Watch> allWatches = new ArrayList<>();
        for (int i = 1; i <= 10; i++) allWatches.add(new Watch(i));

        for (int i = 1; i < turnedOn; i++) {
            List<Watch> currentWatches = new ArrayList<>(allWatches);
            allWatches.clear();
            for (int b = 1; b < 10; b++) {
                for (Watch watch : currentWatches) {
                    Watch newWatch = watch.copy();
                    if (newWatch.add(b)) allWatches.add(newWatch);
                }
            }
        }

        List<String> prePreResult = new ArrayList<>();
        for (Watch watch : allWatches) prePreResult.add(watch.toString());

        Object[] preResult = prePreResult.toArray();
        Arrays.sort(preResult);
        List<String> result = new ArrayList<>();
        String last = "";
        for (Object currentO : preResult) {
            String current = currentO.toString();
            if (!last.equals(current)) result.add(current);
            last = current;
        }
        return result;
    }

}

/*
  Your Solution object will be instantiated and called as such:
  Solution obj = new Solution(m, n);
  int[] param_1 = obj.flip();
  obj.reset();
 */