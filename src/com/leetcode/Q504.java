package com.leetcode;

/***
 504. 7진수
 쉬움

 정수 num이 주어지면, 이를 7진수로 표현한 문자열을 반환하세요.

 예제 1:

 입력: num = 100
 출력: “202”
 예제 2:

 입력: num = -7
 출력: “-10”

 -10^7 <= num <= 10^7
 10,000,000
 */
public class Q504 extends QBase {

    public static void main(String[] args) {
        Q504 q504 = new Q504();
        log(q504.convertToBase7(100)); // 202
//        log(q504.convertToBase7(-7)); // -10

    }

    public String convertToBase7(int num) {
        String dir = "";
        if(num < 0) {
            dir = "-";
            num = -num;
        }
        String finStr = "";

        int max7 = 8 ;
        for(int i = 0 ; i < 8 ; i ++) {

            int current = (int) Math.pow(7,max7 - i);
            log(current);
            if((num / current) > 0) {
                finStr += (num / current) + "";
                num = num % current;
            } else {
                finStr += "0";
            }

        }

        finStr += num;


        int res = Integer.parseInt(finStr);

        return dir + res;

    }
}
