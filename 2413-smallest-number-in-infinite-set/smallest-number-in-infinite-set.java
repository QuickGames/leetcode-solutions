class SmallestInfiniteSet {

    private int min;
    private final int[] nums;
    private int numsLength;

    public SmallestInfiniteSet() {
        this.min = 1;
        this.nums = new int[1001];
        this.numsLength = 0;
    }

    public int popSmallest() {
        if (numsLength == 0) return min++;
        else return nums[--numsLength];
    }

    public void addBack(int num) {
        if (min <= num) return;
        for (int i = 0; i < numsLength; i++) if (num == nums[i]) return;
        nums[numsLength++] = num;
        for (int i = numsLength - 2; 0 <= i; i--) {
            if (nums[i] < num) {
                nums[i + 1] = nums[i];
                nums[i] = num;
            }
        }
    }

}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */