class Solution {
    
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> result = new ArrayList<>();

        for (int asteroid : asteroids) {
            if (0 < asteroid) result.add(asteroid);
            else {
                int resultSize = result.size();
                for (int i = 0; i < resultSize; i++) {
                    int last = result.getLast();
                    if (last < 0) break;
                    if (last < -asteroid) result.removeLast();
                    else if (last == -asteroid) {
                        result.removeLast();
                        asteroid = 0;
                        break;
                    } else {
                        asteroid = 0;
                        break;
                    }
                }
                if (asteroid < 0) result.add(asteroid);
            }
        }

        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            Integer asteroid = result.get(i);
            r[i] = asteroid;
        }
        return r;
    }

}