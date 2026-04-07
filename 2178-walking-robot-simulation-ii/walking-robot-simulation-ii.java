class Robot {

    private final int width;
    private final int height;
    private final int perimeter;
    private int direction;
    private final int[] position;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = width + width + height + height - 4;
        this.direction = 0;
        this.position = new int[2];
    }

    public void step(int num) {
        if (perimeter <= num) {
            num %= perimeter;
            if (position[0] == 0 && position[1] == 0)
                direction = 3;
            else if (position[0] == width && position[1] == 0)
                direction = 0;
            else if (position[0] == width && position[1] == height)
                direction = 1;
            else if (position[0] == 0 && position[1] == height)
                direction = 2;
        }
        while (0 < num)
            switch (direction) {
                case 0 -> {
                    position[0] += num;
                    if (width <= position[0]) {
                        direction = 1;
                        num = position[0] - width + 1;
                        position[0] = width - 1;
                    } else num = 0;
                }
                case 1 -> {
                    position[1] += num;
                    if (height <= position[1]) {
                        direction = 2;
                        num = position[1] - height + 1;
                        position[1] = height - 1;
                    } else num = 0;
                }
                case 2 -> {
                    position[0] -= num;
                    if (position[0] < 0) {
                        direction = 3;
                        num = -position[0];
                        position[0] = 0;
                    } else num = 0;
                }
                case 3 -> {
                    position[1] -= num;
                    if (position[1] < 0) {
                        direction = 0;
                        num = -position[1];
                        position[1] = 0;
                    } else num = 0;
                }
            }
    }

    public int[] getPos() {
        return position;
    }

    public String getDir() {
        return switch (direction) {
            case 1 -> "North";
            case 2 -> "West";
            case 3 -> "South";
            default -> "East"; // 0
        };
    }

}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */