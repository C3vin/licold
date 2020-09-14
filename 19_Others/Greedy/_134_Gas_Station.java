class Solution {
    
    public int canCompleteCircuit(int[] gas, int[] cost) {

            int sumGas = 0;
            int sumCost = 0;
        
            int start = 0;
            int curr = 0;

            for (int i = 0; i < gas.length; i++) {

                sumGas += gas[i];
                sumCost += cost[i];

                curr += gas[i] - cost[i];

                if (curr < 0) {
                    start = i + 1;
                    curr = 0;
                }
            }

            if (sumGas < sumCost) return -1;
            else return start;     
    }
}

/*
1, if sum of gas is more than sum of cost, then there must be a solution. And the question guaranteed that the solution is unique(The first one I found is the right one).
2, The tank should never be negative, so restart whenever there is a negative number.
*/