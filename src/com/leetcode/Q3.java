package com.leetcode;


/***
 * 문제 3. 중복되지 않는 가장 긴 부분 문자열
 * (난이도: Medium)
 *
 * 문제 설명:
 * 문자열 s가 주어졌을 때, 중복된 문자가 없는 가장 긴 부분 문자열의 길이를 구하시오.
 *
 * 💡 예시:
 * 입력: s = "abcabcbb"
 * 출력: 3
 * 설명: 중복 없이 가장 긴 부분 문자열은 "abc"이며, 길이는 3입니다.
 *
 * 즉, 문자열에서 문자가 반복되지 않는 연속된 구간 중 가장 긴 길이를 찾아야 하는 문제입니다.
 */
public class Q3 {

    public static void print(Object s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        print(q3.lengthOfLongestSubstring("abcabcbb"));
        print(q3.lengthOfLongestSubstring("bbbbb"));
        print(q3.lengthOfLongestSubstring("pwwkew"));
        print(q3.lengthOfLongestSubstring("dvdf")); // exp 3 but 2

    }


    public int lengthOfLongestSubstring(String s) {
        int rtnVal = 0;
        String currentStr = "";
        for (int i = 0; i < s.length(); i++) {
            String currentChar = s.charAt(i) + "";
//            print(currentChar);
            if (!currentStr.contains(currentChar)) {
//                print("X currentStr: " + currentStr);
                currentStr += s.charAt(i);
//                print("X currentStr: " + currentStr);

            } else {
//                print("O currentStr: " + currentStr);
                currentStr = currentStr.substring(
                        currentStr.indexOf(currentChar)+1,
                        currentStr.length()
                ) + currentChar;
//                print("O currentStr: " + currentStr);

            }
            rtnVal = Math.max(rtnVal, currentStr.length());
        }

        return rtnVal;
    }


}
