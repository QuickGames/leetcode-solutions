class Solution {
    
    public int minScore(int n, int[][] roads) {

        City[] cities = new City[n + 1];
        for (int i = 1; i < cities.length; i++)
            cities[i] = new City(i);
        for (int[] road : roads) {
            City city1 = cities[road[0]];
            City city2 = cities[road[1]];
            int distance = road[2];
            city1.addRoad(city2, distance);
            city2.addRoad(city1, distance);
        }

        int result = Integer.MAX_VALUE;

        boolean[] isCities = new boolean[n + 1];
        City[] buf = new City[n + 1];
        buf[0] = cities[1];
        int bufCount = 1;
        isCities[1] = true;
        for (int bufIndex = 0; bufIndex < bufCount; bufIndex++) {
            City city = buf[bufIndex];

            int minDistance = city.getMinDistance();
            if (minDistance < result)
                result = minDistance;

            List<City> nextCities = city.getCities();
            for (City nextCity : nextCities) {
                int nextCityNumber = nextCity.getNumber();
                if (!isCities[nextCityNumber]) {
                    buf[bufCount++] = nextCity;
                    isCities[nextCity.getNumber()] = true;
                }
            }

        }

        return result;
    }

    private static class City {

        private final int number;
        private final List<City> cities;
        private int minDistance;

        private City(int number) {
            this.number = number;
            this.cities = new ArrayList<>();
            this.minDistance = Integer.MAX_VALUE;
        }

        public int getNumber() {
            return number;
        }

        public List<City> getCities() {
            return cities;
        }

        public int getMinDistance() {
            return minDistance;
        }

        public void addRoad(City city, int distance) {
            if (distance < minDistance)
                minDistance = distance;
            cities.add(city);
        }

    }

}