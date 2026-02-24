public class Solution {
    public int[] DailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.Length];
        int last = 0;
        for (int i = 0; i < temperatures.Length - 1; i++){
            if (temperatures[i] == last) {
                result[i] = (result[i - 1] == 0 ? 0 : result[i - 1] - 1);
                continue;
            }
            int finishFay = 0;
            for (finishFay = i; finishFay < temperatures.Length; finishFay++){
                if (0 < (temperatures[finishFay] - temperatures[i])) break;
            }
            if (temperatures.Length <= finishFay) result[i] = 0;
            else result[i] = finishFay - i;
            last = temperatures[i];
        }
        return result;
    }
}