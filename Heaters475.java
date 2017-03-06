Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.



解法一：超时的做法。将所有的取暖器放入一个map中，然后对每个house，尝试在其坐标+j和-j（从1开始递增）的位置寻找取暖器（在map中搜索），如果找到，那么这个j就是这个house的最小半径。最后，对每个house的最小半径再求最小值。这种做法虽然简单容易理解，但是性能并不高，尤其在数字较大时，很容易超时，因为每个house都是递增+j-j的搜索取暖器。

public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(houses);
    Arrays.sort(heaters);

    int posMin = houses[0] > heaters[0] ? heaters[0] : houses[0];
    int posMax = houses[houses.length - 1] > heaters[heaters.length - 1] ? houses[houses.length - 1] : heaters[heaters.length - 1];

    HashMap<Integer, Boolean> heaterMap = new HashMap<Integer, Boolean>();
    // add to HashMap, to increase search speed.
    for (int i = 0; i < heaters.length; i++) {
        heaterMap.put(heaters[i], true);
    }

    int max = 0;
    for (int i = 0; i < houses.length; i++) {
        int pos = houses[i];
        for (int j = 0; pos - j >= posMin || pos + j <= posMax; j++) {
            // try to search left or right, onece found, judge max and break;
            if (heaterMap.containsKey(pos - j)) {
                max = (max < j? j : max);
                break;
            }
            if (heaterMap.containsKey(pos + j)) {
                max = (max < j? j : max);
                break;
            }
        }
    }

    return max;
}
