
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];

            totalGas += gas[i];
            totalCost += cost[i];
            tank += gain;

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return totalGas < totalCost ? -1 : start;
    }
}
