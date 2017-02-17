//166. Fraction to Recurring Decimal
//Total Accepted: 23777 Total Submissions: 168477 Difficulty: Medium
//
//Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
//
//If the fractional part is repeating, enclose the repeating part in parentheses.
//
//For example,
//
//    Given numerator = 1, denominator = 2, return "0.5".
//    Given numerator = 2, denominator = 1, return "2".
//    Given numerator = 2, denominator = 3, return "0.(6)".
//
//I don't understand why so many people tends to write "short" java solutions over "clear" java solution when performance stays the same. In order to be a good teammate, one should always write clean code instead of hacky code if performance stays the same.
//

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {







        if (denominator == 0) return null;
        int one = ((numerator > 0 && denominator > 0) || (numerator < 0 && denominator < 0)) ? 1 : -1;
        //since 2's complement, abs of MIN_VALUE; then abs will return the same MIN_VALUE; so has to use long
        long numerL = Math.abs((long) numerator);
        long denomL = Math.abs((long) denominator);
        StringBuilder sb = new StringBuilder();
        long quotient = numerL / denomL;
        sb.append(quotient);
        quotient = numerL % denomL;
        if (quotient != 0) sb.append(".");
        int qIndex = 0;
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        while(quotient != 0){
            quotient *= 10;
            if (!map.containsKey(quotient)){
                map.put(quotient, qIndex++);
            }
            else{
                int repeatIndex = map.get(quotient) + sb.indexOf(".") + 1; //has to be "." make it string
                //as indexOf cannot have char
                sb.insert(repeatIndex, "(");
                sb.append(")");
                break;
            }
            sb.append(quotient / denomL);
            quotient %= denomL;
        }
        if (numerator != 0 && one == -1) sb.insert(0, "-"); // != 0 is for case where numbertor ==0, then no need to have "-"
        return sb.toString();
    }
}
