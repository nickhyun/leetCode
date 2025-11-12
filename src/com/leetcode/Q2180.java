package com.leetcode;

/***
 2180. Count Integers With Even Digit Sum

 Given a positive integer num, return the number of positive integers less than or equal to num whose digit sums are even.

 The digit sum of a positive integer is the sum of all its digits.



 Example 1:

 Input: num = 4
 Output: 2
 Explanation:
 The only integers less than or equal to 4 whose digit sums are even are 2 and 4.
 Example 2:

 Input: num = 30
 Output: 14
 Explanation:
 The 14 integers less than or equal to 30 whose digit sums are even are
 2, 4, 6, 8, 11, 13, 15, 17, 19, 20, 22, 24, 26, and 28.


 Constraints:

 1 <= num <= 1000

 */
public class Q2180 extends QBase{

    public static void main(String[] args){
        Q2180 q = new Q2180();
        log(q.countEven(4)); // 2
        log(q.countEven(30)); // 14

    }

    public int countEven(int num) {
        int count = 0;
        for(int i = 1; i <= num; i++){
            if(isEven(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isEven(int num){
        return digitSum(num) % 2 == 0;
    }

    private int digitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
