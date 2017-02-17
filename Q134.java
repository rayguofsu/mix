134. Gas Station
Total Accepted: 58117 Total Submissions: 214354 Difficulty: Medium

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1. 


public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //reuse gas to represent save[]
        //if new gas = [-1, -2, 3, -2, 1, -3, 25, -6...]
        //when starting from 3, reallizing not able to walk to -3;
        //then do not need to try at 1, as even save >=0 gas before reaching 1 still cannot walk to -3, then it means if starting from 1, it of course cannot walk to -3, so no need to try starting from 1
        
        if (gas == null || cost == null || gas.length == 0 || gas.length != cost.length) return -1;
        for (int i = 0; i < gas.length; i++){
            gas[i] -= cost[i];
        }
        for (int i = 0; i < gas.length; i++){
            if (gas[i] >= 0){
                int index = i;
                int save = gas[i];
                while(save >= 0){
                    if(index != gas.length - 1){
                        index++;
                    }
                    else{
                        index = 0;
                    }
                    if (index == i) return index;
                    save +=gas[index];
                }
                i = (index > i) ? index : i; //this is to make O(N); also it no solution, we do not want to endless tracking; we cannot update i with a smaller i; > is due to wrapping around;
            }
        }
        return -1;
    }
}
