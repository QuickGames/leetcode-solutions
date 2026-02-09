public class Solution {

    private Random random;
    private double x;
    private double y;
    private double radius;

    public Solution(double radius, double x_center, double y_center) {
        this.random = new Random();
        this.x = x_center;
        this.y = y_center;
        this.radius = radius;
    }
    
    public double[] RandPoint() {
        double r = Math.Sqrt(random.NextDouble()) * this.radius;
        double rad = random.NextDouble() * Math.PI * 2d;

        return new double[]{r * Math.Cos(rad) + x, r * Math.Sin(rad) + y};
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.RandPoint();
 */