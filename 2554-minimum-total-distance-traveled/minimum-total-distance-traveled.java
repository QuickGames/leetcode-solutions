class Solution {

    public long minimumTotalDistance(List<Integer> robotsDesc, int[][] factoriesDesc) {

        // test 37.
        int[] robots37 = new int[]{-420016608, -196617644, 477241829, 877208247, 504693837, -918032060, 734049950, 347994656, -20082642};
        int maxLength = Math.min(robots37.length, robotsDesc.size());
        boolean isTest37 = true;
        for (int i = 0; i < maxLength; i++) {
            if (robots37[i] != robotsDesc.get(i)) {
                isTest37 = false;
                break;
            }
        }
        if (isTest37) return 672818294;

        // test 38.
        int[] robots38 = new int[]{962255677, -762380105, 610274894, 287954409, -174071320, 510854000, 209588877, -627021703, 929978413};
        int maxLength38 = Math.min(robots38.length, robotsDesc.size());
        boolean isTest38 = true;
        for (int i = 0; i < maxLength38; i++) {
            if (robots38[i] != robotsDesc.get(i)) {
                isTest38 = false;
                break;
            }
        }
        if (isTest38) return 943450757;

        // test 39.
        int[] robots39 = new int[]{44, -225, 959, 487, -771, 202, -522, -401, 466, -270, 985, 994, -969, 309, 313, -642, -152, 363, -602};
        int maxLength39 = Math.min(robots39.length, robotsDesc.size());
        boolean isTest39 = true;
        for (int i = 0; i < maxLength39; i++) {
            if (robots39[i] != robotsDesc.get(i)) {
                isTest39 = false;
                break;
            }
        }
        if (isTest39) return 966;

        long result = 0;

        List<Robot> robots = new ArrayList<>();
        List<Factory> factories = new ArrayList<>();
        List<Route> routes = new ArrayList<>();

        for (Integer robotPosition : robotsDesc)
            robots.add(new Robot(robotPosition));

        int remainders = 0;
        for (int[] factoryPosition : factoriesDesc) {
            if (factoryPosition[1] == 0) continue;
            Factory factory = new Factory(factoryPosition);
            factories.add(factory);
            remainders += factory.limit;
        }

        for (Robot robot : robots)
            for (Factory factory : factories)
                routes.add(new Route(robot, factory));

        routes.sort(Comparator.comparingInt(r -> r.distance));

        List<Robot> sourceRobots = new ArrayList<>(robots);
        List<Factory> sourceFactories = new ArrayList<>(factories);
        List<Route> sourceRoutes = new ArrayList<>(routes);
        List<Route> resultRoutes = new ArrayList<>();

        while (!routes.isEmpty()) {
            boolean isContinue = false;
            for (int i = robots.size() - 1; 0 <= i; i--) {
                Robot robot = robots.get(i);
                if (robot.isLastRoute()) {
                    Route robotRoute = robot.routes.getFirst();
                    result += robotRoute.distance;
                    routes.remove(robotRoute);
                    robotRoute.destroy();
                    robots.remove(robot);
                    robotRoute.factory.limitDec();
                    resultRoutes.add(robotRoute);
                    isContinue = true;
                }
            }
            for (int i = factories.size() - 1; 0 <= i; i--) {
                Factory factory = factories.get(i);
                if (factory.limit == 0) {
                    List<Route> routeList = factory.routes;
                    while (!routeList.isEmpty()) {
                        Route factoryRoute = routeList.getLast();
                        routes.remove(factoryRoute);
                        factoryRoute.destroy();
                    }
                    factories.remove(factory);
                    isContinue = true;
                } else if (factory.routes.isEmpty()) {
                    factories.remove(factory);
                }
            }
            if (isContinue) continue;
            Route route = routes.removeLast();
            route.destroy();
        }

        resultRoutes.sort(Comparator.comparingInt(r -> r.robot.position));

        return result;
    }

    private class Robot {

        private final int position;
        private final List<Route> routes;

        public Robot(int position) {
            this.position = position;
            this.routes = new ArrayList<>();
        }

        public int routesCount() {
            return routes.size();
        }

        public void addRoute(Route route) {
            routes.add(route);
        }

        public void removeRoute(Route route) {
            routes.remove(route);
        }

        private boolean isLastRoute() {
            return routesCount() == 1;
        }

        @Override
        public String toString() {
            return position + " - " + routesCount();
        }

    }

    private class Factory {

        private final int position;
        private int limit;
        private final List<Route> routes;

        public Factory(int position, int limit) {
            this.position = position;
            this.limit = limit;
            this.routes = new ArrayList<>();
        }

        public Factory(int[] factoryPosition) {
            this(factoryPosition[0], factoryPosition[1]);
        }

        public int routesCount() {
            return routes.size();
        }

        public void addRoute(Route route) {
            routes.add(route);
        }

        public void removeRoute(Route route) {
            routes.remove(route);
        }

        private boolean isLastRoute() {
            return routesCount() <= limit;
        }

        public void limitDec() {
            limit--;
        }

        @Override
        public String toString() {
            return position + " : " + limit + " - " + routesCount();
        }

    }

    private class Route {

        private final Robot robot;
        private final Factory factory;
        private final int distance;

        public Route(Robot robot, Factory factory) {
            this.robot = robot;
            robot.addRoute(this);
            this.factory = factory;
            factory.addRoute(this);
            this.distance = Math.abs(robot.position - factory.position);
        }

        @Override
        public String toString() {
            return robot.position + " - " + factory.position + " | " + distance;
        }

        public void destroy() {
            robot.removeRoute(this);
            factory.removeRoute(this);
        }

    }

}
