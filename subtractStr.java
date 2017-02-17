/*
 * 从后向前模拟减法，计算每一位的值时，用减数的位减去被减数，再加上10，再减去借位，结果模上10就行了。借位则是看之前的结果是否小于10，如果小于10说明借位了。不过要注意的是，我们要用较大的数减去较小的数，如果减数反而较大，我们要用减数减去被减数，然后结果加上负号。判断两个数的大小的方法，是先判断其长度，如果长度不一样，则较长的较大，如果长度一样，则需要比较每一位。*/


private static String subString(String num1, String num2){
    int len1 = num1.length(), len2 = num2.length();
    // 根据两数的大小关系，决定是直接相减，还是反过来相减取负
    if(len1 > len2){
        return coreSub(num1, num2);
    } else if (len1 < len2){
        return "-"+coreSub(num2, num1);
    } else {
        int compare = num1.compareTo(num2);//len is the same when using compareTo
        if(compare > 0){
            return coreSub(num1, num2);
        } else if(compare < 0){
            return "-"+coreSub(num2, num1);
        } else {
            return "0";
        }
    }
}

private static String coreSub(String num1, String num2){
    int i = num1.length() - 1, j = num2.length() - 1;
    int[] num3 = new int[i + 1];
    int diff = 0, borrow = 0;
    while(i >= 0){
        int d1 = num1.charAt(i) - '0';
        int d2 = j >= 0? num2.charAt(j) - '0': 0;
        // 计算差值时要先加上10
        diff = d1 + 10 - borrow - d2;
        num3[i] = diff % 10;
        borrow = diff < 10 ? 1 : 0;
        i--;
        j--;
    }
    i = 0;
    while(num3[i] == 0){
        i++;
    }
    StringBuilder sb = new StringBuilder();
    while(i < num3.length){
        sb.append(num3[i]);
        i++;
    }
    return sb.toString();
}
