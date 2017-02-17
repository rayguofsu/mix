//Given a collection of distinct numbers, return all possible permutations. 
//For example,
//[1,2,3] have the following permutations:
//[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 

//List<Integer> mylist = new ArrayList<Integer>();
//ArrayList<Integer> mylist2 = new ArrayList<Integer>();
//I know that List is an interface that ArrayList class implements.
//
//That's exactly the difference :)
//
//When you're using the two variables (mylist) and (mylist2) in code, you would have access to any methods that ArrayList defines that aren't part of the basic List interface only on mylist2.
//

//First one is called coding to interfaces.
//
//Using the List reference through out your code you can update the concrete implementation to something else like a LinkedList without breaking your client code.
//

//some ppl prefer way 2 when doing things locally




//how to copy arraylist, difference between two ways? (it seems way 1 is more popular)
//way 1 and way 2 both are shallow copy
// way 1: Creating a shallow copy is pretty easy though:
//List<Integer> newList = new ArrayList<Integer>(oldList);
//way 2: clone()



public class Solution {  //similar to cc150 
    //all questions asking for all possible ways; there should be a recursion solution
    //this clearly can be done by base case and build approach
    public List<List<Integer>> permute(int[] nums) {















       if (nums.length == 0) return null;
       return permuteR(nums, nums.length - 1);   
    }

    public List<List<Integer>> permuteR(int[] nums, int c){
      List<List<Integer>> result = new ArrayList<List<Integer>>(); //this way is good, due to above
      //here is the base case
      if (c == 0){
         List<Integer> list = new ArrayList<Integer>();
         list.add(nums[0]);
         result.add(list);
         return result;
      }
      //Build here based on previous result
      List<List<Integer>> oldResult = permuteR(nums, c - 1);
      for (List<Integer> oldList: oldResult){
         for (int j = 0; j <= oldList.size(); j++){//here has the == sign
             List<Integer> newList = insert(oldList, j, nums[c]);
             result.add(newList);
         }
      }
      return result;
    }

    public List<Integer> insert(List<Integer> list, int j, int val){
       List<Integer> newList = new ArrayList<Integer>(list);  //here is to make shallow copy, more popular than doing clone() for shallow copy
       newList.add(j, val);
       return newList;
    }
}
