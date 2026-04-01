class Solution {
    
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        // [][0] - index.
        // [][1] - position.
        // [][2] - health.
        // [][3] - direction.
        int[][] robots = new int[positions.length][4];

        boolean isOnlyR = true;
        boolean isOnlyL = true;
        for (int i = 0; i < positions.length; i++) {

            int dir = (directions.charAt(i) == 'R' ? 1 : -1);
            if (0 < dir) isOnlyL = false;
            else isOnlyR = false;
            robots[i] = new int[]{i, positions[i], healths[i], dir};
        }
        Arrays.sort(robots, Comparator.comparingInt(r -> r[1]));

        if (isOnlyR || isOnlyL) {
            List<Integer> result = new ArrayList<>();
            for (int health : healths) result.add(health);
            return result;
        }

        int[][] rightRobots = new int[robots.length][4];
        int rightRobotsLength = 0;
        for (int[] robot : robots) {
            if (0 < robot[3]) {
                rightRobots[rightRobotsLength++] = robot;
            } else {
                for (int j = rightRobotsLength - 1; 0 <= j; j--) {
                    int[] enemy = rightRobots[j];
                    if (0 < enemy[2]) {
                        if (enemy[3] < 0) break;
                        if (robot[2] < enemy[2]) {
                            robot[2] = 0;
                            enemy[2]--;
                            break;
                        } else if (robot[2] > enemy[2]) {
                            robot[2]--;
                            enemy[2] = 0;
                            rightRobotsLength--;
                        } else {
                            robot[2] = 0;
                            enemy[2] = 0;
                            rightRobotsLength--;
                            break;
                        }
                    }
                }
            }
        }

        int[] robotsHealths = new int[robots.length];
        for (int[] robot : robots)
            robotsHealths[robot[0]] = robot[2];

        List<Integer> result = new ArrayList<>();
        for (int health : robotsHealths)
            if (0 < health) result.add(health);

        return result;
    }

}