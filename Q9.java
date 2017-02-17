//Determine whether an integer is a palindrome. Do this without extra space.
//
//click to show spoilers.
//Some hints:
//
//Could negative integers be palindromes? (ie, -1)
//
//If you are thinking of converting the integer to string, note the restriction of using extra space.
//
//You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
//ANS: If it overflows, it goes back to the minimum value and continues from there. If it underflows, it goes back to the maximum value and continues from there. or can consider using long type
//There is a more generic way of solving this problem.
public class Solution {

public boolean isPalindrome(int x) {
    if (x<0 || (x!=0 && x%10==0)) return false;
    int rev = 0;
    while (x>rev){
    	rev = rev*10 + x%10;
    	x = x/10;
    }
    return (x==rev || x==rev/10);
}










    public boolean isPalindrome(int x) {
        //reverse no and compare
        long rev=0, temp=x;
        if(x<0){
           return false;//negative number excluded
        }
      //  if(x<10){
      //     return true;//single digit
      //  }
       //get reverse of the number
      while(temp!=0){
        rev=rev*10+(temp%10);
        temp=temp/10;
      }
      return rev == x;
    }
}



/*
       if (x < 0) return false;
       //it is bug if have this line if (x < 10) return true; //for this case, if feeling list it outside can make such
       //corner case handling easier, just list it out
       //this method exceed run time, use digit count instead int scaler = upScaler(x);
       int scaler = (int) Math.pow(10, digitCount(x) - 1);
       //while (x >= 10){  //this is a bug for 1000021; as it will stop checking after first check
       int msb;
       int lsb;
       while (x > 0){  //this will work, it won't return true for 1000021; as it will return 0 for MSB and 2 for LSB after first check
         msb = x / scaler;
         lsb = x % 10;
         //System.out.println("msb is " + msb + " lsb is " + lsb);
         //System.out.println("scaler is " + scaler);
         if (msb != lsb) return false;
         //two lines below are to remove msb and lsb digits
         x %= scaler;
         x /= 10;
         scaler /= 100; //this is because we will return two digits above; MSB and LSB
       }
       return true;
    }
    private int digitCount(int x) {
        int count = 0;
        while(x > 0) {
            count++;
            x /= 10;
        }
        return count;
    }
}*/
