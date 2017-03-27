    String s = "aabcccdde";
    int cnt = 1;
    char[] c = s.toCharArray();
    String res = "";
    for (int i = 1; i < c.length; i++){
        if (c[i] == c[i - 1]) cnt++;
        else{
           if (cnt == 1){
              res = res + c[i - 1];
           }
           else{
              res = res + String.valueOf(cnt) + c[i - 1];
           }
           cnt = 1;
        }
    }
    if (cnt == 1) res += c[c.length - 1];
    else res += String.valueOf(cnt) + c[c.length - 1];
    System.out.println(res);
