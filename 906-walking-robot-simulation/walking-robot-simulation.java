class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        // [x][y].
        Map<Integer, Map<Integer, Boolean>> walls = new HashMap<>();

        int[] current = new int[2];

        int result = 0;

        // 0 - up.
        // 1 - left.
        // 2 - down.
        // 3 - right.
        int direction = 0;

        for (int[] obstacle : obstacles) {
            int x = obstacle[0];
            int y = obstacle[1];

            Map<Integer, Boolean> wX = walls.getOrDefault(x, null);
            if (wX == null) {
                wX = new HashMap<>();
                walls.put(x, wX);
            }
            wX.put(y, true);
        }

        for (int command : commands) {
            switch (command) {
                case -2 -> {
                    direction++;
                    if (4 <= direction) direction -= 4;
                }
                case -1 -> {
                    direction--;
                    if (direction < 0) direction += 4;
                }
                default -> {
                    for (int step = 0; step < command; step++) {
                        boolean isBreak = switch (direction) {
                            case 0 -> {
                                // 0 - up.
                                Map<Integer, Boolean> wall = walls.getOrDefault(current[0], null);
                                if (wall == null || !wall.getOrDefault(current[1] + 1, false)) {
                                    current[1]++;
                                    result = Math.max(result, current[0] * current[0] + current[1] * current[1]);
                                    yield false;
                                } else {
                                    yield true;
                                }
                            }
                            case 1 -> {
                                // 1 - left.
                                Map<Integer, Boolean> wall = walls.getOrDefault(current[0] - 1, null);
                                if (wall == null || !wall.getOrDefault(current[1], false)) {
                                    current[0]--;
                                    result = Math.max(result, current[0] * current[0] + current[1] * current[1]);
                                    yield false;
                                } else {
                                    yield true;
                                }
                            }
                            case 2 -> {
                                // 2 - down.
                                Map<Integer, Boolean> wall = walls.getOrDefault(current[0], null);
                                if (wall == null || !wall.getOrDefault(current[1] - 1, false)) {
                                    current[1]--;
                                    int newResult = current[0] * current[0] + current[1] * current[1];
                                    result = Math.max(result, newResult);
                                    yield false;
                                } else {
                                    yield true;
                                }
                            }
                            case 3 -> {
                                // 3 - right.
                                Map<Integer, Boolean> wall = walls.getOrDefault(current[0] + 1, null);
                                if (wall == null || !wall.getOrDefault(current[1], false)) {
                                    current[0]++;
                                    result = Math.max(result, current[0] * current[0] + current[1] * current[1]);
                                    yield false;
                                } else {
                                    yield true;
                                }
                            }
                            default -> false;
                        };
                        if (isBreak) break;
                    }
                }
            }
        }

        return result;
    }
}