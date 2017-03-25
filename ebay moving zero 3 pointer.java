list of numbers, and a number
2,1,5,6,2,4,7,5,3,5 and number is 5


1,2, 2, 3, 4, 5, 5, 5, 7,6
  
  public static int[] rearrangeList(int[] nums, int target){
    //Arrays.sort(list)
    
    if (nums == null || nums.length == 0) return nums;
    int j = 0 , k = 0;
    for (int i = 0; i < nums.length; i++){
       if (nums[i] > target){
          j++;
          continue;
       }
       if (nums[i] == target){
          k++;
          int tmp = nums[i];
          System.arraycopy(nums, i - j, nums, i - j + 1, j);
          nums[i - j] = tmp;
          continue;
       }
       int tmp = nums[i];
       System.arraycopy(nums, i - j - k, nums, i - j - k + 1, j + k);
       nums[i - j - k] = tmp;
       System.out.println("i us " + i + Arrays.toString(nums));
    }
    return nums;
