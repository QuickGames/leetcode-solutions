package java_problems.medium.p1386;

import java.util.HashMap;
import java.util.Map;

/**
 * @author QuickGames
 * Difficulty: medium
 * Number: 1386
 * Title: Cinema Seat Allocation
 * Language: Java
 * Topic: Senior, Array, Hash Table, Greedy, Bit Manipulation, Biweekly Contest 22
 */
class Solution {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int result = 0;

        Map<Integer, boolean[]> seats = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            boolean[] currentSeats = seats.getOrDefault(reservedSeat[0], null);
            if (currentSeats == null) {
                currentSeats = new boolean[10];
                seats.put(reservedSeat[0], currentSeats);
            }
            currentSeats[reservedSeat[1] - 1] = true;
        }

        for (Map.Entry<Integer, boolean[]> row : seats.entrySet()) {
            boolean[] seat = row.getValue();
            if (!seat[1] && !seat[2] && !seat[3] && !seat[4]) {
                result++;
                if (!seat[5] && !seat[6] && !seat[7] && !seat[8])
                    result++;
            } else if (!seat[3] && !seat[4] && !seat[5] && !seat[6])
                result++;
            else if (!seat[5] && !seat[6] && !seat[7] && !seat[8])
                result++;

        }

        int emptyRows = n - seats.size();
        result += emptyRows * 2;

        return result;
    }

}
