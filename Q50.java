50. Pow(x, n)
Total Accepted: 79283 Total Submissions: 285715 Difficulty: Medium

Implement pow(x, n). 

public class Solution { //O(log(n))
  public double myPow(double x, int n) {
    if (x == 0) {
        return 0;
    }
    double res = myPowR(x, Math.abs((long) n));
    return (n < 0) ? 1/res : res;
  }

  private double myPowR(double x, long n){
     //base case
     if (n == 0) return 1;
     //recurse
     double half = myPowR(x, n / 2);
     //build
     half *= half;
     if (n % 2 == 1) half *= x;
     return half;
  }
}













public class Solution { //O(log(n))
  public double myPow(double x, int n) {












    if (x == 0) {
        return 0;
    }
    double res = myPowR(x, Math.abs(n));
    return (n < 0) ? 1/res : res;
  }

  private double myPowR(double x, int n){
     //base case
     if (n == 0) return 1;
     //recurse
     double half = myPowR(x, n / 2);
     //build
     half *= half;
     if (n % 2 == 1) half *= x;
     return half;
  }
}
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double res = powR(x, Math.abs(n));
        return (n<0) ? 1/res : res;
    }
    private double powR(double x, int n){
        if (n == 1) return x;
        double res = powR(x, n/2);
        res *= res;
        if (n % 2 == 1){
            res *= x;
        }
        return res;
    }
}
