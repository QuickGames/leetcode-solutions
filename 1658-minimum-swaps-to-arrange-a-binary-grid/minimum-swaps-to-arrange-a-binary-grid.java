class Solution {
    
    private int result = 0;

    public int minSwaps(int[][] grid) {
        this.result = 0;

        boolean isStartOk = true;
        boolean[] isRows = new boolean[grid.length];
        Element[] elements = new Element[grid.length];
        for (int i = 0; i < grid.length; i++) {
            Element element = new Element(grid[i]);
            List<Integer> rows = element.getRows();
            for (int row : rows) isRows[row] = true;
            if (i < element.minRow) isStartOk = false;
            elements[i] = element;
        }
        if (isStartOk) return 0;
        for (boolean isRow : isRows) if (!isRow) return -1;

        for (int i = 0; i < elements.length; i++)
            if (i < elements[i].minRow) {
                boolean res = recSwap(elements, i, i);
                if (!res) return -1;
                i--;
            }
        return result;
    }

    private boolean recSwap(Element[] elements, int index, int req) {
        boolean res = (index + 1 < elements.length);
        if (!res) return res;
        if (req < elements[index + 1].minRow)
            res = recSwap(elements, index + 1, req);
        swap(elements, index, index + 1);
        return res;
    }

    private void swap(Element[] elements, int index1, int index2) {
        Element buf = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = buf;
        result++;
    }

    private static class Element {

        private final List<Integer> rows;
        private final int minRow;

        Element(int[] nums) {
            this.rows = new ArrayList<>();
            int minRow = Integer.MAX_VALUE;
            for (int i = nums.length - 1; 0 <= i; i--) {
                if (nums[i] == 0) {
                    rows.addFirst(i);
                    minRow = Math.min(minRow, i);
                } else if (nums[i] == 1) {
                    rows.addFirst(i);
                    minRow = Math.min(minRow, i);
                    break;
                }
            }
            this.minRow = minRow;
        }

        public List<Integer> getRows() {
            return rows;
        }

    }

}