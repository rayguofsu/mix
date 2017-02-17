class Pancakes{
    private void swap(int[] cakes, int i){
        int j = 0;
        while(j < i){
            int tmp = cakes[i];
            cakes[i] = cakes[j];
            cakes[j] = tmp;
            j++;
            i--;
        }
    }
    public void sort(int[] cakes){
        int n = cakes.length-1;
        while(n > 0){
            int maxIndex = findMax(cakes, n);
            if (maxIndex != n){
                // To move at the end, first move maximum
                // number to beginning
                swap(cakes, maxIndex);
                // Now move the maximum number to end by
                // reversing current array
                swap(cakes, n);
            }
            n--;
        }
    }
}

above solution is O(n2); has O(nlogn) algorithm:see below
http://www.geeksforgeeks.org/a-pancake-sorting-question/
class Pancakes{
    public void sort(int[] cakes){
        for (int i = 1; i < cakes.length; i++){
            int j = findInsertBS(cakes, i); //like insertion sort; it is O(NlogN)
            //4 time swap;
            if (j != -1){
                swap(cakes, j-1);
                swap(cakes, i-1);
                swap(cakes, i);
                swap(cakes, j);
            }
        }
    }
    private int findInsertBS(int[] cakes, int i){
        int res = -1;
        int lo = 0;
        int hi = i-1;
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            if (cakes[i] < cakes[mid]){
                res = mid;
                hi = mid - 1;
            }
            else{
                lo = mid+1;
            }
        }
        return res;
    }
}
